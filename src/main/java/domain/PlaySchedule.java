package domain;

import Exceptions.PeopleException;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public int setCapacity(int people) {
        int peoples = people;
        if (!PeopleException.setCapacity(capacity, people)) {
            OutputView.printPeopleException();
            setCapacity(InputView.inputMoviePeople());
        }
        if (PeopleException.setCapacity(capacity, people)) {
            this.capacity = capacity - people;
            return people;
        }
        return peoples;
    }

    public int getCapacity() {
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
