package domain;

/**
 * 영화 예매를 담당하는 객체
 */
public class Reservation {
	Movie movie;
	PlaySchedule playSchedule;
	int capacity;

	public Reservation(Movie movie, PlaySchedule playSchedule, int neededCapacity) {
		if (!checkCapacity(playSchedule, neededCapacity)) {
			throw new IllegalArgumentException("자리가 없습니다.");
		}

		this.movie = movie;
		this.playSchedule = playSchedule;
		this.capacity = neededCapacity;
	}

	private boolean checkCapacity(PlaySchedule playSchedule, int neededCapacity) {
		return playSchedule.isCapacity(neededCapacity);
	}

	public int calTotalPrice() {
		return movie.calPrice(capacity);
	}

	public Movie getMovie() {
		return movie;
	}

	public PlaySchedule getPlaySchedule() {
		return playSchedule;
	}

	public int getCapacity() {
		return capacity;
	}
}
