package utils;

import domain.Movie;

public class Validator {

    public static boolean nullChecker(Movie movie){
        return movie != null;
    }

    public static boolean scheduleSizeChecker(Movie movie, int size){
        return movie.getPlaySchedules().size() > size;
    }

    public static boolean movieAvailableSeat(Movie movie, int personCount, int movieSechdule){
        return movie.getPlaySchedules().get(movieSechdule).getCapacity() >= personCount;
    }

    public static boolean lastInputChecker(int order){
        return order > 0 && order < 3;
    }

}
