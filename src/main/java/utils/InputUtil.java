package utils;

import java.util.Scanner;

public class InputUtil {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static int getInt() {
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            System.out.println("숫자 입력하세요");
            return getInt();
        }
    }

    private static String getString() {
        return SCANNER.nextLine();
    }
}
