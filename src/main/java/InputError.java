import domain.Movie;

import java.util.List;

public class InputError {
    private String NUMBER_FORMAT_ERROR = "숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.";
    private String MINUS_ERROR = "양이 아닌 정수가 입력되었습니다.  다시 입력해주세요.";
    private String REST_ERROR = "나머지가 생겼습니다. 다시 입력해주세요.";
    private String NUMBER_RANGE_ERROR = "없는 영화입니다. 다시 입력해주세요.";
    private String DUPLICATE_ERROR = "번호가 중복되었습니다. 다시 입력해주세요.";
    private String LENGTH_ERROR = "길이가 잘 못 되었습니다. 다시 입력해주세요.";

    public boolean checkContainId(List<Movie> movies, int movieId){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getId() == movieId){
                return true;
            }
        }
        System.out.println(NUMBER_RANGE_ERROR);
        return false;
    }


    public boolean CheckFormatError(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            System.out.println(NUMBER_FORMAT_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckMinusError(int input){
        if(input < 0) {
            System.out.println(MINUS_ERROR);
            return false;
        }
        return true;
    }

    public boolean checkRangeNumber(int number){
        if(number<1 || number>45){
            System.out.println(NUMBER_RANGE_ERROR);
            return false;
        }
        return true;
    }

    public boolean checkDuplicateNumber(int number, int[] checkNumbers){
        if(checkNumbers[number] != 0){
            System.out.println(DUPLICATE_ERROR);
            return false;
        }
        return true;
    }

    public boolean checkDuplicateNumberAll(int number, int[] checkNumbers){
        int[] numberArr = numberToArr(number);
        for(int i=0; i<numberArr.length; i++){
            if(checkNumbers[numberArr[i]] != 0){
                System.out.println(DUPLICATE_ERROR);
                return false;
            }
        }
        return true;
    }

    public boolean CheckRestError(int number){
        if(number % 1000 != 0){
            System.out.println(REST_ERROR);
            return false;
        }
        return true;
    }

    public int[] numberToArr(int number){
        int[] ret = new int[3];
        for(int i=2; i>=0; i--){
            ret[i] = number % 10;
            number /= 10;
        }
        return ret;
    }
}
