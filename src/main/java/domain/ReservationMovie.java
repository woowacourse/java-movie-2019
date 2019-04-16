package domain;


import utils.DateTimeUtils;

public class ReservationMovie extends Movie{
    private final ReservationSchedule schedule;

    public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
        super(id,name,price);
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
        return super.getId() + " - " + super.getName() + ", " + super.getPrice() + "원" + "\n"
                + sb.toString();
    }
}
