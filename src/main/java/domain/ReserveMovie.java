package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;


public class ReserveMovie {
    private List<Reservation> reservationList = new ArrayList<>();

    public void reserve() {
        do {
            reservationList.add(reserving());
        } while (InputView.inputContinueReserve() == 2);
        printReservationList();
    }

    public void printReservationList() {
        System.out.println("예약 내역");
        for (Reservation re: reservationList) {
            MovieRepository.getMovie(re.getMovieId()).printMovieInfo(re);
            System.out.println("예약 인원: " + re.getMovieTicket());
            System.out.println();
        }
    }

    public Reservation reserving() {
        int movieId;
        int movieTime;
        int movieTicket;
        Reservation reservation;
        do {
            movieId = InputView.inputMovieId();
            MovieRepository.printMovie(movieId);
            movieTime = InputView.inputMovieTime();
            movieTicket = InputView.inputMovieTicket();
            reservation = new Reservation(movieId, movieTime, movieTicket);
        } while (isValidReservation(reservation));
        return reservation;
    }

    public boolean isValidReservation(Reservation reservation) {
        return checkCapacity(reservation)
                || !checkOverlappingTime(reservation)
                || !checkMovieId(reservation);
    }

    /**
     * true : 겹치는 시간 없음
     */
    public boolean checkOverlappingTime(Reservation reservation1) {
        for (Reservation reservation2 : reservationList) {
            if (MovieRepository.checkOverlapping(reservation1, reservation2)) {
                System.out.println("현재 예약한 영화는 이전 예매한 영화 시간과 겹칩니다.");
                return false;
            }
        }
        return true;

    }

    /**
     * true : 예약인원 수용 불가능
     */
    public boolean checkCapacity(Reservation reservation) {
        if (MovieRepository.checkCapacity(reservation)) {
            System.out.println("수용인원을 초과합니다.");
            return true;
        }
        return false;
    }

    /** true : movieId 존재 */
    public boolean checkMovieId(Reservation reservation) {
        if (MovieRepository.containMovieId(reservation.getMovieId())) {
            return true;
        }
        System.out.println("잘못된 영화Id입니다.");
        return false;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        int movieId;
        int movieTicket;
        for (Reservation reservation: reservationList) {
            movieId = reservation.getMovieId();
            movieTicket = reservation.getMovieTicket();
            totalPrice += MovieRepository.getMovie(movieId).getTicketPrice(movieTicket);
        }
        return totalPrice;
    }
}
