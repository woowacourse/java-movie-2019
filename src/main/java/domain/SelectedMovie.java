package domain;

public class SelectedMovie {
	private Movie movie;
	private PlaySchedule selectedPlaySchedule;
	private int numOfPeople;
	
	public SelectedMovie(Movie movie, PlaySchedule selectedPlaySchedule, int numOfpeople) {
		this.movie = movie; 
		this.selectedPlaySchedule = selectedPlaySchedule;
		this.numOfPeople = numOfpeople;
	}

}
