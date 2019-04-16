package domain;

public class Reservation {

    private int movieId;
    private int scheduleNumber;
    private int numberOfPeople;

    public Reservation(int movieId, int scheduleNumber, int numberOfPeople){
        this.movieId=movieId;
        this.scheduleNumber=scheduleNumber;
        if(this.numberOfPeople > MovieRepository.getMovieById(movieId).getPlaySchedule().get(movieId).getCapacity()){
            throw new IllegalArgumentException
                    ("예약 가능 인원보다 더 많은 예약인원을 입력하였습니다.");
        }
        this.numberOfPeople=numberOfPeople;
    }

    public int price() {
        return MovieRepository.getMovieById(movieId).getPrice() * this.numberOfPeople;
    }
}
