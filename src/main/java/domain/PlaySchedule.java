package domain;

import Exceptions.PeopleException;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity; //TODO 예약 가능 인원 줄이기

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public void setCapacity(int people){
        if(!PeopleException.setCapacity(capacity, people)){
            OutputView.printPeopleException();
            setCapacity(InputView.inputMoviePeople());
        }
        if(PeopleException.setCapacity(capacity, people)){
            this.capacity = capacity - people;
        }
    } // TODO

    public int getCapacity(){
        return capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public String toStringData() {
        return "시작시간: " + format(startDateTime);
    }
}
