import java.util.ArrayList;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.SelectedMovie;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<SelectedMovie> selectedMovies = new ArrayList<SelectedMovie>();
        OutputView.printMovies(movies);

        int movieId = recurInputMovieId();
        Movie selectedMovie = MovieRepository.getMovie(movieId);
        System.out.println(selectedMovie);
        int indexOfSelectedSchedule = recurInputSchedule(selectedMovie);
        PlaySchedule selectedSchedule = selectedMovie.getSchedule(indexOfSelectedSchedule);
        int numOfPeople = recurInputPeople(selectedSchedule);
        selectedMovies.add(new SelectedMovie(selectedMovie, selectedSchedule, numOfPeople));
    }
    
    static int inputMovieIdOnce(){
    	int id = InputView.inputMovieId();
    	MovieRepository.isExist(id);
    	return id;
    }
    
    static int recurInputMovieId() {
    	int id = 0;
    	try {
    		id = inputMovieIdOnce();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			id = recurInputMovieId();
		}
    	return id;
    }
    
    static int inputScheduleOnce(Movie movie){
    	int input = InputView.inputSchedule();
    	if(!movie.isValidSchedule(input))
    		throw new IllegalArgumentException("선택한 영화 상영 스케쥴이 없습니다. \n다시 입력해주세요.");
    	return input;
    }
    
    static int recurInputSchedule(Movie movie) {
    	int input = 0;
    	try {
    		input = inputScheduleOnce(movie);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = recurInputSchedule(movie);
		}
    	return input;
    }
    
    static int inputPeopleOnce(PlaySchedule schedule){
    	int input = InputView.inputNumOfPeople();
    	if(input <= 0)
    		throw new IllegalArgumentException("인원 수는 0보다 커야 합니다. \n다시 입력해 주세요.");
    	if(!schedule.isValidPeople(input))
    		throw new IllegalArgumentException("예약 가능 인원을 초과합니다. \n다시 입력해 주세요.");
    	return input;
    }
    
    static int recurInputPeople(PlaySchedule schedule) {
    	int input = 0;
    	try {
    		input = inputPeopleOnce(schedule);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = recurInputPeople(schedule);
		}
    	return input;
    }
}
