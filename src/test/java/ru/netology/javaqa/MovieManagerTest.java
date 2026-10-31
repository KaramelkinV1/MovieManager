package ru.netology.javaqa;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    private final Movie movie1 = new Movie("Бладшот");
    private final Movie movie2 = new Movie("Вперёд");
    private final Movie movie3 = new Movie("Отель Белград");
    private final Movie movie4 = new Movie("Джентльмены");
    private final Movie movie5 = new Movie("Человек-невидимка");
    private final Movie movie6 = new Movie("Тролли. Мировой тур");
    private final Movie movie7 = new Movie("Номер один");

    @Test
    public void shouldReturnEmptyArraysWhenNoMovies() {
        MovieManager manager = new MovieManager();

        assertArrayEquals(new Movie[0], manager.findAll());
        assertArrayEquals(new Movie[0], manager.findLast());
    }

    @Nested
    class MovieTest {
        @Test
        public void shouldReturnName() {
            Movie movie = new Movie("Бладшот");

            assertEquals("Бладшот", movie.getName());
        }
    }

    @Test
    public void shouldReturnOneMovie() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);

        assertArrayEquals(new Movie[]{movie1}, manager.findAll());
        assertArrayEquals(new Movie[]{movie1}, manager.findLast());
    }

    @Test
    public void shouldReturnAllInOrderOfAdding() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        assertArrayEquals(new Movie[]{movie1, movie2, movie3}, manager.findAll());
    }

    @Test
    public void shouldReturnLastInReverseOrderWhenLessThanLimit() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        assertArrayEquals(new Movie[]{movie3, movie2, movie1}, manager.findLast());
    }

    @Test
    public void shouldReturnLastWhenMoviesEqualLimit() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        assertArrayEquals(new Movie[]{movie5, movie4, movie3, movie2, movie1}, manager.findLast());
    }

    @Test
    public void shouldReturnLastFiveWhenMoreThanDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        assertArrayEquals(new Movie[]{movie6, movie5, movie4, movie3, movie2}, manager.findLast());
    }

    @Test
    public void shouldReturnLastByCustomLimitWhenMoreMovies() {
        MovieManager manager = new MovieManager(3);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);

        assertArrayEquals(new Movie[]{movie4, movie3, movie2}, manager.findLast());
    }

    @Test
    public void shouldReturnLastByCustomLimitSeven() {
        MovieManager manager = new MovieManager(7);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        assertArrayEquals(
                new Movie[]{movie7, movie6, movie5, movie4, movie3, movie2, movie1},
                manager.findLast()
        );
    }

    @Test
    public void shouldReturnLessThanCustomLimitWhenFewMovies() {
        MovieManager manager = new MovieManager(10);
        manager.add(movie1);
        manager.add(movie2);

        assertArrayEquals(new Movie[]{movie2, movie1}, manager.findLast());
    }

    @Test
    public void findAllShouldNotDependOnLimit() {
        MovieManager manager = new MovieManager(2);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        assertArrayEquals(new Movie[]{movie1, movie2, movie3}, manager.findAll());
    }
}