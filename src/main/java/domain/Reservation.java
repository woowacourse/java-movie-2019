package domain;

import java.util.List;

public class Reservation {
    private static List<Movie> movies = MovieRepository.getMovies();
    private final int movieId;
    private final int movieTime;
    private final int numOfGuest;

    public Reservation(int movieId, int movieTime, int numOfGuest) {
        this.movieId = movieId;
        this.movieTime = movieTime;
        this.numOfGuest = numOfGuest;
    }

    /**
     * 해당 예약의 총 티켓 금액을 리턴
     */
    public int getTicketPrice() {
        Movie movie = MovieRepository.getMovie(movieId);
        int ticketPrice = movie.getPrice(numOfGuest);
        return ticketPrice;
    }

    public void printReservation() {
        Movie movie = MovieRepository.getMovie(movieId);
        movie.printMovieInfo();
        System.out.print("시작시간: ");
        movie.printStartDateTime(movieTime);
        System.out.println();
        System.out.println("예약 인원: " + numOfGuest + "명");
    }

    public void modifyCapacity() {
        Movie movie = MovieRepository.getMovie(movieId);
        movie.modifyCapacity(movieTime, numOfGuest);
    }
}