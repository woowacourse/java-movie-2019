package view;

import domain.ChoiceMovie;
import domain.Money;
import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printReservation(List<ChoiceMovie> choiceMovies) {
        for (ChoiceMovie choice : choiceMovies) {
            System.out.println(choice.toString());
        }
    }

    public static void printTotalMoney(Money money) {
        System.out.println(money.toString());
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }


}
