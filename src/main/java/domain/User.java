package domain;

import utils.StringLiterals;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<UserSelection> userSelections = new ArrayList<>();

    public int getMovieId() {
        int movieId = validateMovieId();

        return movieId;
    }

    private int validateMovieId() {
        int movieId = InputView.getUserInput(StringLiterals.MOVIE_ID_STATEMENT.toString(),
                StringLiterals.MOVIE_ID_ERROR.toString());

        if (!MovieRepository.hasMovieId(movieId)) {
            System.out.println(StringLiterals.MOVIE_ID_ERROR.toString());
            return validateMovieId();
        }

        return movieId;
    }
}
