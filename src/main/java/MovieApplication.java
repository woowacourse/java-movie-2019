import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        for(int i = 0; i < movies.size(); i++) {
        	if( movieId == movies.get(i).getId()) {
        		for(int j = 0; j < movies.get(i).getPlaySchedules().size(); j++) {
        			System.out.print(movies.get(i).getPlaySchedules().get(j));
        		}
        		break;
        	}
        }
        
    }
}
