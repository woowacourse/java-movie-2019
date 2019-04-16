package domain;

public class MovieReservationHistory {
	private Movie movie;
	private PlaySchedule playschedule;
	private int reservedPersonnel;

	public MovieReservationHistory(Movie movie, PlaySchedule playSchedule, int reservedPersonnel) {
		this.movie = movie;
		this.playschedule = playSchedule;
		this.reservedPersonnel = reservedPersonnel;
	}

	@Override
    public String toString() {
    	
        return "예약 내역\n"
        		+ movie.toString().split("\\n")[0] + "\n"
        		+ playschedule.toString().substring(0, 22)
        		+ "\n예약 인원: " + reservedPersonnel + "명";  		
    }
	
	/* 테스트 코드 */
	public static void main(String[] args) {
		Movie movie = MovieRepository.getMovie(1);
		MovieReservationHistory a = new MovieReservationHistory(movie, movie.getPlaySchedule(2), 2);
		System.out.println(a);
	}
}
