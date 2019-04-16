package domain;

import view.InputView;

public class SelectedMovie {
    private Movie movie;
    private int selectedPlayScheduleId;
    private PlaySchedule playSchedule;
    private int audience;

    public SelectedMovie(Movie movie) {
        this.movie = movie;
    }

    public PlaySchedule getPlaySchedule() {
        return playSchedule;
    }

    public boolean updateAudienceCount(){
        return movie.updateAudienceCount(selectedPlayScheduleId, audience);
    }

    public void getData() {
        selectedPlayScheduleId = InputView.inputPlaySchedule() - 1;
        setPlaySchedule();
        audience = InputView.inputAudienceNumber();
    }

    public void setPlaySchedule(){
        playSchedule = movie.getPlaySchedule(selectedPlayScheduleId);
    }

    public boolean comparePlayScheduleTime(SelectedMovie other){
        System.out.println(playSchedule);
        System.out.println(other.playSchedule);
        return playSchedule.compare(other.getPlaySchedule());
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
