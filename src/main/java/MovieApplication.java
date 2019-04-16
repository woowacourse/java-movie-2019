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
        
        /*입력 받은 영화를 추가한다.*/
        for(int i = 0; i < movies.size(); i++) {
        	if( movieId == movies.get(i).getId()) {
        		for(int j = 0; j < movies.get(i).getPlaySchedules().size(); j++) {
        			System.out.print(movies.get(i).getPlaySchedules().get(j));
        		}
        		break;
        	}
        }
        
        System.out.println("##예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번");
        
    }
}
