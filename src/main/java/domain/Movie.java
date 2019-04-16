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
    
    public boolean isTheMovie(int id) {
    	return this.id == id;
    }
    
    public void isValidSchedule(int select) {
    	int sizeOfSchedule = playSchedules.size();
    	if(select > sizeOfSchedule && select <= 0)
    		throw new IllegalArgumentException("선택한 영화 상영 스케쥴이 없습니다. \n다시 입력해주세요.");
    	if(playSchedules.get(select-1).getCapacity() == 0)
    		throw new IllegalArgumentException("선택한 영화 상영 스케쥴은 매진되었습니다. \n다시 입력해주세요.");
    }
    
    public int getId() {
    	return id;
    }
    
    public PlaySchedule getSchedule(int index) {
    	return playSchedules.get(index-1);
    }
    
    public String getFirstLine() {
    	return id + " - " + name + ", " + price + "원" + NEW_LINE;
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
