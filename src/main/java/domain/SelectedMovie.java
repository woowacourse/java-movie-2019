package domain;

import view.InputView;

public class SelectedMovie {
    private Movie movie;
    private int playScheduleId;
    private int audience;

    public void initMovie(Movie movie){
        this.movie = movie;
    }

    public void getData(){
        playScheduleId = InputView.inputPlaySchedule();
        audience = InputView.inputAudienceNumber();
    }
    public boolean isValidPlaySchedule(){
        return movie.isValidPlaySchedule(playScheduleId, audience);
    }

    public void showPlaySchedule(){
        movie.showPlayScheduleList();
    }
}
