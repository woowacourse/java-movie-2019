/*
 *  @(#)MovieApplication.java       1.00    2019/04/16
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static final int ZERO = 0;
    public static final int TRUE = 1;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        User user = new User();
        Reservation reservation;
        int isContinue;

        do {
            OutputView.printMovies(movies);                     // 영화목록 출력
            int movieId = movieIdInit();                        // 영화 id 입력
            OutputView.printMovieById(movieId);                 // 해당 schedule 출력

            int scheduledNumber = scheduleNumberInit(movieId);  // 그 영화에서 몇번째인지 입력
            int numberOfPeople = InputView.inputNumberOfPeople();       // 인원 수 입력

            reservation = new Reservation(movieId, scheduledNumber, numberOfPeople);        // 예약 객체 생성
            user.addReservation(reservation);                                               // 사용자 객채의 list에 예약 추가
            MovieRepository.getMovieById(movieId).getPlaySchedule(scheduledNumber).subCapacity(numberOfPeople);         // 해당 영화의 시간표에서 가능인원 빼줌

            isContinue = InputView.inputContinue();                         // 결제할지 추가예약할지 입력
        }
        while (isContinue != TRUE);

        OutputView.printUserReservationList(user.getReservationList());             // 예약목록 출력
        int point = InputView.inputPoint();                                         // 사용자의 포인트 입력
        boolean isCard = InputView.inputCardOrNot();                                // 카드인지 현금인지 입력
        user.setPoint(point);                                                       // 사용자 point setting
        OutputView.printPayment(user);                                              // 사용자 결제 금액 출력
    }

    /* move Id 입력받는 함수 실행 및 확인해서 반환 */
    public static int movieIdInit() {
        int movieId;
        do {
            movieId = InputView.inputMovieId();
        }
        while (!MovieRepository.isContains(movieId));
        return movieId;
    }

    public static int scheduleNumberInit(int movieId) {
        int scheduledNumber;
        Movie movie = MovieRepository.getMovieById(movieId);
        do {
            scheduledNumber = InputView.inputMovieSchedule();
        }
        while (scheduledNumber > movie.getScheduleSize()
                || MovieRepository.getMovieById(movieId).getPlaySchedule(scheduledNumber).getCapacity() == ZERO);
        return scheduledNumber;
    }

}
