import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Employee {
    private String fullname;
    private double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() {
        return fullname;
    }

    public double getSalary() {
        return salary;
    }
}

class Report {
    public static void generateReport(Employee[] employees) {
        System.out.printf("%-15s | %15s%n", "Фамилия", "Зарплата");

        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];

            String[] parts = emp.getFullname().split("\\s+");
            String surname = parts[0];

            if (surname.length() > 15) {
                surname = surname.substring(0, 15);
            }

            System.out.printf("%-15s |%15.2f%n", surname, emp.getSalary());
        }
    }
}

public class Main {

    public static void task1() {

        String str1 = "Привет";
        String str2 = "Мир";

        String result = str1 + " " + str2;

        System.out.println("Первая строка: " + str1);
        System.out.println("Вторая строка: " + str2);
        System.out.println("Результат: " + result);
    }

    public static void task2() {

        String sentence = "Я иду домой и вижу там кота";

        System.out.println("Исходное предложение: " + sentence);

        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() >= 3) {
                result.append(word).append(" ");
            }
        }

        String finalResult = result.toString().trim();

        System.out.println("После удаления слов короче 3 символов: " + finalResult);
    }

    public static void task3() {

        Employee[] employees = new Employee[] {
                new Employee("Иванов Иван Иванович", 12500.50),
                new Employee("Петров Петр Петрович", 9800.75),
                new Employee("Сидоров Сидор Сидорович", 15300.00),
                new Employee("Кузнецова Анна Сергеевна", 11200.25)
        };

        Report.generateReport(employees);
    }

    public static void task4() {

        String input = "а11а а22а a333а а4а а5а а6а а7а а8а а9а";

        System.out.println("Исходная строка: " + input);
        System.out.println("Найденные строки:");

        Pattern pattern = Pattern.compile("а[1-5]{2}а");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        int taskNumber = 3;

        switch (taskNumber) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            default:
                System.out.println("Неверный номер задания. Доступны: 1, 2, 3, 4");
        }
    }
}