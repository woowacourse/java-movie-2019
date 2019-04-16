package domain;

public class ReservationInfo {
    private int movieId;
    private int scheduleNumber;
    private int reservationCount;

    public ReservationInfo(int movieId, int scheduleNumber, int reservationCount) {
        this.movieId = movieId;
        this.scheduleNumber = scheduleNumber;
        this.reservationCount = reservationCount;
    }

    @Override
    public String toString() {
        Movie reservationMovie = MovieRepository.getMovieById(movieId);
        return reservationMovie.summaryMessage(scheduleNumber) + "예약 인원 : " + reservationCount + "명\n";
    }
}
