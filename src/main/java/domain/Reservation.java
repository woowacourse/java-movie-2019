package domain;

import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static List<Movie> movies = MovieRepository.getMovies();
    private static List<SelectedMovie> selectedMovies = new ArrayList<>();
    private static boolean flag = true;
    private static int index = 0;
    private int totalPrice = 0;
    private int point = 0;

    public Reservation() {

    }

    public void startReservation() {
        do {
            int movieId = InputView.inputMovieId();
            OutputView.showSelectedMovie(movieId);
            startSelectedMovies();
            flag = InputView.inputContinueReservation();
        } while (flag);
    }

    public void startSelectedMovies() {
        boolean updateFlag = false;
        do {
            selectedMovies.get(index).getData();
            System.out.println(isValidPlayScehdule());
            if(!isValidPlayScehdule()) continue;
            updateFlag = updateAudience();
        } while (!updateFlag);
        selectedMovies.get(index).showSelectedMovieSchecule();
        index += 1;
    }

    public boolean isValidPlayScehdule() {
        if (index == 0) {
            return true;
        }
        return comparePlaySchedules();
    }

    public boolean comparePlaySchedules(){
        return selectedMovies.get(index - 1).comparePlayScheduleTime(selectedMovies.get(index));
    }

    public boolean updateAudience() {
        return selectedMovies.get(index).updateAudienceCount();
    }

    private void calculateTotalPrice() {
        for (SelectedMovie selectedMovie : selectedMovies) {
            totalPrice += selectedMovie.showPrice();
        }
    }

    public static Movie showMovie(int id) {
        for (int i = 0; i < movies.size(); i++) {
            boolean tmp = movies.get(i).isMatchedId(id);
            if (tmp == true) {
                selectedMovies.add(new SelectedMovie(movies.get(i)));
                return movies.get(i);
            }
        }
        return null;
    }

    public void calculationTotalPrice() {
        point = InputView.inputPoint();
        totalPrice -= point;
    }
}
