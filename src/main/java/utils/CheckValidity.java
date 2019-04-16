package utils;

import domain.Movie;

import java.time.LocalDateTime;
import java.util.List;

public class CheckValidity {
    protected static final int ONE = 1;
    private static final int TWO = 2;
    private static final int MIN_POINT = 0;

    protected static boolean checkValidityIntegerFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형태로 입력해주세요.");
            return false;
        }
        return true;
    }

    protected static boolean checkIsContainOfMovies(List<Integer> movieIdList, int input) {
        if (!movieIdList.contains(input)) {
            System.out.println("없는 영화 번호입니다.");
            return false;
        }
        return true;
    }

    protected static boolean checkIsContainOfBookingTime(Movie movie, int bookingTime) {
        if (!movie.isContainSchedule(bookingTime)) {
            System.out.println("상영이 예정되지 않은 시간을 선택하셨습니다.");
            return false;
        }
        return true;
    }

    protected static boolean checkIsShowTimeBefore(Movie movie, int bookingTime) {
        if (DateTimeUtils.isShowTimeBefore(LocalDateTime.now(), movie.getShowTime(bookingTime))) {
            System.out.println("예약이 불가능한 시간입니다.");
            return false;
        }
        return true;
    }

    protected static boolean checkIsValidityBookingNumber(Movie movie, int bookingTime, int bookingNumber) {
        if (!movie.isValidityBookingNumber(bookingTime, bookingNumber)) {
            System.out.println("예약 인원이 올바르지 않습니다.");
            return false;
        }
        return true;
    }

    protected static boolean checkValidityScopeOfBinary(int number) {
        return ((ONE <= number) && (number <= TWO));
    }

    protected static boolean checkValidityScopeOfPoint(int point) {
        return (point >= MIN_POINT);
    }
}
