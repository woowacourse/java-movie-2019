package Program;

import Program.Config.Validation;
import domain.BookMovie;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;

import java.util.List;

public class BookSystem {
    private BookMovie bookMovie;
    private List<PlaySchedule> selectedScheduleList;

    public BookSystem(BookMovie bookMovie) {
        this.bookMovie = new BookMovie();
    }

    public BookMovie booking(int movieId) {
        try {
            Validation.checkMovieId(movieId);
            for (int i = 0; i < MovieRepository.getMovies().size(); i++) {
                Movie willBookMovie = MovieRepository.getMovies().get(i);
                bookMovie = setBookMovie(willBookMovie, movieId);
            }
        } catch (Exception e) {
            booking(InputView.inputMovieId());
        }
        return bookMovie;
    }

    public void selectPeopleBooking(int peopleNumber) {
        try {
            int availableNumber = selectedScheduleList.get(0).getCapacity();
            Validation.checkBookingPeopleNumber(availableNumber, peopleNumber);
            bookMovie.setBookingPeople(peopleNumber);
        } catch (Exception e) {
            System.out.println("인원 수 오류");
            selectPeopleBooking(InputView.inputPeopleBooking());
        }
    }

    public void selectSchedule(int order, int scheduleNumber) {
        try {
            Validation.checkScheduleSize(order, scheduleNumber);
            selectedScheduleList = bookMovie.getBookMovieList().get(order).getPlaySchedules();
            PlaySchedule selectedSchedule = selectedScheduleList.get(scheduleNumber - 1);
            bookMovie.getBookMovieList().get(order).getPlaySchedules().clear();
            bookMovie.getBookMovieList().get(order).getPlaySchedules().add(selectedSchedule);
        } catch (Exception e) {
            System.out.println("예약 불가능한 스케쥴을 입력하셨습니다.");
            selectSchedule(order, InputView.inputMovieSchedule());
        }
    }

    private BookMovie setBookMovie(Movie willBookMovie, int movieId) {
        if (willBookMovie.getId() == movieId) {
            bookMovie.addBookMovieList(willBookMovie);
        }
        return bookMovie;
    }

}
