package utils;

public class NaturalNumber {
	private int number;

	public NaturalNumber(int number) {
		if (number < 1) {
			throw new IllegalArgumentException("1이상의 수만 입력 가능합니다.");
		}

		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public int toArrayIndex() {
		return this.number - 1;
	}
}
