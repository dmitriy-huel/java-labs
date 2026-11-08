package org.example;

class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private double price;

    public Laptop(String brand, int ram, int storage, double price) {
        setBrand(brand);
        setRam(ram);
        setStorage(storage);
        setPrice(price);
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("бренд не может быть пустым");
            return;
        }
        this.brand = brand;
    }

    public void setRam(int ram) {
        if (ram <= 0) {
            System.out.println("объём RAM должен быть больше 0");
            return;
        }
        this.ram = ram;
    }

    public void setStorage(int storage) {
        if (storage <= 0) {
            System.out.println("объём накопителя должен быть больше 0");
            return;
        }
        this.storage = storage;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("цена не может быть отрицательной");
            return;
        }
        this.price = price;
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("скидка должна быть от 0 до 100");
            return;
        }
        setPrice(getPrice() - getPrice() * percent / 100);
    }

    public void displayInfo() {
        System.out.println("Бренд: " + getBrand() +
                ", RAM: " + getRam() + " GB" +
                ", Накопитель: " + getStorage() + " GB" +
                ", Цена: " + getPrice());
    }

    @Override
    public String toString() {
        return brand + ram + storage + price;
    }
}
