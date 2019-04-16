import view.InputView;

public class MovieApplication {
    public static void main(String[] args) {
        BookMovie bookMovie = new BookMovie();
        bookMovie.run();

        while (!InputView.inputPayMovieYesOrNo()) {
            bookMovie.run();
        }

        PayMovie payMovie = new PayMovie(bookMovie.getBookedMovies());
        payMovie.run();
    }

}
