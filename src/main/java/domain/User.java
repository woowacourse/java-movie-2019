package domain;

import utils.StringLiterals;
import view.InputView;

public class User {
    public UserSelection issueMovieTicket() {
        int movieId = getMovieId();
        int movieTime = getMovieTime(movieId);
        int noOfPerson = getNoOfPerson(movieId, movieTime);

        return new UserSelection(movieId, movieTime, noOfPerson);
    }

    public boolean repeatSelection() {
        int repeat = validateRepeatInput();

        if (repeat == 1)
            return false;

        return true;
    }

    private int getMovieId() {
        return validateMovieId();
    }

    private int getMovieTime(int movieId) {
        MovieRepository.showTimeTable(movieId);

        return validateMovieTime(movieId);
    }

    private int getNoOfPerson(int movieId, int movieTime) {
        return validateNoOfPerson(movieId, movieTime);
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

    private int validateNoOfPerson(int movieId, int movieTime) {
        int noOfPerson = InputView.getUserInput(StringLiterals.NUMBER_OF_PERSON_STATEMENT.toString(),
                StringLiterals.NUMBER_OF_PERSON_ERROR.toString());

        if (noOfPerson < 1 || !MovieRepository.hasCapacity(movieId, movieTime, noOfPerson)) {
            System.out.println(StringLiterals.NUMBER_OF_PERSON_ERROR.toString());
            return validateNoOfPerson(movieId, movieTime);
        }

        return noOfPerson;
    }

    private int validateRepeatInput() {
        int repeat = InputView.getUserInput(StringLiterals.FINISH_SELECTION_STATEMENT.toString(),
                StringLiterals.FINISH_SELECTION_ERROR.toString());

        if (repeat == 1 || repeat == 2) {
            return repeat;
        }

        System.out.println(StringLiterals.FINISH_SELECTION_ERROR.toString());
        return validateRepeatInput();
    }
}
