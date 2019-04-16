package domain;

import java.util.ArrayList;
import java.util.List;

public class ChoiceMovie {
    private int id;
    private String name;
    private int price;
    private int member;
    private PlaySchedule playSchedules;

    public ChoiceMovie(int id, String name, int price,int member,PlaySchedule playSchedule) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.member=member;
        this.playSchedules = playSchedule;
    }

   public PlaySchedule getPlaySchedules(){
        return playSchedules;
   }
}
