package org.example;

import java.util.Scanner;

public class App {

    static void task1() {
        System.out.println("Задание 1");
        Laptop laptop = new Laptop("Lenovo", 16, 512, 1500.0);

        System.out.println("До скидки:");
        laptop.displayInfo();

        laptop.applyDiscount(10);

        System.out.println("После скидки 10%:");
        laptop.displayInfo();
        System.out.println(laptop);


    }

    static void task2() {
        System.out.println("Задание 2");
        Train[] trains = {
                new Train("Минск", 101, 180),
                new Train("Москва", 202, 540),
                new Train("Брест", 303, 240),
                new Train("Гомель", 404, 120),
                new Train("Витебск", 505, 360)
        };

        Train maxTime = trains[0];
        Train minTime = trains[0];

        for (int i = 1; i < trains.length; i++) {
            if (trains[i].getTravelTime() > maxTime.getTravelTime()) maxTime = trains[i];
            if (trains[i].getTravelTime() < minTime.getTravelTime()) minTime = trains[i];
        }

        System.out.println("Поезд с максимальным временем в пути: " +
                maxTime.getDestination() + " (№" + maxTime.getTrainNumber() +
                ", " + maxTime.getTravelTime() + " мин)");

        System.out.println("Поезд с минимальным временем в пути: " +
                minTime.getDestination() + " (№" + minTime.getTrainNumber() +
                ", " + minTime.getTravelTime() + " мин)");
        System.out.println();
    }

    static void task3() {
        System.out.println("Задание 3");
        Employee[] employees = {
                new Employee("Алексей", Department.IT),
                new Employee("Мария", Department.HR),
                new Employee("Иван", Department.IT),
                new Employee("Ольга", Department.FINANCE),
                new Employee("Пётр", Department.MARKETING),
                new Employee("Елена", Department.SALES)
        };

        System.out.println("Сотрудники отдела IT:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == Department.IT) {
                System.out.println(employees[i].getName());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание:");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            default:
                System.out.println("Неверный выбор");
        }
        scanner.close();
    }
}