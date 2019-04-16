package domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class PlayScheduleTest {

    @Test
    public void testIsCapable() {
        PlaySchedule p = makePlaySchedule();

        Assert.assertTrue(p.isCapable(3));
        Assert.assertFalse(p.isCapable(4));
    }

    @Test
    public void testIsBookableNow() {
        PlaySchedule p = makePlaySchedule();

        Assert.assertTrue(p.isBookableNow());
    }

    private PlaySchedule makePlaySchedule() {
        LocalDateTime now = LocalDateTime.now();
        PlaySchedule p = new PlaySchedule(now.plusMinutes(10), 3);
        return p;
    }
}
