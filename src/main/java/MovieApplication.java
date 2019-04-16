import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {


    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        User user=new User();
        Reservation reservation;

        int movieId;
        do {
            movieId = InputView.inputMovieId();
        }
        while (!MovieRepository.isContains(movieId));

        OutputView.printMovieById(movieId);

        int scheduledNumber;
        do {
            scheduledNumber = InputView.inputMovieSchedule();
        }
        while (scheduledNumber > movies.get(movieId).getScheduleSize()
                || MovieRepository.getMovieById(movieId).getPlaySchedule().get(scheduledNumber-1).getCapacity() <= 0);

        int numberOfPeople=InputView.inputNumberOfPeople();

        reservation=new Reservation(movieId,scheduledNumber,numberOfPeople);
        user.addReservation(reservation);


    }


}
