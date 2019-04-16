import domain.MovieReservation;

public class MovieApplication {
    public static void main(String[] args) {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.reservationMovie();
        int totalPrice = movieReservation.totalPrice();
        System.out.println(totalPrice);
        // TODO 구현 진행
    }
}
