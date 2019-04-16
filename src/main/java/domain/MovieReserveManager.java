package domain;

import java.time.LocalDateTime;

import view.InputView;

public class MovieReserveManager {
	private int inputValidatedMovieId() {
		int inputMovieId = new InputView().inputMovieId();
		if (!MovieRepository.getMovieIds().contains(inputMovieId))
			return inputValidatedMovieId();
		return inputMovieId;
	}

	private int inputValidatedMovieTime(Movie movie) {
		int inputMovieTime = new InputView().inputMovieTime();
		if (inputMovieTime > movie.getMovieCounts()) {
			System.out.println("존재하지 않는 시간입니다.");
			return inputValidatedMovieTime(movie);
		}
		if (!validateMovieTimePassed(movie, inputMovieTime)) {
			System.out.println("상영 시간이 지난 영화입니다.");
			return inputValidatedMovieTime(movie);
		}
		return inputMovieTime;
	}

	private boolean validateMovieTimePassed(Movie movie, int movieTime) {
		LocalDateTime nowDateTime = LocalDateTime.now();
		PlaySchedule playSchedule = movie.getPlaySchedule(movieTime);
		LocalDateTime startDateTime = playSchedule.getStartDateTime();
		if (nowDateTime.isAfter(startDateTime))
			return false;
		return true;
	}

	private int inputValidatedPeopleNumber(Movie movie, int movieTime) {
		int peopleNumber = new InputView().inputMoviePeepleNumber();
		PlaySchedule playSchedule = movie.getPlaySchedule(movieTime);
		if (playSchedule.getCapacity() < peopleNumber) {
			System.out.println("예약 가능 인원을 초과했습니다.");
			return inputValidatedPeopleNumber(movie, movieTime);
		}
		return peopleNumber;
	}
}
