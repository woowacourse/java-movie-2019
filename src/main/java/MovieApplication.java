import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static List<Movie> chosenMovie;
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<LocalDateTime> times = new ArrayList<>();
        List<Integer> peoples = new ArrayList<>();
        int index = 0, check = 0;
        chosenMovie = new ArrayList<>();

        try {
            do {
                OutputView.printMovies(movies);
                int movieId = InputView.inputMovieId();
                chosenMovie.add(OutputView.getAndprintChosenMovie(movies, movieId));
                int movieTime = InputView.inputMovieSchedule(chosenMovie.get(index));
                LocalDateTime temp = chosenMovie.get(index).getPlaySchedules().get(movieTime - 1).getStartDateTime();
                times.add(temp);
                int movieReservePerson = InputView.inputMovieReservePerson();
                peoples.add(movieReservePerson);
                OutputView.makeFail(chosenMovie.get(index), times, temp);
                chosenMovie.get(index++).getPlaySchedules().get(movieTime - 1).reserve(movieReservePerson);
                check = InputView.inputReserveOrPurchase();
            }
            while (check != 1);
            OutputView.printReservation(movies, times, peoples);
            OutputView.printPurchase();

        } catch (IllegalArgumentException e) {
            System.out.println("\n처음부터 다시 예약을 진행해주세요.\n");
            main(args);
        }

        // TODO 구현 진행


    }
}
