package domain;

public class SelectedMovie {
	private Movie selectedMovie;
	private int indexOfSelectedSchedule;
	private PlaySchedule selectedPlaySchedule;
	private int numOfPeople;

	public SelectedMovie(Movie selectedMovie, int indexOfSelectedSchedule, int numOfpeople) {
		this.selectedMovie = selectedMovie;
		this.indexOfSelectedSchedule = indexOfSelectedSchedule;
		this.selectedPlaySchedule = selectedMovie.getSchedule(indexOfSelectedSchedule);
		this.numOfPeople = numOfpeople;
	}
	public Movie getMovie() {
		return this.selectedMovie;
	}
	public int getIndexOfSelectedSchedule () {
		return this.indexOfSelectedSchedule;
	}
	public int getNumOfPeople( ) {
		return this.numOfPeople;
	}

}
