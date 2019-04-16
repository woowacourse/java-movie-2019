package domain;

import java.sql.Time;
import java.util.*;

public class ReservedInfo {
        public static Map<Movie, TimeAndPeople> reservedMovieInfoMap = new HashMap<Movie, TimeAndPeople>();

        public static void addInfo(int movieId, int schedule, int people){
                Movie selectedMovie = findSelectedMovie(movieId);
                selectedMovie.makeReservedInfo(selectedMovie,schedule, people);
        }

        private static Movie findSelectedMovie(int movieId){
                Movie selectedMovie = null;
                for(Movie movie : MovieRepository.getMovies()){
                        selectedMovie = movie.compareId(movieId) ? movie : selectedMovie;
                }
                return selectedMovie;
        }
}
