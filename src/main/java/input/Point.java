package input;

import domain.ReservedMovie;

import java.util.List;

public class Point {
    private int pointNumber;

    public Point(String input, List<ReservedMovie> reservedMovies) {
        if (checkValidity(input, reservedMovies) == false) {
            throw new IllegalArgumentException();
        }
        pointNumber = Integer.parseInt(input);

    }

    private boolean checkValidity(String input, List<ReservedMovie> reservedMovies) {
        int number = Integer.parseInt(input);
        int moviesCost = getCostFromReservedList(reservedMovies);

        return number >= 0 && number <= moviesCost;
    }

    public static int getCostFromReservedList(List<ReservedMovie> reservedMovies) {
        int cost = 0;
        for (ReservedMovie reservedMovie : reservedMovies
             ) {
            cost += reservedMovie.costIs();
        }
        return cost;
    }

    public int numberIs() {
        return pointNumber;
    }
}
