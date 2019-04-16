package service;

import domain.Booking;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieBookingService {

    public void bookMovie(List<Booking> bookings) {
        if (!checkBookableTogether(bookings)) {
            throw new IllegalArgumentException("Specified bookings cannot be booked together");
        }

        // checkBookableTogether 를 통과하면 인자의 예매 리스트가 함께 예매 가능함이 보장됨
        for (Booking b : bookings) {
            b.schedule.book(b.numOfPeople);
        }
    }

    public List<Movie> retrieveAllMovies() {
        return MovieRepository.getMovies();
    }

    /**
     * 단일 예매가 가능한 상태인지 확인(인원 초과, 시작 시간 초과 여부만 확인)
     * @param b 확인할 예매 정보
     * @return 인자로 명시된 단일 예매 정보로 예매가 가능한 경우 true, 아니면 false
     */
    public boolean checkBookable(Booking b) {
        return b.schedule.isBookableNow() && b.schedule.isCapable(b.numOfPeople);
    }

    public boolean checkBookableTogether(List<Booking> bookings) {
        boolean bookable = true;
        Iterator<Booking> bit = bookings.iterator();
        while (bookable && bit.hasNext()) {
            Booking b = bit.next();
            bookable = isBookableWithOthers(bookings, b)
                && b.schedule.isBookableNow()
                && b.schedule.isCapable(b.numOfPeople);
        }
        return bookable;
    }

    private boolean isBookableWithOthers(List<Booking> bookings, Booking b) {
        List<PlaySchedule> schedules = new ArrayList<>();

        for (Booking booking : bookings) {
            schedules.add(booking.schedule);
        }
        return isBookableWithOthers(schedules, b.schedule);
    }


    public int getTotalPrice(List<Booking> bookings) {
        int totalPrice = 0;
        for (Booking b : bookings) {
            totalPrice += b.movie.getTotalPrice(b.numOfPeople);
        }

        return totalPrice;
    }


    /**
     * 인자로 명시된 booking 객체들이 함께 예매 가능한 지 확인한다.
     * 시간 차이만 확인하며, 인원 초과, 시작 시간이 지났는지 여부는 검사하지 않는다.
     *
     * @param schedules 예매할 스케줄을 담은 Booking 객체 리스트
     * @return 리스트의 전체 객체가 함께 예매 가능한 경우 true, 아니면 false
     */
    public boolean checkSchedulesBookableTogether(List<PlaySchedule> schedules) {
        for (PlaySchedule b : schedules) {
            if (!isBookableWithOthers(schedules, b)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBookableWithOthers(List<PlaySchedule> schedules, PlaySchedule p) {
        for (PlaySchedule schedule : schedules) {
            if (!p.isBookableWith(schedule)) {
                return false;
            }
        }
        return true;
    }
}
