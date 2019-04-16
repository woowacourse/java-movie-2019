package domain;

public enum ReservationCommand {
    RESTART(2), STOP(1), NOT_EXIST(-1);

    private int num;

    ReservationCommand(int num) {
        this.num = num;
    }

    public static ReservationCommand valueOf(int num) {
        for (ReservationCommand r : values()) {
            if (r.num == num) {
                return r;
            }
        }
        return NOT_EXIST;
    }
}
