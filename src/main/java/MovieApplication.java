import domain.Movie;
import domain.MovieRepository;
import domain.User;
import domain.UserSelection;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        User user = new User();
        List<UserSelection> userSelections = new ArrayList<>();
        List<Movie> movies = MovieRepository.getMovies();

        do {
            OutputView.printMovies(movies);
            userSelections.add(user.issueMovieTicket());
        } while (user.repeatSelection());
    }
}
