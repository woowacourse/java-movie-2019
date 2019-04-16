package domain;


import utils.DateTimeUtils;

public class ReservationMovie {
    private final int id;
    private final String name;
    private final int price;
    private final ReservationSchedule schedule;

    public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.schedule = schedule;
    }

    public boolean checkTime(PlaySchedule schedule) {
        return DateTimeUtils.isOneHourWithinRange(this.schedule.getStartDateTime(),
                schedule.getStartDateTime());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(schedule);
        return id + " - " + name + ", " + price + "원" + "\n"
                + sb.toString();
    }
}
