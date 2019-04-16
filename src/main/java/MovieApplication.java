import view.InputView;

public class MovieApplication {
    public static void main(String[] args) {
        BookMovie bookMovie = new BookMovie();
        bookMovie.run();

        if (InputView.inputPayMovieYesOrNo()) {
            bookMovie.run();
        }

    }

}
