package input;

public enum Continue {
    YES("2"),
    NO("1");

    private String string;

    Continue(String string) {
        this.string = string;
    }

    public static Continue valueOfInput(String input) {
        if (checkValidity(input) ==  false) {
            throw new IllegalArgumentException();
        }
        if(input.equals(YES.string)) {
            return YES;
        }
        return NO;
    }

    private static boolean checkValidity(String input) {
        if (input.equals(YES.string) || input.equals(NO.string)) {
            return true;
        }
        return false;
    }
}
