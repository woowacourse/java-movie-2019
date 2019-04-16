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
	public PlaySchedule getPlaySchedule() {
		return this.selectedPlaySchedule;
	}
	public int getNumOfPeople( ) {
		return this.numOfPeople;
	}
	
	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder(selectedMovie.getFirstLine());
        sb.append(selectedPlaySchedule);
        sb.append("예약인원 : "+numOfPeople+"명 \n");
        return  sb.toString();
	}

}
