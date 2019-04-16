package domain;

public class ReservedMovie extends Movie {

    public ReservedMovie(int id, String name, int price, int movieSchedule,
                         int headcount) {
        super(id, name, price);
        if (!MovieRepository.isOpenedMovie(id)) {
            throw new IllegalArgumentException("상영 중인 영화가 아닙니다.");
        }
        if (!MovieRepository.isPlayingSchedule(id, movieSchedule)) {
            throw new IllegalArgumentException("상영 시간이 아닙니다.");
        }
        if (!MovieRepository.checkRemainingSeat(id, movieSchedule, headcount)) {
            throw new IllegalArgumentException("잔여 좌석이 없습니다.");
        }
    }
}
