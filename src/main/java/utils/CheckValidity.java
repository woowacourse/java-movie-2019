package utils;

public class CheckValidity {
    public boolean checkValidityIntegerFormat(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형태로 입력해주세요.");
            return false;
        }
        return true;
    }
}
