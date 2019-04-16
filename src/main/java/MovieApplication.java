import domain.Movie;
import domain.MovieRepository;
import domain.ReservationCategory;
import view.InputView;
import view.OutputView;

import java.util.*;

public class MovieApplication {

    public static void main(String[] args) {
        List<ReservationCategory> reservationCategory = new ArrayList<>();
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        // TODO 구현 진행
        Movie choiceMovie =  OutputView.printChoiceMovies(movies);
        reservationCategory = reservedTimeSchedule(choiceMovie, reservationCategory);

        int isPayment = InputView.inputIsPayment();
        OutputView.printReservedCategory(reservationCategory, isPayment);
        OutputView.progressPayment(reservationCategory);

    }

    private static List<ReservationCategory> reservedTimeSchedule(Movie choiceMovie, List<ReservationCategory> reservationCategories){
        int choiceTime = InputView.inputChoiceTime();
        if(choiceTime > choiceMovie.getPlaySchedules().size() || choiceTime < 0){
            System.out.println("선택한 시간이 없습니다. 다시입력하세요.");
            return reservedTimeSchedule(choiceMovie, reservationCategories);
        }
        int reservedPerson = InputView.inputReservedPerson();
        if(reservedPerson < 0 || reservedPerson > choiceMovie.getPlaySchedules().get(choiceTime-1).getCapacity()){
            System.out.println("예약 인원이 없거나 초과 하였습니다. 다시 입력해주세요.");
            return reservedTimeSchedule(choiceMovie, reservationCategories);
        }
        reservationCategories.add(new ReservationCategory(choiceMovie, choiceMovie.getPlaySchedules().get(choiceTime-1).getStartDateTime(), reservedPerson));

        return reservationCategories;
    }


}
