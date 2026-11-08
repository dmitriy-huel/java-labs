package org.example;

class Device {
    private String model;
    private int power;
    private int year;

    public Device(String model, int power, int year) {
        this.model = model;
        this.power = power;
        this.year = year;
    }

    public String getModel() { return model; }
    public int getPower() { return power; }
    public int getYear() { return year; }

    public void turnOn() {
        System.out.println("Включаю");
    }

    public void turnOn(int power) {
        System.out.println("Включаю на мощность " + power);
    }

    public void turnOn(String mode) {
        System.out.println("Включаю в режиме " + mode);
    }

    public String getEnergyClass() {
        return "Средний";
    }

    @Override
    public String toString() {
        return "Device{model='" + model + "', power=" + power + ", year=" + year + "}";
    }
}

class TV extends Device {
    private double screenSize;

    public TV(String model, int power, int year, double screenSize) {
        super(model, power, year);
        this.screenSize = screenSize;
    }

    public double getScreenSize() { return screenSize; }

    @Override
    public String getEnergyClass() {
        return "Высокий";
    }

    public void turnOn(int power, String source) {
        System.out.println("Включаю на мощность " + power + " с источником " + source);
    }

    @Override
    public String toString() {
        return "TV{model='" + getModel() + "', power=" + getPower() +
                ", year=" + getYear() + ", screenSize=" + screenSize + "}";
    }
}

class Fridge extends Device {
    private double volume;

    public Fridge(String model, int power, int year, double volume) {
        super(model, power, year);
        this.volume = volume;
    }

    public double getVolume() { return volume; }

    @Override
    public String getEnergyClass() {
        return "Низкий";
    }

    public void turnOn(int power, boolean quickFreeze) {
        System.out.println("Включаю на мощность " + power + ", быстрая заморозка: " + quickFreeze);
    }

    @Override
    public String toString() {
        return "Fridge{model='" + getModel() + "', power=" + getPower() +
                ", year=" + getYear() + ", volume=" + volume + "}";
    }
}

public class App {
    public static void main(String[] args) {
        Device d = new Device("BaseDevice", 100, 2020);

        System.out.println("Перегрузка в базовом классе:");
        d.turnOn();
        d.turnOn(150);
        d.turnOn("Экономный");
        System.out.println();

        Device[] devices = {
                new TV("Samsung", 120, 2022, 55.0),
                new TV("LG", 100, 2021, 43.0),
                new TV("Sony", 150, 2023, 65.0),
                new Fridge("Bosch", 200, 2020, 350.0),
                new Fridge("Atlant", 180, 2019, 400.0)
        };

        System.out.println("Переопределение методов:");
        for (int i = 0; i < devices.length; i++) {
            System.out.println("Модель: " + devices[i].getModel() +
                    ", Класс энергоэффективности: " + devices[i].getEnergyClass());
        }
        System.out.println();

        System.out.println("Перегрузка в наследниках:");
        TV tv = new TV("Panasonic", 110, 2023, 50.0);
        tv.turnOn();
        tv.turnOn(200);
        tv.turnOn("Кино");
        tv.turnOn(200, "HDMI");

        System.out.println();

        Fridge fridge = new Fridge("Indesit", 190, 2022, 300.0);
        fridge.turnOn();
        fridge.turnOn(250);
        fridge.turnOn("Турбо");
        fridge.turnOn(250, true);

        System.out.println();

        System.out.println("Вывод объектов toString:");
        System.out.println(tv);
        System.out.println(fridge);
    }
}