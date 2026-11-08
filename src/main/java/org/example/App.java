package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Game {
    private String name;
    private int id;
    private double rating;

    public Game(String name, int id, double rating) {
        this.name = name;
        this.id = id;
        this.rating = rating;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return "Игра: " + name + ", ID: " + id + ", Рейтинг: " + rating;
    }
}

class BoardGame extends Game {
    private int players;

    public BoardGame(String name, int id, double rating, int players) {
        super(name, id, rating);
        this.players = players;
    }

    @Override
    public String toString() {
        return super.toString() + ", Игроков: " + players;
    }
}

class CardGame extends Game {
    private String deckType;

    public CardGame(String name, int id, double rating, String deckType) {
        super(name, id, rating);
        this.deckType = deckType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Тип колоды: " + deckType;
    }
}

class VideoGame extends Game {
    private String platform;

    public VideoGame(String name, int id, double rating, String platform) {
        super(name, id, rating);
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString() + ", Платформа: " + platform;
    }
}

class Psychologist {
    private int id;
    private String name;
    private String specialization;
    private int rating;
    private List<Integer> clientRatings;

    public Psychologist(int id, String name, String specialization, int rating, List<Integer> clientRatings) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
        this.clientRatings = clientRatings;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public double getAverageRating() {
        if (clientRatings == null || clientRatings.isEmpty()) return 0;
        double sum = 0;
        for (int i = 0; i < clientRatings.size(); i++) {
            sum += clientRatings.get(i);
        }
        return sum / clientRatings.size();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", Спец: " + specialization +
                ", Рейтинг: " + rating + ", Средний балл: " + getAverageRating();
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("=== ЗАДАНИЕ 1: ИГРЫ (Map) ===");
        Map<String, Game> gameMap = new TreeMap<>();

        gameMap.put("Монополия", new BoardGame("Монополия", 1, 4.5, 4));
        gameMap.put("Шахматы", new BoardGame("Шахматы", 2, 4.8, 2));
        gameMap.put("Каркассон", new BoardGame("Каркассон", 3, 4.2, 5));
        gameMap.put("Уно", new CardGame("Уно", 4, 4.0, "Классическая"));
        gameMap.put("Покер", new CardGame("Покер", 5, 4.7, "Стандартная"));
        gameMap.put("Дурак", new CardGame("Дурак", 6, 3.9, "36 карт"));
        gameMap.put("GTA V", new VideoGame("GTA V", 7, 4.9, "PC"));
        gameMap.put("The Witcher 3", new VideoGame("The Witcher 3", 8, 5.0, "PS5"));

        Iterator<Map.Entry<String, Game>> mapIterator = gameMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Game> entry = mapIterator.next();
            System.out.println("Ключ: " + entry.getKey() + " | " + entry.getValue());
        }

        System.out.println("\n=== ЗАДАНИЕ 2: ПСИХОЛОГИ (List) ===");
        List<Psychologist> psychs = new ArrayList<>();

        List<Integer> r1 = new ArrayList<>(); r1.add(5); r1.add(4); r1.add(5); r1.add(4);
        List<Integer> r2 = new ArrayList<>(); r2.add(2); r2.add(1); r2.add(2); r2.add(3);
        List<Integer> r3 = new ArrayList<>(); r3.add(4); r3.add(4); r3.add(3); r3.add(4);
        List<Integer> r4 = new ArrayList<>(); r4.add(5); r4.add(5); r4.add(5); r4.add(4);
        List<Integer> r5 = new ArrayList<>(); r5.add(1); r5.add(2); r5.add(1); r5.add(2);

        psychs.add(new Psychologist(101, "Анна", "Клинический", 3, r1));
        psychs.add(new Psychologist(102, "Борис", "Семейный", 2, r2));
        psychs.add(new Psychologist(103, "Виктор", "Детский", 3, r3));
        psychs.add(new Psychologist(104, "Галина", "Клинический", 4, r4));
        psychs.add(new Psychologist(105, "Дмитрий", "Семейный", 1, r5));

        System.out.println("1. Психологи со средним рейтингом > 3:");
        for (int i = 0; i < psychs.size(); i++) {
            if (psychs.get(i).getAverageRating() > 3) {
                System.out.println(psychs.get(i));
            }
        }

        System.out.println("\n2. Повышение рейтинга (>= 4):");
        for (int i = 0; i < psychs.size(); i++) {
            Psychologist p = psychs.get(i);
            if (p.getAverageRating() >= 4) {
                p.setRating(p.getRating() + 1);
                System.out.println("Повышен рейтинг: " + p.getName() + " -> " + p.getRating());
            }
        }

        System.out.println("\n3. Психологи с рейтингом 3:");
        printPsychologists(psychs, 3);

        System.out.println("\n4. Сортировка по убыванию среднего рейтинга:");
        psychs.sort(new Comparator<Psychologist>() {
            @Override
            public int compare(Psychologist p1, Psychologist p2) {
                int cmp = Double.compare(p2.getAverageRating(), p1.getAverageRating());
                if (cmp == 0) {
                    return p1.getName().compareTo(p2.getName());
                }
                return cmp;
            }
        });

        for (int i = 0; i < psychs.size(); i++) {
            Psychologist p = psychs.get(i);
            System.out.println("ID: " + p.getId() + ", Имя: " + p.getName() +
                    ", Средний балл: " + p.getAverageRating());
        }
    }

    public static void printPsychologists(List<Psychologist> psychologists, int rating) {
        for (int i = 0; i < psychologists.size(); i++) {
            if (psychologists.get(i).getRating() == rating) {
                System.out.println(psychologists.get(i));
            }
        }
    }
}