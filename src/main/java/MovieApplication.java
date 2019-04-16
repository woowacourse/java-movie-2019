import domain.Movie;
import domain.MovieRepository;
import domain.SelectedMovie;
import domain.reserveList;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);

		List<Integer> movieIdList = new ArrayList<Integer>();
		for (Movie movie : movies) {
			movieIdList.add(movie.getId());
		}
		
		List<reserveList> reservedList = new ArrayList<>();
		do{
			int movieId;
			while (true) {
				movieId = InputView.inputMovieId();
				if (!movieIdList.contains(movieId)) {
					System.out.println("해당 ID의 영화가 없습니다. 다시 입력해 주세요.");
					continue;
				}
				break;
			}
			SelectedMovie selectedMovie = new SelectedMovie(OutputView.findMovie(movies, movieId));
			int movieTime;
			while (true) {
				movieTime = InputView.inputMovieTime();
				if (movieTime < 1 || movieTime > selectedMovie.getMovie().getSchedule().size()) {
					System.out.println("해당 시간표가 존재하지 않습니다. 다시 입력해 주세요.");
					continue;
				}
				OutputView.printSelectTime(selectedMovie.getMovie(), movieTime - 1);
				break;
			}
			
			int ticketNum;
			while(true){
				ticketNum = InputView.ticketNum();
				if(ticketNum>selectedMovie.getMovie().getSchedule().get(movieTime-1).getCapacity()){
					System.out.println("좌석수가 부족합니다. 다시 입력해 주세요.");
					continue;
				}
				if(ticketNum<1){
					System.out.println("입력값이 유효하지 않습니다. 다시 입력해주세요");
					continue;
				}
				break;
			}
			reservedList.add(new reserveList(selectedMovie.getMovie(), movieTime, ticketNum));
			
		}while(InputView.inputStopOrGo());
		
		OutputView.printState();
		System.out.println("예약내역");
		int total_price=0;
		for(reserveList l : reservedList){
			l.printHistory();
			total_price += l.getTotalPrice();
		}
		int point = InputView.inputPoint(total_price);
		
		int cardOrCash = InputView.inputCardOrCash();
		OutputView.printResult();
	}
}
