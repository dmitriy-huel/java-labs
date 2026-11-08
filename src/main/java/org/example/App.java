package org.example;

class Singer {
    private String name;
    private String genre;
    private int albums;

    private static int totalSingers = 0;
    private static int totalAlbums = 0;

    public Singer(String name, String genre, int albums) {
        setName(name);
        setGenre(genre);
        setAlbums(albums);
        totalSingers++;
        totalAlbums += albums;
    }

    public String getName() { return name; }
    public String getGenre() { return genre; }
    public int getAlbums() { return albums; }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("имя не может быть пустым");
            return;
        }
        this.name = name;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            System.out.println("жанр не может быть пустым");
            return;
        }
        this.genre = genre;
    }

    public void setAlbums(int albums) {
        if (albums < 0) {
            System.out.println("число альбомов не может быть отрицательным");
            return;
        }
        this.albums = albums;
    }

    public static int getTotalSingers() { return totalSingers; }
    public static int getTotalAlbums() { return totalAlbums; }

    public static double getAverageAlbums() {
        if (totalSingers == 0) return 0;
        return (double) totalAlbums / totalSingers;
    }

    public void displayInfo() {
        System.out.println("Имя: " + getName() +
                ", Жанр: " + getGenre() +
                ", Альбомов: " + getAlbums());
    }

    @Override
    public String toString() {
        return  name + " " + genre + " " + albums;
    }
}

public class App {
    public static void main(String[] args) {
        Singer s1 = new Singer("Иван", "Рок", 5);
        Singer s2 = new Singer("Мария", "Поп", 3);
        Singer s3 = new Singer("Алексей", "Джаз", 7);
        Singer s4 = new Singer("Ольга", "Классика", 2);
        Singer s5 = new Singer("Пётр", "Рэп", 8);

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
        s4.displayInfo();
        s5.displayInfo();

        System.out.println();

        System.out.println("Всего певцов: " + Singer.getTotalSingers());
        System.out.println("Всего альбомов: " + Singer.getTotalAlbums());
        System.out.println("Среднее число альбомов: " + Singer.getAverageAlbums());

        System.out.println();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}