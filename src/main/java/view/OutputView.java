package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie printMovieSchedule(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                System.out.println(movie);
                return movie;
            }
        }

        return null;
    }

    public static void printBillingProgress() {
        System.out.println("## 결제를 진행합니다.");
    }

    public static void printResult(int payment) {
        System.out.println("최종 결제 금액은 " + payment + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화관람되세요.");
    }
}
