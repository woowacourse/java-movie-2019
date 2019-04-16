package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMovie {
    Map<List<Movie>, Integer> bookMap = new HashMap<>();
    List<Movie> bookMovieList = new ArrayList<>();
    int bookingPeople;

    public BookMovie() {

    }

    public List<Movie> getBookMovieList() {
        return bookMovieList;
    }

    public int getBookingPeople() {
        return bookingPeople;
    }

    public Map<List<Movie>, Integer> getBookMap(){

        return bookMap;
    }

    public void addBookMovieList(Movie movie) {
        bookMovieList.add(movie);
    }

    public void setBookingPeople(int peopleNumber) {
        this.bookingPeople = peopleNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("예약 현황\n");
        for (Movie movie : bookMovieList) {
            stringBuilder.append(movie.getId() + "-");
            stringBuilder.append(" " + movie.getname() + "\n");
            stringBuilder.append("예약시간: " + movie.getPlaySchedules().get(0).getLocalDateTime() + "\n");
            stringBuilder.append(movie.getprice() + "원\n");
            stringBuilder.append("예약인원: " + bookingPeople + "명");
        }
        return stringBuilder.toString();
    }
}
