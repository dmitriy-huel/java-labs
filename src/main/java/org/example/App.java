package org.example;

interface Transportable {
    void transport();
    int getCapacity();
}

interface Maintainable {
    void maintain();
    String getServiceDate();
}

class Truck implements Transportable, Maintainable {
    private String brand;
    private int capacity;
    private String serviceDate;

    public Truck(String brand, int capacity, String serviceDate) {
        this.brand = brand;
        this.capacity = capacity;
        this.serviceDate = serviceDate;
    }

    public String getBrand() { return brand; }
    public String getServiceDate() { return serviceDate; }

    @Override
    public void transport() {
        System.out.println("Грузовик " + brand + " перевозит грузы по дороге");
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void maintain() {
        System.out.println("Грузовик " + brand + " проходит техобслуживание");
    }

    @Override
    public String toString() {
        return "Truck{brand='" + brand + "', capacity=" + capacity +
                ", serviceDate='" + serviceDate + "'}";
    }
}

class Ship implements Transportable, Maintainable {
    private String brand;
    private int capacity;
    private double tonnage;

    public Ship(String brand, int capacity, double tonnage) {
        this.brand = brand;
        this.capacity = capacity;
        this.tonnage = tonnage;
    }

    public String getBrand() { return brand; }
    public double getTonnage() { return tonnage; }

    @Override
    public void transport() {
        System.out.println("Корабль " + brand + " перевозит грузы по воде");
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void maintain() {
        System.out.println("Корабль " + brand + " проходит докование");
    }

    @Override
    public String getServiceDate() {
        return "Последнее ТО: 2023-10-15";
    }

    @Override
    public String toString() {
        return "Ship{brand='" + brand + "', capacity=" + capacity +
                ", tonnage=" + tonnage + "}";
    }
}

public class App {
    public static void main(String[] args) {
        Transportable[] transports = {
                new Truck("Volvo", 20, "2024-01-10"),
                new Truck("Scania", 25, "2024-02-15"),
                new Truck("MAN", 18, "2023-12-01"),
                new Ship("Evergreen", 1500, 5000.5),
                new Ship("Maersk", 2000, 7500.0)
        };

        for (int i = 0; i < transports.length; i++) {
            transports[i].transport();
            System.out.println("Грузоподъемность: " + transports[i].getCapacity() + " тонн");
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < transports.length; i++) {
            if (transports[i] instanceof Maintainable) {
                Maintainable m = (Maintainable) transports[i];
                m.maintain();
                System.out.println("Дата обслуживания: " + m.getServiceDate());
                System.out.println();
            }
        }
    }
}