import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import view.ErrorMessage;
import view.InputView;
import view.OutputView;
import domain.Movie;
import domain.MovieRepository;

public class MovieApplication {
    static private HashSet<Integer> useableMovieNumberList;
    static private Movie movie;
    static ArrayList<String> reservationedList ;
    static final int card = 1;
    static final int cash = 2;
    static final double cardDiscountRate = 0.05;
    static final double cashDiscountRate = 0.02;
    static int totalPrice = 0 ;
    static void init() {
        useableMovieNumberList = new HashSet<>();
        useableMovieNumberList.add(1);
        useableMovieNumberList.add(5);
        useableMovieNumberList.add(7);
        useableMovieNumberList.add(8);
        reservationedList  = new ArrayList<>();
        totalPrice = 0;
    }
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printList();
        OutputView.printMovies(movies);

        // TODO 구현 진행
        init();
        selectMovie();
        PaymentStep();
        outputTotalPrice();

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
        totalPrice += movie.getPrice() * reservationMovieCapacity;
        nextStep(reservationMoviewTime,reservationMovieCapacity);
    }
    static void nextStep(int reservationMoviewTime, int reservationMovieCapacity) {
        int InputNextStep = InputView.inputNextStep();
        if (InputNextStep == 1) {
            reservatedInforMation(reservationMoviewTime,reservationMovieCapacity);
            outputReservation();
            return;
        }
        if (InputNextStep == 2) {
            reservatedInforMation(reservationMoviewTime,reservationMovieCapacity);
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

    static void reservatedInforMation(int reservationMoviewTime, int reservationMovieCapacity) {
        reservationedList.add(movie.numberMovie(reservationMoviewTime, reservationMovieCapacity));
    }

    static void outputReservation() {
        OutputView.outputInforMationMovie();
        for (String output : reservationedList) {
            System.out.println(output);
            System.out.println("===================");
        }
    }

    static void PaymentStep() {
        OutputView.outputPaymentStep();
        int point = inputPoint();
        int cardOrCash = selectCardorCash();
        if (cardOrCash == 1) {
            totalPrice -= (int)(totalPrice*cardDiscountRate);
        }
        if (cardOrCash == 2) {
            totalPrice -= (int)(totalPrice*cashDiscountRate);
        }
        totalPrice -= point;
    }

    static int inputPoint() {
        int point = 0;
        do {
            point = InputView.inputMoviePoint();
        } while(checkPoint(point));
        return point ;
    }

    static boolean checkPoint(int point) {
        if (point <0) {
            return true;
        }
        return false;
    }

    static int selectCardorCash() {
        int select = 0;
        do {
            select =  InputView.inputCardorCash();
        } while(checkCardOrCash(select));
        return select;
    }

    static boolean checkCardOrCash(int select) {
        if (select == card || select == cash){
            return false;
        }
        return true;
    }

    static void outputTotalPrice() {
        OutputView.outputTotalPrice(totalPrice);
    }

}
