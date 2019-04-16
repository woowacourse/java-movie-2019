import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BookMovieTest {

    @Test
    public void getSelectedMovieTest() {
        BookMovie bookMovie = new BookMovie();
        ByteArrayInputStream input = new ByteArrayInputStream("5".getBytes());
        System.setIn(input);

        assertEquals(bookMovie.movies.get(1), bookMovie.getSelectedMovie());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSelectedMovieTest2() {
        BookMovie bookMovie = new BookMovie();
        ByteArrayInputStream input = new ByteArrayInputStream("2".getBytes());
        System.setIn(input);

        assertEquals(bookMovie.movies.get(1), bookMovie.getSelectedMovie());
    }

    @Test
    public void getMovieTimeTest() {
        BookMovie bookMovie = new BookMovie();

        ByteArrayInputStream input = new ByteArrayInputStream("4".getBytes());
        System.setIn(input);

        assertEquals(true, bookMovie.getMovieTime());

    }
}