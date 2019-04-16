package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private static List<Movie> reservationList = new ArrayList<>();

    public static List<Movie> getList() {
        return reservationList;
    }
}
