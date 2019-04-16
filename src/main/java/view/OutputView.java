package view;

import domain.Movie;

import java.util.Map;

public class OutputView {
    public static void printMovies(Map<Integer, Movie> movies) {
        for (int key : movies.keySet()) {
            System.out.println(movies.get(key));
        }
    }

    public static void printMovieInfo(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservation(Movie movie, int timeIdx, int numberOfPeople) {
        System.out.println("예약내역");
        System.out.println(movie.toString(movie.getId()));
        System.out.println("시작시간: " + movie.getPlaySchedules().get(timeIdx).getTime());
        System.out.println("예약 인원: " + numberOfPeople);
    }

    public static void printresult(){
        System.out.println("## 결제를 진행합니다.");
    }

}
