package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        task1();

        System.out.println("\nЗадание 2");
        task2();

        System.out.println("\nЗадание 3");
        task3();

        System.out.println("\nЗадание 4");
        task4();

        System.out.println("\nЗадание 5");
        task5();
    }

    public static void task1() {
        File file = new File("song.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Название: Bohemian Rhapsody");
            writer.println("Исполнитель: Queen");
            writer.println("Альбом: A Night at the Opera");
            writer.println("Год выпуска: 1975");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("Данные о файле:");
        System.out.println("Имя: " + file.getName());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Существует: " + file.exists());
        System.out.println("Путь: " + file.getAbsolutePath());

        System.out.println("Содержимое файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    public static void task2() {
        File file = new File("f.txt");
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println("Введите 10 целых чисел:");
            for (int i = 0; i < 10; i++) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                } else {
                    System.out.println("Ошибка: введено не число.");
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
            return;
        }

        System.out.println("Считанные числа:");
        int powerOfTwoCount = 0;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (num > 0 && (num & (num - 1)) == 0) {
                    powerOfTwoCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        System.out.println("\nКоличество чисел, являющихся степенями двойки: " + powerOfTwoCount);
    }

    public static void task3() {
        File fileF = new File("f_random.txt");
        File fileG = new File("g.txt");
        File fileH = new File("h.txt");

        Random random = new Random();

        try (PrintWriter writerF = new PrintWriter(fileF)) {
            for (int i = 0; i < 10; i++) {
                writerF.println(random.nextInt(200) - 100);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл f: " + e.getMessage());
            return;
        }

        try (Scanner scannerF = new Scanner(fileF);
             PrintWriter writerG = new PrintWriter(fileG);
             PrintWriter writerH = new PrintWriter(fileH)) {

            while (scannerF.hasNextInt()) {
                int num = scannerF.nextInt();
                int temp = Math.abs(num);
                int sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }

                if (sum % 2 == 0) {
                    writerG.println(num);
                } else {
                    writerH.println(num);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка обработки файлов: " + e.getMessage());
        }
        System.out.println("Файлы g.txt и h.txt успешно созданы.");
    }

    public static void task4() {
        File file = new File("angles.txt");
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println("Введите 10 значений углов в градусах:");
            for (int i = 0; i < 10; i++) {
                if (scanner.hasNextDouble()) {
                    writer.println(scanner.nextDouble());
                } else {
                    System.out.println("Ошибка: введено не число.");
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
            return;
        }

        double sum = 0;
        int count = 0;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextDouble()) {
                sum += fileScanner.nextDouble();
                count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (count > 0) {
            System.out.println("Средний угол: " + (sum / count));
        } else {
            System.out.println("Нет данных для подсчета.");
        }
    }

    public static void task5() {
        File file = new File("f_integers.txt");
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < 10; i++) {
                writer.println(random.nextInt(200) - 100);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
            return;
        }

        int negativeCount = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                if (scanner.nextInt() < 0) {
                    negativeCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        System.out.println("Количество чисел, меньших 0: " + negativeCount);
    }
}