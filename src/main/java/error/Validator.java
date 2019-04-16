package error;

import error.customExceptions.NotIntegerException;

public class Validator {

    public static void checkAccuracyOfMovieId(String id) {
        if (!isInteger(id)) {
            throw new NotIntegerException();
        }
    }

    private static boolean isInteger(String id) {
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
