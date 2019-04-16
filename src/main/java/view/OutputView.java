package view;

import domain.*;

import java.util.List;

public class OutputView {

    public static void printMovies() {
        List<Movie> movies = MovieRepository.getMovies();

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie){

        System.out.println(movie);
    }

    public static void printReservateInfo(ReservateInformation reservateInformation){
        Movie reservedMovie = reservateInformation.getMovie();
        PlaySchedule playSchedule = reservateInformation.getPlaySchedule();
        ReservePeople reservePeople = reservateInformation.getReservePeople();

        System.out.println("예약내역");
        System.out.print(reservedMovie.getMovieNameAndPrize());
        System.out.print(playSchedule.toString());
        System.out.println("예약인원 : "+ reservePeople.getReservePeople()+"명");
    };

    public static void pirntResult(CardOrCash cardOrCash,Point point, ReservateInformation reservateInformation){

        int result = cardOrCash.getResult(point,reservateInformation);
        System.out.println("최종결제한 금액은 "+result+"원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 관람되세요.");
    }

}
