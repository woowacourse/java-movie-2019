package domain;

import view.InputView;

public class MovieTicket {
	private static final String UNKNOWN_MOVIE_ID_MESSAGE = "상영 목록에 없는 영화입니다.";
	private static final String UNKNOWN_SCHEDULE_MESSAGE = "상영 목록에 없는 시간표입니다.";
	private static final String INCAPABLE_AUDIENCE_MESSAGE = "예약 가능 인원을 초과했습니다.";
	private static final String AFTER_SCREENING_MESSAGE = "상영 시작 시간이 지난 영화입니다.";

	private Movie movie;
	private int numOfAudience;

	public MovieTicket() {
		int movieId = getMovieId();
		int schedule = getSchedule(movieId);
		int numOfAudience = getNumOfAudience(movieId, schedule);
	}

	private int getMovieId() {
		int movieId = InputView.inputMovieId();
		if (!MovieRepository.containsMovieId(movieId)) {
			System.out.println(UNKNOWN_MOVIE_ID_MESSAGE);
			return getMovieId();
		}

		return movieId;
	}

	private int getSchedule(int movieId) {
		int schedule = InputView.inputSchedule();
		if (!MovieRepository.bookableSchedule(movieId, schedule)) {
			System.out.println(UNKNOWN_SCHEDULE_MESSAGE);
			return getSchedule(movieId);
		}
		if (!MovieRepository.isBeforeBegging(movieId, schedule)) {
			System.out.println(AFTER_SCREENING_MESSAGE);
			return getSchedule(movieId);
		}
		return schedule;
	}

	private int getNumOfAudience(int movieId, int schedule) {
		int numOfAudience = InputView.inputNumOfAudience();
		if (!MovieRepository.capable(movieId, schedule, numOfAudience)) {
			System.out.println(INCAPABLE_AUDIENCE_MESSAGE);
			return getNumOfAudience(movieId, schedule);
		}

		return numOfAudience;

	}
}
