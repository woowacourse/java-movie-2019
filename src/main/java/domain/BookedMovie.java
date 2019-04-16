package domain;

public class BookedMovie {
    private static final char NEW_LINE = '\n';
    private final Movie bookedMovie;
    private PlaySchedule selectedPlaySchedule;
    private int reservedPersonCount;

    public BookedMovie(Movie selectedMovie) {
        bookedMovie = selectedMovie;
    }

    public void updateSchedule(PlaySchedule selectedSchedule) {
        selectedPlaySchedule = selectedSchedule;
    }

    public void updateReservedPersonCount(int personCount) {
        reservedPersonCount = personCount;
    }

    public void printReservation() {
        bookedMovie.printMovieWithoutSchedule();
        selectedPlaySchedule.printScheduleStartTime();
        System.out.format("예약 인원 : %d명" + NEW_LINE, reservedPersonCount);
    }

    public boolean checkMovieId(int movieId) {
        return bookedMovie.hasSameId(movieId);
    }

    public int getChargePerMovie() {
        return bookedMovie.getChargeForPeople(reservedPersonCount);
    }

    public boolean isWithinOneHour(PlaySchedule anotherSchedule) {
        return selectedPlaySchedule.isWithinOneHour(anotherSchedule);
    }
}
