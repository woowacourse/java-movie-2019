package domain;

import java.time.LocalDateTime;
import java.util.List;

public class CGV {
    public static int CARD = 1, CASH = 2;
    public static int CARD_RATE = 5, CASH_RATE = 2;

    public enum ReserveMsg {
        NONE(""),
        MOVE_NUM_ERROR("선택한 영화는 없습니다."),
        TIME_ERROR("예약한 상영시간은 서로 1시간 이상 차이날 수 없습니다."),
        CNT_ERROR("예약 가능 인원을 잘못 입력했습니다."),
        NONE_TIME("예약 가능한 시간이 없습니다.");

        String msg;

        ReserveMsg(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    private List<Movie> ableMovies;

    public List<Movie> getAbleMovies() {
        return ableMovies;
    }

    public void setAbleMovies(List<Movie> ableMovies) {
        this.ableMovies = ableMovies;
    }

    public CGV() {
    }

    public CGV(List<Movie> ableMovies) {
        this.ableMovies = ableMovies;
    }

    public ReserveMsg checkMoveNumber(Ticket ticket) {
        return (getMovie(ticket.movieId) == null ? ReserveMsg.MOVE_NUM_ERROR : ReserveMsg.NONE);
    }

    public ReserveMsg checkTime(List<Ticket> customerReserveList, Ticket ticket) {
        if (ticket.time < 0 || getMovie(ticket.movieId).getPlaySchedules().size() <= ticket.time) {
            return ReserveMsg.NONE_TIME;
        }
        LocalDateTime reserveDate = getMovie(ticket.movieId).getPlaySchedules().get(ticket.time).getTime();
        for (Ticket i : customerReserveList) {
            LocalDateTime customerDate = getMovie(i.movieId).getPlaySchedules().get(i.time).getTime();
            if (!utils.DateTimeUtils.isOneHourWithinRange(reserveDate, customerDate)) {
                return ReserveMsg.TIME_ERROR;
            }
        }
        return ReserveMsg.NONE;
    }

    public ReserveMsg checkCnt(Ticket ticket) {
        final int maxCnt = getMovie(ticket.movieId).getPlaySchedules().get(ticket.time).getCapacity();
        // todo: 0 이하 예외 아직 안했음
        if (maxCnt < ticket.cnt) {
            return ReserveMsg.CNT_ERROR;
        }
        return ReserveMsg.NONE;
    }

    public Movie getMovie(int movieNum) {
        for (Movie i : ableMovies) {
            if (i.getId() == movieNum) {
                return i;
            }
        }
        return null;
    }

    public void confirm(Customer customer) {
        System.out.println("예약 내역");
        for (Ticket i : customer.getReserveList()) {
            System.out.println(i.movieId + " - " + getMovie(i.movieId).getName());
            System.out.println("예약 인원: " + i.cnt);
            System.out.println(getMovie(i.movieId).getPlaySchedules().get(i.time).getTime().toString());
        }
    }

    public int calcPri(Customer customer) {
        int total = 0;
        for (Ticket i : customer.getReserveList()) {
            total += (getMovie(i.movieId).getPrice() * i.cnt);
        }
        return total;
    }

    public void lock(Customer customer) {
        List<Ticket> tickets = customer.getReserveList();
        for (Ticket i : tickets) {
            getMovie(i.movieId).getPlaySchedules().get(i.time).declineCnt(i.cnt);
        }
    }

    public void unlock(Customer customer) {
        List<Ticket> tickets = customer.getReserveList();
        for (Ticket i : tickets) {
            getMovie(i.movieId).getPlaySchedules().get(i.time).plusCnt(i.cnt);
        }
    }

    public void buy(Customer customer, int point, int way) {
        lock(customer);
        System.out.println(calcPri(customer));
        final int price = (int) ((((double) calcPri(customer) - point) * (100 - (way == CARD ? CARD_RATE : CASH_RATE))) / 100);

        System.out.println("최종 결제한 금액은 " + price + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
