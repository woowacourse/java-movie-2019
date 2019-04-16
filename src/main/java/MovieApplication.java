import domain.Movie;
import domain.MovieRepository;
import domain.ReservationInputValidator;
import domain.ReservationPlanner;
import java.util.List;
import java.util.Scanner;
import view.OutputView;

public class MovieApplication {

    public static void main(String[] args) {
        ReservationPlanner reservationPlanner;
        do {
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            Scanner scanner = new Scanner(System.in);
            System.out.println("## 예약할 영화를 선택하세요.");
            String line = scanner.nextLine();
            ReservationInputValidator inputValidator = new ReservationInputValidator();
            List<Integer> movieNumbers = inputValidator.getReservationMovieNumbers(line);
            reservationPlanner = new ReservationPlanner();
            for (Integer movieNumber : movieNumbers) {
                reservationPlanner.displayMovieSchedule(movieNumber);
                System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
                Integer movieEntry = scanner.nextInt();
                System.out.println("## 예약할 인원을 입력하세요.");
                Integer capacity = scanner.nextInt();
                reservationPlanner.selectReservationEntry(movieNumber, movieEntry);
                reservationPlanner.selectReservationCapacity(movieNumber, movieEntry, capacity);
            }
        } while (cont());
        reservationPlanner.getPlans().forEach(System.out::println);
    }

    private static boolean cont() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        return scanner.nextInt() == 1;
    }

}
