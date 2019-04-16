import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.SelectedMovie;
import view.InputView;
import view.OutputView;

public class MovieApplication {

	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		List<SelectedMovie> selectedMovies = new ArrayList<SelectedMovie>();
		OutputView.printMovies(movies);
		recurSelectMovieOrNot(movies, selectedMovies);
		OutputView.printSelectedMovies(selectedMovies);
	}

	static void isExist(List<Movie> movies, int id) {
		int isNot = 1;
		for (Movie movie : movies) {
			isNot *= (movie.isTheMovie(id)) ? 0 : 1;
		}
		if (isNot == 1) {
			throw new IllegalArgumentException("해당 아이디의 영화가 없습니다. \n다시 입력해주세요.");
		}
	}

	static Movie getMovie(List<Movie> movies, int id) {
		Movie ret = null;
		Iterator<Movie> it = movies.iterator();
		while (it.hasNext() && ret == null) {
			Movie tmp = it.next();
			ret = (tmp.isTheMovie(id)) ? tmp : null;
		}
		return ret;
	}

	static boolean isThereValidTicket(Movie newMovie, List<SelectedMovie> selectedMovies) {
		return false;
	}

	static int inputMovieIdOnce(List<Movie> movies) {
		int id = InputView.inputMovieId();
		isExist(movies, id);
		return id;
	}

	static int recurInputMovieId(List<Movie> movies) {
		int id = 0;
		try {
			id = inputMovieIdOnce(movies);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			id = recurInputMovieId(movies);
		}
		return id;
	}

	static int inputScheduleOnce(List<SelectedMovie> selectedMovies, Movie movie) {
		int input = InputView.inputSchedule();
		movie.isValidSchedule(input);
		if (!isValidStartTime(selectedMovies, movie, input))
			throw new IllegalArgumentException("이미 선택한 영화와 시작시간이 한시간 이상 차이납니다. \n다시 입력해주세요.");
		return input;
	}

	static int recurInputSchedule(List<SelectedMovie> selectedMovies, Movie movie) {
		int input = 0;
		try {
			input = inputScheduleOnce(selectedMovies, movie);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = recurInputSchedule(selectedMovies, movie);
		}
		return input;
	}

	static boolean isValidStartTime(List<SelectedMovie> selectedMovies, Movie movie, int scheduleIndex) {
		int isValid = 1;
		for (SelectedMovie selectedMovie : selectedMovies) {
			isValid *= selectedMovie.isWithInOneHour(movie, scheduleIndex) ? 1 : 0;
		}
		return (isValid == 1);
	}

	static int inputPeopleOnce(Movie movie, int scheduleIndex) {
		int input = InputView.inputNumOfPeople();
		if (input < 0)
			throw new IllegalArgumentException("인원 수는 0보다 크거나 같아야 합니다. \n다시 입력해 주세요.");
		if (!movie.isThereEnoughTicket(scheduleIndex, input))
			throw new IllegalArgumentException("예약 가능 인원을 초과합니다. \n다시 입력해 주세요.");
		return input;
	}

	static int recurInputPeople(Movie movie, int scheduleIndex) {
		int input = 0;
		try {
			input = inputPeopleOnce(movie, scheduleIndex);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = recurInputPeople(movie, scheduleIndex);
		}
		return input;
	}

	static SelectedMovie inputSelectedMovieOnce(List<Movie> movies, List<SelectedMovie> selectedMovies) {
		int movieId = recurInputMovieId(movies);
		Movie selectedMovie = getMovie(movies, movieId);
		System.out.println(selectedMovie);
		int indexOfSelectedSchedule = recurInputSchedule(selectedMovies, selectedMovie);
		int numOfPeople = recurInputPeople(selectedMovie, indexOfSelectedSchedule);
		return new SelectedMovie(selectedMovie, indexOfSelectedSchedule, numOfPeople);
	}

	static void subtractCapacity(List<Movie> movies, SelectedMovie selectedMovie) {
		int movieId = selectedMovie.getMovie().getId();
		int indexOfSchedule = selectedMovie.getIndexOfSelectedSchedule();
		int numOfPeople = selectedMovie.getNumOfPeople();
		Movie movie = getMovie(movies, movieId);
		movie.sellTicket(indexOfSchedule, numOfPeople);
	}

	static int recurInputRechoiceOrNot() {
		int input = 0;
		try {
			input = InputView.inputRechoiceOrNot();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = InputView.inputRechoiceOrNot();
		}
		return input;
	}

	static void selectMovie(List<Movie> movies, List<SelectedMovie> selectedMovies) {
		SelectedMovie selectedMovie = inputSelectedMovieOnce(movies, selectedMovies);
		if (selectedMovie.getNumOfPeople() != 0) {
			selectedMovies.add(selectedMovie);
			subtractCapacity(movies, selectedMovie);
		}
	}

	static void recurSelectMovieOrNot(List<Movie> movies, List<SelectedMovie> selectedMovies) {
		int swc = 2;
		do {
			selectMovie(movies, selectedMovies);
			swc = recurInputRechoiceOrNot();
		} while (swc == 2);
	}
}
