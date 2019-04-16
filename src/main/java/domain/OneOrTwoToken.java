package domain;

public class OneOrTwoToken {

    private final int number;

    public OneOrTwoToken(int number) {
        checkIfValidNumber(number);
        this.number = number;
    }

    private void checkIfValidNumber(int number) {
        if (!(number == 1 || number == 2)) {
            throw new IllegalArgumentException("올바른 1, 2를 입력해주세요");
        }
    }

    public boolean isOne() {
        return (number == 1);
    }

    public boolean isTwo() {
        return (number == 2);
    }
}
