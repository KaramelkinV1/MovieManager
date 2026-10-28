import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Movie;
import ru.netology.javaqa.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("1"));
        manager.add(new Movie("2"));
        manager.add(new Movie("3"));
        manager.add(new Movie("4"));
        manager.add(new Movie("5"));
        manager.add(new Movie("6"));

        String[] expectedNames = {"6", "5", "4", "3", "2"};

        Movie[] actualMovies = manager.findLast();

        assertEquals(expectedNames.length, actualMovies.length, "Неверная длина массива");

        for (int i = 0; i < expectedNames.length; i++) {
            assertEquals(expectedNames[i], actualMovies[i].getName(),
                    "Не совпадает фильм на позиции " + i);
        }
    }

    @Test
    public void testConstructorWithLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add(new Movie("1"));
        manager.add(new Movie("2"));
        manager.add(new Movie("3"));
        manager.add(new Movie("4"));

        Movie[] result = manager.findLast();
        assertEquals(3, result.length);
        assertEquals("4", result[0].getName());
        assertEquals("3", result[1].getName());
        assertEquals("2", result[2].getName());
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Фильм А"));
        manager.add(new Movie("Фильм Б"));

        Movie[] all = manager.findAll();

        assertEquals(2, all.length);
        assertEquals("Фильм А", all[0].getName());
        assertEquals("Фильм Б", all[1].getName());
    }

    @Test
    public void testAddTooManyMovies() {
        MovieManager manager = new MovieManager();
        for (int i = 0; i < 15; i++) {
            manager.add(new Movie("Фильм " + i));
        }

        assertEquals(10, manager.findAll().length);
    }
    @Test
    public void testFindLastWhenMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(10);

        manager.add(new Movie("Фильм 1"));
        manager.add(new Movie("Фильм 2"));

        Movie[] result = manager.findLast();

        assertEquals(2, result.length);
        assertEquals("Фильм 2", result[0].getName());
        assertEquals("Фильм 1", result[1].getName());
    }
}
