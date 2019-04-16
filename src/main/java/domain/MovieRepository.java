package domain;

import static utils.DateTimeUtils.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieRepository {
	private static List<Movie> movies = new ArrayList<>();

	static {
		Movie movie1 = new Movie(1, "생일", 8_000);
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 12:00"), 6));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 14:40"), 6));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 17:00"), 6));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 19:40"), 3));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 22:00"), 3));
		movies.add(movie1);

		Movie movie2 = new Movie(5, "돈", 10_000);
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 08:00"), 3));
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 10:30"), 5));
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 5));
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:30"), 5));
		movies.add(movie2);

		Movie movie3 = new Movie(7, "파이브피트", 9_000);
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 4));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:40"), 4));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 18:00"), 4));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 20:40"), 3));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 23:15"), 3));
		movies.add(movie3);

		Movie movie4 = new Movie(8, "덤보", 9_000);
		movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 11:30"), 2));
		movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 16:00"), 3));
		movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 21:30"), 2));
		movies.add(movie4);
	}

	public static List<Movie> getMovies() {
		return movies;
	}

	public static List<Integer> getMoviesId() {
		List<Integer> movieId = new ArrayList<Integer>();
		Iterator<Movie> it = movies.iterator();
		while (it.hasNext()) {
			Movie movie = (Movie) it.next();
			movieId.add(movie.getId());
		}
		return movieId;
	}

	public static Movie getMovieById(int id) {
		Iterator<Movie> it = movies.iterator();
		while (it.hasNext()) {
			Movie movie = (Movie) it.next();
			if (movie.hasId(id)) {
				return movie;
			}
		}
		return null;
	}
}
