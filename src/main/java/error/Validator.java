package error;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;

import java.util.List;

public class Validator {

//    public static void checkDuplication(List<Integer> winLottoNumbers) throws Exception {
//        if (winLottoNumbers.stream().distinct().count() != winLottoNumbers.size()) {
//            throw new DuplicationExistException();
//        }
//    }
//
//    public static void checkDuplication(Lotto lotto, int bonusNumber) throws Exception {
//        boolean isDuplicationExist = lotto.isContain(bonusNumber);
//        if (isDuplicationExist) {
//            throw new DuplicationExistException();
//        }
//    }

//    public static void checkLottoNumberCount(List<String> numbers) throws Exception {
//        if (numbers.size() != GameSettingData.LOTTO_NUMBER_COUNT) {
//            throw new NotCorrectLottoNumberCountException();
//        }
//    }
//
//    public static void checkIsInteger(String number) throws Exception {
//        try {
//            Integer.parseInt(number);
//        } catch (Exception e) {
//            throw new NotIntegerException();
//        }
//    }
//
//    public static void checkIsInteger(List<String> numbers) throws Exception {
//        boolean notValid = numbers.stream().anyMatch(s -> !isInteger(s));
//        if (notValid) {
//            throw new NotIntegerException();
//        }
//    }
//
//    public static void checkisInRange(boolean flag) throws Exception {
//        if (flag){
//            throw new NotInRangeException();
//        }
//    }
//
//    public static void checkisInRange(List<Integer> numbers) throws Exception {
//        boolean notValid = numbers.stream().anyMatch(i -> !isInRange(i));//stream class anymatch 는 최소한 한개의 요소가 Predicate 조건 만족하는지 조사
//        if (notValid) {
//            throw new NotInRangeException();
//        }
//    }

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);//parseint는 문자열을 int 형으로 변환해줌
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public static boolean isInRange(int number) {
//        if ((number < GameSettingData.LOTTO_MIN_NUMBER) || (number > GameSettingData.LOTTO_MAX_NUMBER)) {
//            return false;
//        }
//        return true;
//    }
}