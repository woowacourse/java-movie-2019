package utils;

import java.util.List;

public class CheckValidity {
    protected boolean checkValidityIntegerFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형태로 입력해주세요.");
            return false;
        }
        return true;
    }

    protected boolean checkIsContainOfMovies(List<Integer> movieIdList, int input) {
        if (!movieIdList.contains(input)) {
            System.out.println("없는 영화 번호입니다.");
            return false;
        }
        return true;
    }
}
