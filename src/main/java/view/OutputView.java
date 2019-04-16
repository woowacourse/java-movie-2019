package view;

import domain.*;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class OutputView {
        public static void printMovies(List<Movie> movies) {
                System.out.println("상영 영화 목록");
                for (Movie movie : movies) {
                        System.out.println(movie);
                }
        }

        public static void printSelectedMovie(int movieId) {
                Movie selectedMovie = null;
                for (Movie movie : MovieRepository.getMovies()) {
                        selectedMovie = movie.compareId(movieId) ? movie : selectedMovie;
                }
                System.out.println(selectedMovie);
        }

        public static void printReservationInfo() {
                System.out.println("예약 내역");
                StringBuilder sb = new StringBuilder();
                for (Movie movie : ReservedInfo.reservedMovieInfoMap.keySet()) {
                        sb.append(movie.toStringInfo());
                        sb.append(oneScheduleInfo(ReservedInfo.reservedMovieInfoMap.get(movie))+"\n");
                }
                System.out.println(sb.toString());
        }

        private  static String oneScheduleInfo(TimeAndPeople timeAndPeople){
                StringBuilder sb = new StringBuilder();
                for(PlaySchedule playSchedule : timeAndPeople.map.keySet()){
                        sb.append(playSchedule.toStringInfo());
                        sb.append("예약 인원: " + timeAndPeople.map.get(playSchedule) + "명");
                }
                return sb.toString();
        }
}
