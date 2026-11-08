package org.example;

class InvalidMusicianDataException extends Exception {
    public InvalidMusicianDataException(String message) {
        super(message);
    }
}

class MusicianNotFoundException extends Exception {
    public MusicianNotFoundException(String message) {
        super(message);
    }
}

class AlbumException extends Exception {
    public AlbumException(String message) {
        super(message);
    }
}

class Musician {
    private String name;
    private String instrument;
    private String genre;
    private int albums;
    private double rating;

    public Musician(String name, String instrument, String genre, int albums, double rating) throws InvalidMusicianDataException {
        if (name == null || name.isEmpty()) {
            throw new InvalidMusicianDataException("Имя музыканта не может быть пустым");
        }
        if (albums < 0) {
            throw new InvalidMusicianDataException("Количество альбомов не может быть отрицательным");
        }
        if (rating < 1 || rating > 10) {
            throw new InvalidMusicianDataException("Рейтинг должен быть от 1 до 10");
        }
        this.name = name;
        this.instrument = instrument;
        this.genre = genre;
        this.albums = albums;
        this.rating = rating;
    }

    public String getName() { return name; }

    public void releaseAlbum(String title) throws AlbumException {
        if (title == null || title.isEmpty()) {
            throw new AlbumException("Название альбома не может быть пустым");
        }
        if (this.albums >= 20) {
            throw new AlbumException("У музыканта уже максимум альбомов");
        }
        this.albums++;
        System.out.println("Музыкант " + name + " выпустил альбом: " + title);
    }

    public void updateRating(double newRating) throws InvalidMusicianDataException {
        if (newRating < 1 || newRating > 10) {
            throw new InvalidMusicianDataException("Новый рейтинг должен быть от 1 до 10");
        }
        this.rating = newRating;
        System.out.println("Рейтинг музыканта " + name + " обновлен до " + newRating);
    }

    @Override
    public String toString() {
        return "Музыкант: " + name + ", Инструмент: " + instrument +
                ", Жанр: " + genre + ", Альбомов: " + albums + ", Рейтинг: " + rating;
    }
}

class MusicLabel {
    private Musician[] musicians;
    private int count;

    public MusicLabel(int size) {
        musicians = new Musician[size];
        count = 0;
    }

    public void addMusician(Musician m) {
        if (count < musicians.length) {
            musicians[count] = m;
            count++;
        }
    }

    public Musician findMusician(String name) throws MusicianNotFoundException {
        for (int i = 0; i < count; i++) {
            if (musicians[i].getName().equalsIgnoreCase(name)) {
                return musicians[i];
            }
        }
        throw new MusicianNotFoundException("Музыкант с именем " + name + " не найден");
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(musicians[i]);
        }
    }
}

public class App {
    public static void main(String[] args) {
        MusicLabel label = new MusicLabel(5);

        try {
            Musician m1 = new Musician("Иван", "Гитара", "Рок", 3, 8.5);
            Musician m2 = new Musician("Мария", "Пианино", "Классика", 5, 9.2);
            Musician m3 = new Musician("Алексей", "Барабаны", "Джаз", 2, 7.8);

            label.addMusician(m1);
            label.addMusician(m2);
            label.addMusician(m3);

            System.out.println("Список музыкантов:");
            label.printAll();
            System.out.println();

        } catch (InvalidMusicianDataException e) {
            System.out.println("Ошибка создания музыканта: " + e.getMessage());
        }

        System.out.println("Выпуск альбомов:");
        try {
            Musician m1 = label.findMusician("Иван");
            m1.releaseAlbum("Новый альбом");

            Musician m2 = label.findMusician("Мария");
            m2.releaseAlbum("Зимняя классика");

            Musician m3 = label.findMusician("Петр");
            m3.releaseAlbum("Попытка");

        } catch (MusicianNotFoundException e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        } catch (AlbumException e) {
            System.out.println("Ошибка выпуска альбома: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполнен");
        }
        System.out.println();

        System.out.println("Обновление рейтинга:");
        try {
            Musician m3 = label.findMusician("Алексей");
            m3.updateRating(9.5);

            m3.updateRating(15.0);

        } catch (MusicianNotFoundException e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        } catch (InvalidMusicianDataException e) {
            System.out.println("Ошибка обновления рейтинга: " + e.getMessage());
        }
    }
}