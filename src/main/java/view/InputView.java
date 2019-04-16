package view;

import utils.StringLiterals;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getUserInput(String statement, String errorMessage) {
        try {
            System.out.println(statement);
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println(errorMessage);
            scanner.nextLine();
            return getUserInput(statement, errorMessage);
        }
    }
}
