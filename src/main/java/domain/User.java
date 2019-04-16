package domain;

import utils.StringLiterals;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<UserSelection> userSelections = new ArrayList<>();

    public int getMovieId() {
        return validateMovieId();
    }

    public int getMovieTime(int movieId) {
        MovieRepository.showTimeTable(movieId);

        return validateMovieTime(movieId);
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

    private int validateMovieTime(int movieId) {
        int movieTime = InputView.getUserInput(StringLiterals.MOVIE_TIME_STATEMENT.toString(),
                StringLiterals.MOVIE_TIME_ERROR.toString());

        if (movieTime < 1 || movieTime > MovieRepository.getTimeTableLength(movieId)) {
            System.out.println((StringLiterals.MOVIE_TIME_ERROR.toString()));
            return validateMovieTime(movieId);
        }

        return movieTime;
    }
}
