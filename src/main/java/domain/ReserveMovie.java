package domain;

public class ReserveMovie {
    private static final char NEW_LINE = '\n';

    private Movie movie;
    private int reservePersonCount;
    private int selectedMovieSchedule;

    public ReserveMovie(Movie movie, int reservePersonCount, int selectedMovieSchedule) {
        this.movie = movie;
        this.reservePersonCount = reservePersonCount;
        this.selectedMovieSchedule = selectedMovieSchedule;
    }

    @Override
    public String toString() {
        return "예약 내역" + NEW_LINE + movie.getId() + " - " + movie.getName() + ", " + movie.getPrice() + "원" + NEW_LINE
                + "시작시간" + movie.getPlaySchedules().get(selectedMovieSchedule - 1).getStartDateTime() + NEW_LINE + "예약 인원: " + reservePersonCount + NEW_LINE;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getReservePersonCount() {
        return reservePersonCount;
    }
}
