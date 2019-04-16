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

    public boolean equalMovieId(Integer movieId) { return id == movieId; }

    public boolean checkCapacity(Integer movieTime, Integer movieTicket) {
        return playSchedules.get(movieTime-1).overCapacity(movieTicket); // 0부터 인덱스 시작
    }

    public PlaySchedule getPlaySchedule(Integer movieTime) {
        return playSchedules.get(movieTime-1); // 0부터 인덱스 시작
    }

    public void printMovieInfo(Reservation reservation) {
        System.out.printf("%d - %s, %d원\n", id, name, price);
        playSchedules.get(reservation.getMovieTime()-1).printTime();
    }

    public int getTicketPrice(Integer movieTicket) {
        return price * movieTicket;
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
}
