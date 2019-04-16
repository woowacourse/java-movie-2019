package domain;

import org.junit.Test;
import utils.DateTimeUtils;

public class PlayScheduleTest {

    @Test(expected = IllegalArgumentException.class)
    public void 영화_시간_지났을_경우() {
        PlaySchedule playSchedule = new PlaySchedule(DateTimeUtils.createDateTime("2019-04-16 11:23"), 3);
        playSchedule.isValidSchedule(DateTimeUtils.createDateTime("2019-04-16 12:23"));
    }
}