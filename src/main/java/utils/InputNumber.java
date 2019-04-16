package utils;

import java.util.Scanner;

public class InputNumber {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String NATURAL_NUMBER_ERROR_MESSAGE = "입력 오류 입니다. 숫자를 입력해주세요.";

    public static int getNaturalNumber(){
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println(NATURAL_NUMBER_ERROR_MESSAGE);
            return getNaturalNumber();
        }
    }
}
