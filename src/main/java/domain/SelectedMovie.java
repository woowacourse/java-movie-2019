package domain;

public class SelectedMovie {
	private Movie movie;
	private int selectedPlaySchedule;
	private int numOfPeople;
	
	public SelectedMovie(Movie movie, int selectedPlaySchedule, int numOfpeople) {
		this.movie = movie; 
		this.selectedPlaySchedule = selectedPlaySchedule;
		this.numOfPeople = numOfpeople;
	}

}
