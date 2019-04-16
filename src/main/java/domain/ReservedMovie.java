package domain;

import java.time.LocalDateTime;

public class ReservedMovie {

    private Movie movie;
    private LocalDateTime time;
    private int reservingNumber;

    public ReservedMovie(Movie movieReserved, LocalDateTime reservedMovieTimeInfo, int reservedNumberInfo){
        movie = movieReserved;
        time = reservedMovieTimeInfo;
        reservingNumber = reservedNumberInfo;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(movie.getId() + " - " + movie.getName() + ", " + movie.getPrice() + "원\n" +
                "시작시간 : " + time + "\n" + "예약 인원 : " + reservingNumber + "명");
        return sb.toString();
    }

    public int getReservingNumber() {
        return reservingNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Movie getMovie() {
        return movie;
    }
}
