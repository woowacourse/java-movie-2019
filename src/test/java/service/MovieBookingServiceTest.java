package service;

import domain.Booking;
import domain.Movie;
import domain.PlaySchedule;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieBookingServiceTest {

    private MovieBookingService movieBookingService = new MovieBookingService();

    @Test
    public void testCheckSchedulesBookableTogether() {
        List<PlaySchedule> schedulesBookableTogether = makeSchedulesBookableTogether();
        List<PlaySchedule> schedulesUnbookableTogether = makeSchedulesUnbookableTogether();

        Assert.assertTrue(movieBookingService.checkSchedulesBookableTogether(schedulesBookableTogether));
        Assert.assertFalse(movieBookingService.checkSchedulesBookableTogether(schedulesUnbookableTogether));
    }

    @Test
    public void testCheckBookingsBookableTogether() {
        List<Booking> bookingsBookable = makeBookingsBookableTogether();
        List<Booking> bookingsUnbookable = makeBookingsUnbookableTogether();

        Assert.assertTrue(movieBookingService.checkBookableTogether(bookingsBookable));
        Assert.assertFalse(movieBookingService.checkBookableTogether(bookingsUnbookable));
    }

    private List<PlaySchedule> makeSchedulesBookableTogether() {
        List<PlaySchedule> schedules = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        schedules.add(new PlaySchedule(now, 3));
        schedules.add(new PlaySchedule(now.plusMinutes(30), 3));
        schedules.add(new PlaySchedule(now.plusMinutes(55), 3));

        return schedules;
    }

    private List<PlaySchedule> makeSchedulesUnbookableTogether() {
        List<PlaySchedule> schedules = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        schedules.add(new PlaySchedule(now, 3));
        schedules.add(new PlaySchedule(now.plusMinutes(30), 3));
        schedules.add(new PlaySchedule(now.plusMinutes(40), 3));
        schedules.add(new PlaySchedule(now.plusHours(1).plusMinutes(10), 3));

        return schedules;
    }

    private List<Booking> makeBookingsBookableTogether() {
        List<Booking> bookings = new ArrayList<>();
        Movie mv1 = new Movie(1, "abc", 2000);
        Movie mv2 = new Movie(2, "def", 3000);
        LocalDateTime now = LocalDateTime.now();
        PlaySchedule p1 = new PlaySchedule(now.plusMinutes(10), 2);
        PlaySchedule p2 = new PlaySchedule(now.plusMinutes(30), 3);
        mv1.addPlaySchedule(p1);
        mv2.addPlaySchedule(p2);
        bookings.add(new Booking(mv1, p1, 1));
        bookings.add(new Booking(mv2, p2, 1));
        return bookings;
    }

    private List<Booking> makeBookingsUnbookableTogether() {
        List<Booking> bookings = new ArrayList<>();
        Movie mv1 = new Movie(1, "abc", 2000);
        Movie mv2 = new Movie(2, "def", 3000);
        LocalDateTime now = LocalDateTime.now();
        PlaySchedule p1 = new PlaySchedule(now.plusMinutes(10), 2);
        PlaySchedule p2 = new PlaySchedule(now.plusMinutes(30), 3);
        mv1.addPlaySchedule(p1);
        mv2.addPlaySchedule(p2);
        bookings.add(new Booking(mv1, p1, 4));
        bookings.add(new Booking(mv2, p2, 1));
        return bookings;
    }
}
