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
    /*
    private static void printCurrentState(List<Movie> curMovies,List<PlaySchedule> curSchedule,List<Integer> ppl){
        for(int i = 0 ; i < curMovies.size() ; i++){
            System.out.print(curMovies.get(i).toString(true));
            System.out.print(curSchedule.get(i));
            System.out.println("예약 인원:"+ ppl.get(i) + "명");
            System.out.println();
        }
    }
    */
}
