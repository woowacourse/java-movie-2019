package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public void validateSchedule() throws IllegalArgumentException {
        if (startDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("상영 시간이 지났습니다.");
        }
    }

    public void validateWatcher(int watcher) throws IllegalArgumentException {
        if (capacity < watcher) {
            throw new IllegalArgumentException("좌석이 부족합니다.");
        }
        if (watcher < 0) {
            throw new IllegalArgumentException("상영 인원은 1명 이상이어야 합니다.");
        }
    }

    public void decreaseCapacity(int watcher) {
        capacity -= watcher;
    }

    public boolean canReserve(PlaySchedule playSchedule) {
        if (DateTimeUtils.isOneHourWithinRange(this.startDateTime, playSchedule.startDateTime)) {
            return true;
        }
        return false;
    }
}
