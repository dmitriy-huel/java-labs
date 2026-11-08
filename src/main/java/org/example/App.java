package org.example;

abstract class Building {
    private String address;
    private int floors;
    private double area;

    public Building(String address, int floors, double area) {
        setAddress(address);
        setFloors(floors);
        setArea(area);
    }

    public String getAddress() { return address; }
    public int getFloors() { return floors; }
    public double getArea() { return area; }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            System.out.println("адрес не может быть пустым");
            return;
        }
        this.address = address;
    }

    public void setFloors(int floors) {
        if (floors <= 0) {
            System.out.println("этажей должно быть больше 0");
            return;
        }
        this.floors = floors;
    }

    public void setArea(double area) {
        if (area <= 0) {
            System.out.println("площадь должна быть больше 0");
            return;
        }
        this.area = area;
    }

    public abstract String getPurpose();
    public abstract int calculateCapacity();

    public void displayInfo() {
        System.out.println("Адрес: " + getAddress() +
                ", Этажей: " + getFloors() +
                ", Площадь: " + getArea() +
                ", Назначение: " + getPurpose() +
                ", Вместимость: " + calculateCapacity() + " чел.");
    }

    @Override
    public String toString() {
        return "Building{address='" + address + "', floors=" + floors + ", area=" + area + "}";
    }
}

class ResidentialBuilding extends Building {
    private int apartments;

    public ResidentialBuilding(String address, int floors, double area, int apartments) {
        super(address, floors, area);
        setApartments(apartments);
    }

    public int getApartments() { return apartments; }

    public void setApartments(int apartments) {
        if (apartments <= 0) {
            System.out.println("квартир должно быть больше 0");
            return;
        }
        this.apartments = apartments;
    }

    @Override
    public String getPurpose() {
        return "Жилой дом";
    }

    @Override
    public int calculateCapacity() {
        return getApartments() * 3;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Квартир: " + getApartments());
    }

    @Override
    public String toString() {
        return "ResidentialBuilding{address='" + getAddress() + "', floors=" + getFloors() +
                ", area=" + getArea() + ", apartments=" + apartments + "}";
    }
}

class OfficeBuilding extends Building {
    private int companies;

    public OfficeBuilding(String address, int floors, double area, int companies) {
        super(address, floors, area);
        setCompanies(companies);
    }

    public int getCompanies() { return companies; }

    public void setCompanies(int companies) {
        if (companies <= 0) {
            System.out.println("компаний должно быть больше 0");
            return;
        }
        this.companies = companies;
    }

    @Override
    public String getPurpose() {
        return "Офисное здание";
    }

    @Override
    public int calculateCapacity() {
        return getCompanies() * 10;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Компаний: " + getCompanies());
    }

    @Override
    public String toString() {
        return "OfficeBuilding{address='" + getAddress() + "', floors=" + getFloors() +
                ", area=" + getArea() + ", companies=" + companies + "}";
    }
}

public class App {
    public static void main(String[] args) {
        Building[] buildings = {
                new ResidentialBuilding("ул. Ленина, 10", 5, 1200.5, 40),
                new ResidentialBuilding("ул. Пушкина, 25", 9, 3000.0, 120),
                new ResidentialBuilding("пр. Мира, 7", 3, 800.0, 24),
                new OfficeBuilding("ул. Гагарина, 1", 12, 5000.0, 15),
                new OfficeBuilding("ул. Советская, 5", 7, 2500.0, 8)
        };

        for (int i = 0; i < buildings.length; i++) {
            buildings[i].displayInfo();
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < buildings.length; i++) {
            System.out.println(buildings[i]);
        }
    }
}