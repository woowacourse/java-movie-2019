import domain.CGV;
import domain.Customer;
import domain.MovieRepository;
import domain.Ticket;
import view.InputView;
import view.OutputView;

public class MovieApplication {
    private static CGV theater = new CGV();
    private static Customer customer = new Customer(0);

    public static void main(String[] args) {
        theater.setAbleMovies(MovieRepository.getMovies());

        while (true) {
            OutputView.printMovies(theater.getAbleMovies());

            Ticket ticket = new Ticket();

            // 영화 선택
            ticket = selectMovies(ticket);

            // 예약 시간 선택
            ticket = selectTimes(ticket);

            // 예약할 인원 입력
            ticket = inputCnt(ticket);

            // 예약한 상태로
            customer.reserve(ticket);
            theater.lock(customer);

            // 추가 예약
            if (!InputView.inputExit()) {
                continue;
            }
            break;
        }

        // 확인, 예약 내역 출력
        theater.confirm(customer);

        int point;
        while (true) {
            point = InputView.inputPoint();
            if (customer.getPoint() < point) {
                System.out.println("포인트가 부족합니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        int way;
        while (true) {
            way = InputView.inputWay();
            if (way != CGV.CARD && way != CGV.CASH) {
                System.out.println("결제 방법을 다시 입력해주세요.");
                continue;
            }
            break;
        }

        // 최종 구매
        theater.buy(customer, point, way);
    }

    public static Ticket selectMovies(Ticket ticket) {
        while (true) {
            ticket.setMovieId(InputView.inputMovieId());
            CGV.ReserveMsg movieMsg = theater.checkMoveNumber(ticket);
            if (movieMsg != CGV.ReserveMsg.NONE) {
                System.out.println(movieMsg.getMsg());
                continue;
            }
            break;
        }
        OutputView.printSchedule(theater.getMovie(ticket.movieId));
        return ticket;
    }

    public static Ticket selectTimes(Ticket ticket) {
        while (true) {
            ticket.setTime(InputView.inputTime() - 1);
            CGV.ReserveMsg timeMsg = theater.checkTime(customer.getReserveList(), ticket);
            if (timeMsg != CGV.ReserveMsg.NONE) {
                System.out.println(timeMsg.getMsg());
                continue;
            }
            break;
        }
        return ticket;
    }

    public static Ticket inputCnt(Ticket ticket) {
        while (true) {
            ticket.setCnt(InputView.inputCnt());
            CGV.ReserveMsg cntMsg = theater.checkCnt(ticket);
            if (cntMsg != CGV.ReserveMsg.NONE) {
                System.out.println(cntMsg.getMsg());
                continue;
            }
            break;
        }
        return ticket;
    }
}
