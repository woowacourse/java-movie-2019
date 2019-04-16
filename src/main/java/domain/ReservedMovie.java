package domain;

import java.util.*;

/**
 * 예약한 인원 수 만큼 List 에 Movie 객체를 저장하여
 * Set 을 이용하여 예약 인원 판단.
 */
public class ReservedMovie {
    private List<Movie> movies;
    private Map<Movie, Integer> timeMap = new HashMap<>();
    private List<Movie> reservedMovies = new ArrayList<>();

    public ReservedMovie(List<Movie> movies) {
        this.movies = movies;
    }

    public void addReservationHistory(int movieId, int movieTime, int numberOfPeople) {
        Movie movie = findMovie(movieId);
        for (int i = 0; i < numberOfPeople; i++) {
            reservedMovies.add(movie);
        }
        timeMap.put(movie, movieTime);
    }

    private Movie findMovie(int movieId) {
        Movie result = null;
        for (Movie movie : movies) {
            if (movie.isMatchMovie(movieId)) {
                result = movie;
            }
        }
        return result;
    }

    public void printReservationHistory() {
        Set<Movie> movieList = new HashSet<>(reservedMovies);
        Iterator<Movie> iter = movieList.iterator();
        while (iter.hasNext()) {
            printOneMovieHistory(iter.next());
        }
    }

    private void printOneMovieHistory(Movie movie) {
        System.out.println(movie.printMovieInfo());
        System.out.println(movie.printMovieTime(timeMap.get(movie)));
        System.out.println(countNumberOfPeople(movie));
    }

    private String countNumberOfPeople(Movie movie) {
        List<Movie> copyReservedMovies = new ArrayList<>(reservedMovies);
        List<Movie> result = new ArrayList<>();
        result.add(movie);

        copyReservedMovies.retainAll(result);
        return "예약 인원 :" + copyReservedMovies.size();
    }

    public int calculateTotalPrice(){
        int totalPrice = 0;
        for(Movie movie : reservedMovies){
            totalPrice += movie.getPrice();
        }
        return totalPrice;
    }
}
