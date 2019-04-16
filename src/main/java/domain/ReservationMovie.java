package domain;


import utils.DateTimeUtils;

public class ReservationMovie {
    private final int id;
    private final String name;
    private final int price;
    private final PlaySchedule schedule;

    ReservationMovie(int id, String name, int price, PlaySchedule schedule) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.schedule = schedule;
    }

    public boolean checkTime(PlaySchedule schedule) {
        return DateTimeUtils.isOneHourWithinRange(this.schedule.getStartDateTime(),
                schedule.getStartDateTime());
    }
}
