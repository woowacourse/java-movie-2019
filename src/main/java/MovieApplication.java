/*
 * @(#)MovieApplication.java
 *
 * v 0.0.0
 *
 * 2019.04.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

import domain.Movie;
import domain.MovieRepository;
import domain.PayInfo;
import domain.ReservationList;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * Movie 미션을 진행하는 main 로직이 들어있는 클래스
 *
 * @author kwonmc
 * @version 0.0.0
 */
public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        ReservationList reservationList = new ReservationList();

        // TODO 구현 진행
        int process;
        do {
            OutputView.printMovies(movies);
            Movie aMovie = InputView.inputMovieId();
            OutputView.printAMovie(aMovie);

            int movieTime = InputView.inputMovieTime(aMovie);
            int reserveCount = InputView.inputReserveCount(movieTime, aMovie);

            process = InputView.inputChooseProcess();
            reservationList.add(aMovie, reserveCount, movieTime);
            aMovie.modifyMovieSchedule(movieTime, reserveCount);
        } while (process == 2);

        OutputView.printReserveList(reservationList);

        OutputView.printProcessMessage();

        PayInfo payInfo = getPayInfo();
        OutputView.printPayResult(payInfo.getTotalPriceApplyPayInfo(reservationList));
    }

    private static PayInfo getPayInfo() {
        int pointAmount = InputView.inputPointAmount();
        int payType = InputView.inputPayType();

        return new PayInfo(pointAmount, payType);
    }
}
