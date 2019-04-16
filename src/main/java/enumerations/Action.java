package enumerations;

public enum Action {
    PAYMENT(1), RESERVATION(2);

    private int num;

    Action(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
