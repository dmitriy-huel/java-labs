import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Выберите задание (1 или 2) ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                task1(sc);
                break;
            case 2:
                task2(sc);
                break;
            default:
                System.out.println("Ошибка введите 1 или 2");
        }

        sc.close();
    }

    static void task1(Scanner sc) {

        System.out.print("Введите размер массива ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Введите элементы массива");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Исходный массив " + Arrays.toString(arr));

        if (n > 0) {
            int first = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = first;
        }

        System.out.println("Массив после сдвига влево " + Arrays.toString(arr));
    }

    static void task2(Scanner sc) {

        System.out.print("Введите количество строк ");
        int rows = sc.nextInt();
        System.out.print("Введите количество столбцов ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Введите элементы матрицы");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Исходная матрица");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int evenCount = 0, oddCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 == 0) evenCount++;
                else oddCount++;
            }
        }

        int[] evenArr = new int[evenCount];
        int[] oddArr  = new int[oddCount];
        int e = 0, o = 0;
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i >= j) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("Сумма элементов под гл " + sum);

        System.out.println("Чётные элементы  " + Arrays.toString(evenArr));
        System.out.println("Нечётные элементы " + Arrays.toString(oddArr));
    }
}
