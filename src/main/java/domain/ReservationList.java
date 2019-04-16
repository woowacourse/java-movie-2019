package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {
	private static List<Reservation> reservations = new ArrayList<>();
	
	public static void addReservation(Reservation input) {
		reservations.add(input);
	}
	
	public static List<Reservation> getReservations() {
		return reservations;
	}

}
