import java.util.ArrayList;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.TotalPrice;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	public static Movie addMovie() {
		List<Movie> movies = MovieRepository.getMovies();
        MovieRepository movierep = new MovieRepository();
        Movie movie;
        OutputView.printMovies(movies);
        int movieId;
        int movieScheduleId;
        int peopole;
        
        do {
        	movieId = InputView.inputMovieId();
		} while ((movie = movierep.isMovie(movieId)) == null);
        OutputView.printMovie(movie);
        
        do {
        	movieScheduleId = InputView.inputSchedule();
        } while (!movie.isValidSchedule(movieScheduleId));
        
        do {
        	peopole = InputView.inputPeople();
        } while (!movie.isValidCapacity(movie.getPlaySchedule(), peopole));
		
        return movie;
	}
	
	public int getTotalPrice(List<Movie> myMovies) {
		int totalPrice = 0;
		
		for (Movie movie : myMovies) {
			totalPrice += movie.getPrice() * movie.getPeople();
		}
		return totalPrice;
	}
	
	public static void main(String[] args) {
		MovieApplication app = new MovieApplication();
		List<Movie> myMovies = new ArrayList<>();
		TotalPrice totalPrice = new TotalPrice();
		int morePurchase;
		int point;
		int purchaseMethod;
		int purchasePrice;
		
        do {
        	myMovies.add(addMovie());
        	morePurchase = InputView.inputMorePurchase();
		} while (morePurchase == 2);
		
        OutputView.printPurchaseMovies(myMovies);
        totalPrice.setTotalPrice(myMovies);
        
        point = InputView.inputPoint();
        purchaseMethod = InputView.inputCardOrCash();
        purchasePrice = totalPrice.getTotalPrice(point, purchaseMethod);
        
        System.out.println("최종 결제한 금액은 "+purchasePrice+"입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
