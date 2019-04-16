package view;

import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static boolean printMovie(List<Movie> movies, int movieNum) {
        for (Movie movie : movies) {
            int mid = movie.getId();
            if (mid == movieNum) {
                System.out.println(movie);
                return true;
            }
        }
        return false;
    }
    public static void reservationInformation(List<Movie> movies, int movieNum,int scheduleNum, int peopleNum) {
        System.out.println("예약 내역");

        for (Movie movie : movies) {
            int mid = movie.getId();
            if (mid == movieNum) {
                String movieName = movie.getMovie();
                int moviePrice = movie.getPrice();
                List<PlaySchedule> playSchedules= movie.getPlaySchedules();
                System.out.println(playSchedules.get(scheduleNum-1));
                System.out.println(String.format("%d - %s,%d원",movieNum,movieName,moviePrice));
            }
        }
        System.out.println(String.format("예약 인원:%d명",peopleNum));
    }
}