
import domain.CheckValid;
import domain.Customer;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	static boolean isMovieValid = false;
	static boolean isTimeValid = false;
	static boolean isCapacityValid = false;
	static boolean isNextStepValid = false;
	static boolean isPointValid = false;
	static boolean isCashValid = false;
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		MovieRepository repository = new MovieRepository();
		CheckValid checkValid = new CheckValid(customer, repository);
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);

		init(customer, checkValid);
	}

	
	
	private static void init(Customer customer, CheckValid checkValid) {
		inputMovie(customer, checkValid);
		inputTime(customer, checkValid);
		inputCapacity(customer, checkValid);
		inputNextStep(customer, checkValid);
		inputPoint(customer, checkValid);
		inputCash(customer, checkValid);
	}



	private static void inputMovie(Customer customer, CheckValid checkValid) {
		isMovieValid = false;

		while (isMovieValid == false) {
			int movieId = InputView.inputMovieId();
			isMovieValid = checkValid.checkMovieId(movieId);
			if (isMovieValid == true) {
				customer.setMovieId(movieId);
				List<PlaySchedule> playSchedules = MovieRepository.searchPlaySchedules(customer.getMovieId());
				OutputView.printSchedules(playSchedules);
				customer.setPlaySchedules(playSchedules);
			}
		}

	}

	private static void inputTime(Customer customer, CheckValid checkValid) {
		isTimeValid = false;

		while (isMovieValid == true && isTimeValid == false) {
			int movieTime = InputView.inputMovieTime();
			isTimeValid = CheckValid.checkTimeValid(movieTime);

			if (isTimeValid == true) {
				customer.setMovieTime(movieTime);
				customer.addMovie(movieTime);
			}
		}
	}

	private static void inputCapacity(Customer customer, CheckValid checkValid) {
		isCapacityValid = false;

		while (isMovieValid == true && isTimeValid == true && isCapacityValid == false) {
			int groupSize = InputView.inputGroupSize();
			isCapacityValid = CheckValid.checkGroupSizeValid(groupSize);
			if (isCapacityValid) {
				customer.setTicketNum(groupSize);
			}
		}
	}

	private static void inputNextStep(Customer customer, CheckValid checkValid) {
		isNextStepValid = false;

		while (isMovieValid == true && isTimeValid == true && isCapacityValid == true && isNextStepValid == false) {
			int nextStep = InputView.inputNextStep();
			isNextStepValid = CheckValid.checkNextStepValid(nextStep);
			if (isNextStepValid == true && nextStep == 1) {
				customer.buyTickets();
				customer.setNextStep(nextStep);
				OutputView.printCurState(customer);
			} else if (isNextStepValid == true && nextStep == 2) {
				init(customer, checkValid);
			}
		}
	}

	private static void inputPoint(Customer customer, CheckValid checkValid) {
		isPointValid = false;

		while (isMovieValid == true && isTimeValid == true && isCapacityValid == true && isNextStepValid == true
				&& isPointValid == false) {
			int point = InputView.inputPoint();
			isPointValid = CheckValid.checkPointValid(point);
			if (isPointValid == true) {
				customer.setPoint(point);
			}
		}

	}

	private static void inputCash(Customer customer, CheckValid checkValid) {
		isCashValid = false;

		while (isMovieValid == true && isTimeValid == true && isCapacityValid == true && isNextStepValid == true
				&& isPointValid == true && isCashValid == false) {
			int cashOrCredit = InputView.inputCashOrCredit();
			isCashValid = CheckValid.checkPointValid(cashOrCredit);
			if (isCashValid == true) {
				int result = customer.calculateResult();
				OutputView.printResult(result);
			}
		}
	}
}
