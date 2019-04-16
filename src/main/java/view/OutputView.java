package view;

import domain.ChoiceMovie;
import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printReservation(List<ChoiceMovie> choiceMovies){
        for(ChoiceMovie choice:choiceMovies){
            System.out.println(choice.toString());
        }
    }


}
