package view;

        import domain.Movie;
        import domain.Pay;
        import domain.ReservingMovie;

        import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printDetailsOfReservingMovie(List<ReservingMovie> reservingMovies) {
        for (ReservingMovie reservingMovie : reservingMovies) {
            System.out.println(reservingMovie);
        }
    }

    public static void printResultPrice(Pay pay, int paymentMethod) {
        System.out.println("최종 결제한 금액은 " + pay.getPaymentPrice(paymentMethod)
                + "원 입니다." + "\n" + "예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
