package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utils.DateTimeUtils;

public class ReservationPlanner {

    private List<ReservationRecord> reservationRecords = new ArrayList<>();

    public Integer displayMovieSchedule(Integer movieId) {
        if (MovieRepository.isMovieExists(movieId)) {
            MovieRepository.displayMovie(movieId);
            return movieId;
        }
        throw new IllegalArgumentException("올바른 영화 번호가 아닙니다.");
    }

    public Integer selectReservationEntry(Integer movieId, Integer movieEntryNumber) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        if (MovieRepository.isValidEntryNumber(movieId, movieEntryNumber)) {
            return movieEntryNumber;
        }
        throw new IllegalArgumentException(" 올바른 예약 엔트리 번호가 아닙니다.");
    }

    public void selectReservationCapacity(Integer movieId, Integer movieEntryNumber, Integer capacity) {
        System.out.println("## 예약할 인원을 입력하세요.");
        if (MovieRepository.isConsumable(movieId, movieEntryNumber, capacity)
            && checkReservationRecordsAllInOneHour()
            && checkMovieAlreadyStarted(movieId, movieEntryNumber)) {
            MovieRepository.consumeCapacity(movieId, movieEntryNumber, capacity);
            reservationRecords.add(new ReservationRecord(movieId, movieEntryNumber, capacity));
        }
        throw new IllegalArgumentException("올바른 예약인원이 아닙니다.");
    }

    boolean checkReservationRecordsAllInOneHour() {
        boolean isWithinHour = true;
        for (ReservationRecord reservationRecord : reservationRecords) {
            LocalDateTime dateTime2 = reservationRecord.getMovieStartDateTime();
            isWithinHour = isWithinHour && reservationRecords.stream().map(
                ReservationRecord::getMovieStartDateTime)
                .allMatch(dateTime1 -> DateTimeUtils.isOneHourWithinRange(dateTime1, dateTime2));
        }
        return isWithinHour;
    }


    boolean checkMovieAlreadyStarted(Integer movieId, Integer movieEntryNumber) {
        return MovieRepository.hasStarted(movieId, movieEntryNumber);
    }

}

