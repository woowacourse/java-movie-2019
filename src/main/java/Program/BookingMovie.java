package Program;

import domain.BookMovie;
import domain.Movie;
import domain.MovieRepository;

public class BookingMovie {
    public BookMovie bookMovie;

    public BookingMovie(BookMovie bookMovie){
        this.bookMovie = new BookMovie();
    }

    public BookMovie booking(int movieId){
        for(int i =0; i<MovieRepository.getMovies().size(); i++) {
            Movie willBookMovie = MovieRepository.getMovies().get(i);
            bookMovie = checkId(willBookMovie,movieId);
        }
        return bookMovie;
    }

    private BookMovie checkId(Movie willBookMovie, int movieId){
        if (willBookMovie.getId() == movieId) {
            bookMovie.addBookMovieList(willBookMovie);
        }
        return bookMovie;
    }

}
