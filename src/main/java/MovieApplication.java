import java.util.HashSet;
import java.util.List;

import view.ErrorMessage;
import view.InputView;
import view.OutputView;
import domain.Movie;
import domain.MovieRepository;

public class MovieApplication {
    static HashSet<Integer> useableMovieNumberList;
    static private Movie movie;
    static void init() {
        useableMovieNumberList = new HashSet<>();
        useableMovieNumberList.add(1);
        useableMovieNumberList.add(5);
        useableMovieNumberList.add(7);
        useableMovieNumberList.add(8);
    }
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printList();
        OutputView.printMovies(movies);

        // TODO 구현 진행
        init();
        selectMovie();

    }

    static void selectMovie() {
        int movieId = 0;
        do {
            movieId = InputView.inputMovieId();
        } while (checkUseableMovie(movieId));

        movie = MovieRepository.getSelectedMovieInformation(movieId);
        OutputView.printMovie(movie);
        setReservationInformation();
    }

    static boolean checkUseableMovie(int num) {
        if (!useableMovieNumberList.contains(num)) {
            System.out.println(ErrorMessage.errorMessage.get("ERROR_USEABLEMOVIE"));
            return true;
        }
        return false;
    }

    static void setReservationInformation() {
        int reservationMoviewTime = setReservationTime()-1;
        int reservationMovieCapacity = setReservationCapacity(reservationMoviewTime);
        int InputNextStep = InputView.inputNextStep();
        if (InputNextStep == 1) {
            reservationInforMation(reservationMoviewTime,reservationMovieCapacity);
            return;
        }
        if (InputNextStep == 2) {
            selectMovie();
            return;
        }
    }

    static int setReservationTime() {
        int reservationMoviewTime = 0;
        do {
            reservationMoviewTime = InputView.inputMovieTime();
        } while(checkTime(reservationMoviewTime)) ;
        return (reservationMoviewTime);
    }

    static boolean checkTime(int reservationMoviewTime) {

        int movieTimeSize = movie.getMovieTimeSize();
        if ((reservationMoviewTime) >movieTimeSize) {
            System.out.println(ErrorMessage.errorMessage.get("ERROR_MOVIETIMELIMIT"));
            return true;
        }
        return false;
    }

    static int setReservationCapacity(int reservationMoviewTime) {
        int reservationMovieCapacity =0;
        do {
            reservationMovieCapacity = InputView.inputMovieNum();
        } while (checkCapacity(reservationMoviewTime, reservationMovieCapacity));
        movie.setCapacity(reservationMoviewTime, reservationMovieCapacity);
        return reservationMovieCapacity;
    }

    static boolean checkCapacity(int reservationMoviewTime , int reservationMovieCapacity ) {
        int capacitySize = movie.getCapacity(reservationMoviewTime);
        if (capacitySize < reservationMovieCapacity) {
            System.out.println(ErrorMessage.errorMessage.get("ERROR_MOVIECAPACITYLIMIT"));
            return true;
        }
        return false;
    }

    static void reservationInforMation(int reservationMoviewTime, int reservationMovieCapacity) {

    }

}
