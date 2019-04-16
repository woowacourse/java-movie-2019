package domain;

public class MovieReservation {
    private static final char NEW_LINE = '\n';

    private int id;
    private int movieTime;
    private int capacity;

    public MovieReservation(int id, int movieTime, int capacity) {
        this.id = id;
        this.movieTime = movieTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        Movie movie = MovieRepository.getMovieForMovieId(id);
        StringBuilder sb = new StringBuilder();
        sb.append(movie.movieInformation()).append(NEW_LINE);
        sb.append(movie.movieTimeInformation(movieTime));
        sb.append("예약인원: ").append(capacity);
        return sb.toString();
    }
}
