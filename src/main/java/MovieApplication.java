import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieApplication {
    static private final List<Movie> movies = MovieRepository.getMovies();
    static private final List<BookingInfo> bookingList = new ArrayList<>();

    static private final int PROCEED_AND_PAY = 1;
    static private final int REPEAT_PROCESS = 2;
    static private final int CREDIT_CARD = 1;
    static private final int CASH = 2;
    static private final double[] DISCOUNT = { 0.95, 0.98 };

    public static void main(String[] args) {
        while (true) {
            Movie movie;
            PlaySchedule schedule;
            int capacity;
            int point;
            int payType;

            OutputView.printMovies(movies);

            movie = getMovieById(InputView.inputMovieId());
            System.out.println(movie);

            schedule = validateSchedule(movie, InputView.inputSchedule());

            System.out.println();
            capacity = validateCapacity(schedule, InputView.inputCapacity());

            book(movie, schedule, capacity);

            System.out.println();
            if (validateCommand(InputView.inputPayOrRepeatMenu()) == PROCEED_AND_PAY) {
                printBookingList();

                System.out.println();
                point = validatePoint(InputView.inputPoint());

                System.out.println();
                payType = validatePayType(InputView.inputPayType());

                System.out.println();
                OutputView.printResult((int) ((calcTotalPrice() - point) * DISCOUNT[payType - 1]));

                return;
            }
        }
    }

    private static Movie getMovieById(int id) {
        Optional<Movie> movie = movies.stream().filter(x -> x.getId() == id).findFirst();

        if (movie.isPresent()) {
            return movie.get();
        }
        OutputView.printNoMovieMessage();
        return getMovieById(InputView.inputMovieId());
    }

    private static PlaySchedule validateSchedule(Movie movie, int no) {
        Optional<PlaySchedule> schedule = movie.getScheduleByNumber(no);

        if (schedule.isPresent()) {
            return validateScheduleTime(movie, schedule.get());
        }
        OutputView.printNoScheduleMessage();
        return validateSchedule(movie, InputView.inputSchedule());
    }

    private static PlaySchedule validateScheduleTime(Movie movie, PlaySchedule schedule) {
        if (schedule.isNotStartedYet()) {
            return schedule;
        }
        OutputView.printAlreadyStartedMessage();
        return validateSchedule(movie, InputView.inputSchedule());
    }

    private static int validateCapacity(PlaySchedule schedule, int capacity) {
        if ((1 <= capacity) && (capacity <= schedule.getCapacity())) {
            schedule.book(capacity);
            return capacity;
        }
        OutputView.printNotEnoughCapacityMessage();
        return validateCapacity(schedule, InputView.inputCapacity());
    }

    private static int validateCommand(int menu) {
        if (menu == PROCEED_AND_PAY || menu == REPEAT_PROCESS) {
            return menu;
        }
        OutputView.printInvalidCommandMessage();
        return validateCommand(InputView.inputPayOrRepeatMenu());
    }

    private static void printBookingList() {
        System.out.println("예약 내역");
        for (int i = 0; i < bookingList.size(); i++) {
            BookingInfo info = bookingList.get(i);
            System.out.println((i + 1) + " - " + info.getInfo());
        }
    }

    private static void book(Movie movie, PlaySchedule schedule, int capacity) {
        Optional<BookingInfo> info = bookingList.stream().filter(x -> x.getId() == movie.getId()).findFirst();

        if (info.isPresent()) {
            info.get().addCapacity(capacity);
            return;
        }
        bookingList.add(new BookingInfo(movie, schedule, capacity));
    }

    private static int validatePoint(int point) {
        if (point >= 0) {
            return point;
        }
            OutputView.printInvalidPointMessage();
            return validatePoint(InputView.inputPoint());
    }

    private static int validatePayType(int payType) {
        if (payType == CREDIT_CARD || payType == CASH) {
            return payType;
        }
        OutputView.printInvalidPayType();
        return validatePayType(InputView.inputPayType());
    }

    private static int calcTotalPrice() {
        int total = 0;

        for (BookingInfo info : bookingList) {
            total += info.getTotalPricePerMovie();
        }
        return total;
    }
}

class BookingInfo {
    private Movie movie;
    private PlaySchedule schedule;
    private int capacity;

    BookingInfo(Movie movie, PlaySchedule schedule, int capacity) {
        this.movie = movie;
        this.schedule = schedule;
        this.capacity = capacity;
    }

    public int getId() { return movie.getId(); }

    public void addCapacity(int capacity) { this.capacity += capacity; }

    public String getInfo() {
        return movie.getTitle() + ", " + movie.getPrice()
                + "원\n시작시간: " + schedule.getTime() + "\n예약 인원: " + capacity + "명";
    }

    public int getTotalPricePerMovie() { return movie.getPrice() * capacity; }
}