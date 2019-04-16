package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public int getId() {
        return id;
    }

    public int getMovieTimeSize() {
        return playSchedules.size();
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity(int time) {
        return playSchedules.get(time).getCapacity();
    }

    public void setCapacity(int time,int capacity) {
        playSchedules.get(time).setCapacity(capacity);
    }

    public String numberMovie(int reservationMoviewTime, int reservationMovieCapacity) {
        StringBuilder sb = new StringBuilder();
        sb.append( id + " - " + name + ", " + price + "원"+"\n");
        sb.append(playSchedules.get(reservationMoviewTime).getDateTime()+"\n");
        sb.append("예약인원: "+reservationMovieCapacity+"명" + "\n");
        return sb.toString();
    }
}
