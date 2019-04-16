package utils;

import java.util.List;

import domain.Movie;
import domain.MoviePeoples;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

public class MovieReservation {
	private MoviePeoples people;
	private List<Movie> movies;
	
	public void start() {
		prework();
		Movie selectMovie = getMovie();
		PlaySchedule playScNum = selectScheduleNum(selectMovie);
	}


	private void prework() {
		people= new MoviePeoples();
		movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
	}
	
	private Movie getMovie() {
		try {			
			int movieId = InputView.inputMovieId();
			InputView.isValidId(movieId, movies);
			OutputView.printSchedule(movies,movieId);
			return InputView.getMovieById(movies,movieId);
		} catch (Exception e) {
			System.out.println("상영목록에 없는 영화입니다.");
			return getMovie();
		}
	}

	private PlaySchedule selectScheduleNum(Movie selectMovie) {
		try {			
			
			int timeNumber = InputView.inputMovieTimeNumber(selectMovie, people);
			PlaySchedule playTime = new PlaySchedule(selectMovie.getPlaySchedule()
					.get(timeNumber).getStartTime(), 0);
			return playTime;
		} catch (Exception e) {
			return selectScheduleNum(selectMovie);
		}
	}
	

}
