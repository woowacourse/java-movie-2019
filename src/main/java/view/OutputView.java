package view;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;

import java.util.List;

public class OutputView {
    public static void printBookingHistory(Movie selectMovie, PlaySchedule selectSchedule, int peopleCount) {
        System.out.println("예약내역");
        System.out.println(selectMovie.getId()+ "-"+selectMovie.getName()+","+ selectMovie.getPrice()+"원" + "\n"
        +"시작시간: "+ DateTimeUtils.format(selectSchedule.getStartDateTime()) + "\n예약 인원:" + peopleCount);
    }


    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectMovie(int selectMovieId) {
        System.out.println(MovieRepository.getSelectMovie(selectMovieId));

    }
}
