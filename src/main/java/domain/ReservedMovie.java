package domain;

public class ReservedMovie {
    private final Movie reservedMovie;

    public ReservedMovie(int reserveMovie){
        if(!MovieRepository.isValidMovieId(reserveMovie)){
            throw new IllegalArgumentException("올바른 영화번호를 입력해 주세요.");
        }

        this.reservedMovie = MovieRepository.getMovie(reserveMovie);
    }

    public Movie getReservedMovie() {
        return reservedMovie;
    }
}
