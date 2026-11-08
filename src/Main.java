import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    task1(scanner);
                    break;

                case 2:
                    task2(scanner);
                    break;

                case 3:
                    task3(scanner);
                    break;

                case 0:
                    System.out.println("Программа завершена. До свидания!");
                    break;

                default:
                    System.out.println("Ошибка: неверный выбор! Введите 1, 2, 3 или 0.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void task1(Scanner scanner) {
        System.out.print("Введите количество метров: ");
        double meters = scanner.nextDouble();
        double millimeters = meters * 1000;
        System.out.printf("%.2f м = %.2f мм\n", meters, millimeters);
    }

    public static void task2(Scanner scanner) {
        System.out.print("Введите три целых числа через пробел: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int count = 0;

        if (a < 0) count++;
      else  if (b < 0) count++;
       else if (c < 0) count++;

        System.out.println("Количество отрицательных чисел: " + count);
    }

    public static void task3(Scanner scanner) {
        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Число " + n + " не является простым (меньше 2)");
            return;
        }

        boolean isPrime = true;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }

        int i = 2;
        while(i <= Math.sqrt(n)){
            if (n % i == 0){
                isPrime = false;
                break;
            }
            i++;
        }

        if (isPrime) {
            System.out.println("Число " + n + " — простое");
            System.out.println("Оно делится только на 1 и на само себя");
        } else {
            System.out.println("Число " + n + " — не является простым");
            System.out.println("У него есть делители, кроме 1 и самого числа");
        }
    }
}