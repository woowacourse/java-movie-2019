package input;

import domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieInput {
    Movie movie;

    public MovieInput(List<Movie> movies, String input) {
        if (checkValidity(movies, input) == false) {
            throw new IllegalArgumentException();
        }

        movie = getMovieFromMovieListById(movies, Integer.parseInt(input));
    }


    private Movie getMovieFromMovieListById(List<Movie> movies, int id) {
        for (Movie movie : movies
             ) {
            if (movie.IDis() == id) {
                return movie;
            }
        }
        throw new IllegalStateException();
    }

    private boolean checkValidity(List<Movie> movies, String input) {
        List<Integer> ids = new ArrayList<>();
        for (Movie movie : movies
             ) {
            ids.add(movie.IDis());
        }
        return checkValidityInIDs(ids,  input);
    }

    private boolean checkValidityInIDs(List<Integer> ids, String input) {
        int id = Integer.parseInt(input);

        return ids.contains(id);
    }
}
