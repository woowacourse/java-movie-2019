package domain;

import view.InputView;

public class SelectedMovie {
    private Movie movie;
    private int selectedPlayScheduleId;
    private int audience;

    public SelectedMovie(Movie movie) {
        this.movie = movie;
    }

    public void getData() {
        selectedPlayScheduleId = InputView.inputPlaySchedule() - 1;
        audience = InputView.inputAudienceNumber();
    }

    public boolean isValidPlaySchedule() {
        return movie.isValidPlaySchedule(selectedPlayScheduleId, audience);
    }

    public void showPlaySchedule() {
        movie.showPlayScheduleList();
    }

    public int showPrice() {
        return movie.showPrice(audience);
    }

    public void showSelectedMovieSchecule() {
        System.out.println("예약내역");
        System.out.println(movie.showMovieDetail());
        System.out.print(movie.showSelectedPlaySchedule(selectedPlayScheduleId));
        System.out.println("예약인원:" + audience + "명");
    }
}
