import domain.Movie;
import domain.PlaySchedule;

public class BookedMovie {
    private static Movie bookedMovie;
    private static PlaySchedule selectedPlaySchedule;
    private static int reservedPersonCount;

    BookedMovie(Movie selectedMovie) {
        bookedMovie = selectedMovie;
    }

}
