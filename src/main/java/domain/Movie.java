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

    public boolean isEqualMovie(int movieId) {
        return this.id == movieId;
    }

    /**
     * 입력한 시간표 숫자가 적절한 숫자인지 확인한다.
     */
    public boolean isValidMovieTime(int movieTime) {
        return playSchedules.size() >= movieTime;
    }

    /**
     * 선택한 시간에 예약가능인원이 존재하는지 확인한다.
     */
    public boolean isThisTimeAvailable(int movieTime) {
        final int MIN_NUM_OF_GUEST = 1;
        return playSchedules.get(--movieTime).isThisTimeAvailable(MIN_NUM_OF_GUEST);
    }

    public boolean isThisNumberAvailable(int movieTime, int numOfGuest) {
        return playSchedules.get(--movieTime).isThisTimeAvailable(numOfGuest);
    }

    public int getPrice(int numOfGuest) {
        return price * numOfGuest;
    }

    public void printMovieInfo() {
        System.out.println(id + " - " + name + ", " + price + "원");
    }

    public void printStartDateTime(int movieTime) {
        System.out.print(playSchedules.get(--movieTime).startDateTime());
    }

    public void modifyCapacity(int movieTime, int numOfGuest) {
        playSchedules.get(--movieTime).modifyCapacity(numOfGuest);
    }
}