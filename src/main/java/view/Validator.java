package view;

public class Validator {
    private static final String NUMBER_REGEX = "[0-9]+";

    public static boolean isNaturalNumber(String value) {
        return (value.length() != 0) && value.matches(NUMBER_REGEX);
    }

}
