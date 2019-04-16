import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        OutputView.PrintChoiceMovie(movies, movieId);
        ChoicePlaySchedule();

        // TODO 구현 진행
    }

    public static int ChoicePlaySchedule()
    {
        int Choice_PlaySchedule ;
        Scanner sc = new Scanner(System.in);
        System.out.println("##예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        Choice_PlaySchedule = sc.nextInt();
        return Choice_PlaySchedule;
    }

}

