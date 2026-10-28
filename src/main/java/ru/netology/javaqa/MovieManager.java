package ru.netology.javaqa;

public class MovieManager {
    private final int limit;
    private Movie[] movies;

    public MovieManager() {
        this.movies = new Movie[10];
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.movies = new Movie[10];
        this.limit = limit;
    }

    public void add(Movie movie) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] == null) {
                movies[i] = movie;
                return;
            }
        }
        System.out.println("Места нет!");
    }

    public Movie[] findAll() {
        int count = 0;
        for (Movie m : movies) {
            if (m != null) count++;
        }

        Movie[] result = new Movie[count];
        int index = 0;
        for (Movie m : movies) {
            if (m != null) {
                result[index] = m;
                index++;
            }
        }
        return result;
    }

    public Movie[] findLast() {
        int count = 0;
        for (Movie m : movies) {
            if (m != null) count++;
        }

        int resultLength;
        if (count < limit) {
            resultLength = count;
        } else {
            resultLength = limit;
        }

        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[count - 1 - i];
        }

        return result;
    }
}