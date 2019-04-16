package view;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static boolean validateUserInput(int userInput) {
        List<Integer> possibleInput = Arrays.asList(1, 2);
        return possibleInput.contains(userInput);
    }
}
