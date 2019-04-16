package utils;

import java.util.regex.Pattern;

public class Validator {
	private static final String NUMBER_PATTERN = "^[0-9]*$";
	private static final String FLAG_PATTERN = "[12]";

	public static boolean isNaturalNumber(String value) {
		if (value == null || value.length() == 0 ||
			!Pattern.matches(NUMBER_PATTERN, value) ||
			Integer.parseInt(value.trim()) < 0) {
			printWrongInput();
			return false;
		}
		return true;
	}
	
	public static boolean isValidFlag(String value) {
		if(!isNaturalNumber(value) ||
			!Pattern.matches(FLAG_PATTERN, value)) {
			printWrongInput();
			return false;
		}
		return true;
	}
	
	public static void printWrongInput() {
		System.out.println("잘 못 입력했습니다.");
	}
}
