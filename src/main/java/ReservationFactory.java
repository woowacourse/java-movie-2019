import domain.MovieReservation;

public class ReservationFactory {
    public MovieReservation createFromUser() {
        System.out.println("createFromUser called");

        return new MovieReservation();
    }
}
