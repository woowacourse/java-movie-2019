package view;

import java.util.*;
import java.util.stream.Collectors;

import domain.Movie;

import domain.MovieRepository;
import validator.MovieListValidator;
import validator.ScheduleValidator;
import validator.Validator;

public class InputView {
    private static final String INPUT_DELIMITER = ",";
    private static final String SCHEDULE_DELIMITER = ":";

    private final Scanner scanner;
    private Validator validator;

    public InputView() {
        scanner = new Scanner(System.in);
        validator = null;
    }

    public List<Integer> inputMovieIds() {
        String[] inputs = null;
        do {
            System.out.println("## 예약할 영화들을 " + INPUT_DELIMITER + " 를 기준으로 나눠서" + " 선택하세요.");
            inputs = scanner.nextLine().split(INPUT_DELIMITER);
            eraseWhiteSpace(inputs);
            validator = new MovieListValidator(Arrays.asList(inputs));
        } while (!validator.doesValid());

        printSelectedMoviesById(inputs);
        return Collections.unmodifiableList(
                Arrays.asList(inputs).stream().map(Integer::parseInt).collect(Collectors.toList()));
    }

    public Map<Integer, Integer> inputMovieSchedules() {
        String[] inputs = null;
        do {
            System.out.println("## 각 영화별 예약할 시간표를 " + SCHEDULE_DELIMITER + " 를 기준으로 하여"
                    + "선택하세요(첫번째 상영 시간이 1번)." + "  e.g. 1:1, 5:3");
            inputs = scanner.nextLine().split(INPUT_DELIMITER);
            eraseWhiteSpace(inputs);
            validator = new ScheduleValidator(Arrays.asList(inputs));
        } while (!validator.doesValid());

        return makeMovieSchedules(inputs);
    }

    private Map<Integer, Integer> makeMovieSchedules(String[] inputs) {
        Map<Integer, Integer> result = new HashMap<>();
        for (String s : inputs) {
            String[] movieAndSchedule = s.split(SCHEDULE_DELIMITER);
            result.put(Integer.parseInt(movieAndSchedule[0]), Integer.parseInt(movieAndSchedule[1]));
        }
        return Collections.unmodifiableMap(result);
    }

    private void eraseWhiteSpace(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = inputs[i].replaceAll("\\s", "");
        }
    }

    private void printSelectedMoviesById(String[] inputs) {
        List<Movie> selectedMovies = new ArrayList<>();
        List<Movie> movies = MovieRepository.getMovies();
        for (int i = 0; i < inputs.length; i++) {
            selectedMovies.add(MovieRepository.getMovieById(Integer.parseInt(inputs[i])));
        }
        OutputView.printMovies(selectedMovies);
    }
}
