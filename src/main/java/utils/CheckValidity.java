package utils;

import domain.Movie;

import java.util.List;

public class CheckValidity {
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

    protected static boolean checkIsContainOfReservationTime(Movie movie, int reservationTime) {
        return movie.isContainSchedule(reservationTime);
    }
}
