package org.example;

class Tool {
    private String name;
    private double power;
    private double weight;

    public Tool(String name, double power, double weight) {
        setName(name);
        setPower(power);
        setWeight(weight);
    }

    public String getName() { return name; }
    public double getPower() { return power; }
    public double getWeight() { return weight; }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("название не может быть пустым");
            return;
        }
        this.name = name;
    }

    public void setPower(double power) {
        if (power <= 0) {
            System.out.println("мощность должна быть больше 0");
            return;
        }
        this.power = power;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("вес должен быть больше 0");
            return;
        }
        this.weight = weight;
    }

    public void use() {
        System.out.println("Инструмент используется");
    }

    public void displayInfo() {
        System.out.println("Название: " + getName() +
                ", Мощность: " + getPower() +
                ", Вес: " + getWeight());
    }

    @Override
    public String toString() {
        return "ыname='" + name + "', power=" + power + ", weight=" + weight + "}";
    }
}

class Drill extends Tool {
    private int speed;

    public Drill(String name, double power, double weight, int speed) {
        super(name, power, weight);
        setSpeed(speed);
    }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) {
        if (speed <= 0) {
            System.out.println("скорость должна быть больше 0");
            return;
        }
        this.speed = speed;
    }

    @Override
    public void use() {
        System.out.println("Сверлит отверстия");
    }

    public void changeDrillBit() {
        System.out.println("Смена сверла выполнена");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Скорость: " + getSpeed());
    }

    @Override
    public String toString() {
        return "name='" + getName() + "', power=" + getPower() +
                ", weight=" + getWeight() + ", speed=" + speed + "}";
    }
}

class Saw extends Tool {
    private double bladeLength;

    public Saw(String name, double power, double weight, double bladeLength) {
        super(name, power, weight);
        setBladeLength(bladeLength);
    }

    public double getBladeLength() { return bladeLength; }

    public void setBladeLength(double bladeLength) {
        if (bladeLength <= 0) {
            System.out.println("длина лезвия должна быть больше 0");
            return;
        }
        this.bladeLength = bladeLength;
    }

    @Override
    public void use() {
        System.out.println("Режет материалы");
    }

    public void sharpenBlade() {
        System.out.println("Лезвие заточено");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Длина лезвия: " + getBladeLength());
    }

    @Override
    public String toString() {
        return "Saw{name='" + getName() + "', power=" + getPower() +
                ", weight=" + getWeight() + ", bladeLength=" + bladeLength + "}";
    }
}

public class App {
    public static void main(String[] args) {
        Tool[] tools = {
                new Drill("Bosch", 800, 2.5, 3000),
                new Saw("Makita", 1200, 4.0, 25.0),
                new Drill(" DeWalt", 950, 2.8, 2800),
                new Saw("Hitachi", 1100, 3.5, 30.0),
                new Drill("Metabo", 750, 2.2, 3200)
        };

        for (int i = 0; i < tools.length; i++) {
            tools[i].displayInfo();
            tools[i].use();
            System.out.println();
        }

        for (int i = 0; i < tools.length; i++) {
            if (tools[i] instanceof Drill) {
                ((Drill) tools[i]).changeDrillBit();
            } else if (tools[i] instanceof Saw) {
                ((Saw) tools[i]).sharpenBlade();
            }
        }

        System.out.println();

        for (int i = 0; i < tools.length; i++) {
            System.out.println(tools[i]);
        }
    }
}