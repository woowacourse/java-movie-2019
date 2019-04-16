import domain.Movie;
import view.OutputView;

import java.util.*;

import static domain.MovieRepository.getMovies;
import static view.InputView.inputMovieId;

public class MovieApplication {

    private final int FIRST_MOVIE = 1;
    private final int SECOND_MOVIE = 5;
    private final int THIRD_MOVIE = 7;
    private final int FOURTH_MOVIE = 8;

    public static void main(String[] args) {

        List<Movie> movies = getMovies();
        OutputView.printMovies(movies);
        MovieApplication movieCompany = new MovieApplication();
        movieCompany.getReservationTime(movieCompany.checkMovieId());
    }

    private List<Integer> getInMovieIdList(String[] movieIdString){

        List<Integer> movieIdList = new ArrayList<>();

        for (String s : movieIdString) {

            movieIdList.add(Integer.parseInt(s));
        }
        return movieIdList;
    }

    private List<Integer> printMovieList(String movieIdString){

        String[] movieIdStringArrays = movieIdString.split("");
        List<Integer> movieIdArrayList;
        movieIdArrayList = getInMovieIdList(movieIdStringArrays);

        for(int i=0; i<movieIdArrayList.size();i++) {

            getFirstMovie(movieIdArrayList, i);
            getSecondToFourthMovie(movieIdArrayList, i);
            getException(movieIdArrayList, i);
        }
        return movieIdArrayList;
    }

    private void getException(List<Integer> movieIdArrayList, int i) {

        if (movieIdArrayList.get(i) != FIRST_MOVIE &&
                movieIdArrayList.get(i) != SECOND_MOVIE &&
                movieIdArrayList.get(i) != THIRD_MOVIE &&
                movieIdArrayList.get(i) != FOURTH_MOVIE) {

            System.out.println("문자열 혹은 맞는 영화 번호를 입력하셨는지 확인하세요");
            throw new IllegalArgumentException();
        }
    }

    private void getSecondToFourthMovie(List<Integer> movieIdArrayList, int i) {

        if (movieIdArrayList.get(i) == SECOND_MOVIE || movieIdArrayList.get(i) == THIRD_MOVIE ||
                movieIdArrayList.get(i) == FOURTH_MOVIE) {

            int SetMovieNumber = 4;
            System.out.println(getMovies().get(movieIdArrayList.get(i) - SetMovieNumber));
        }
    }

    private void getFirstMovie(List<Integer> movieIdArrayList, int i) {

        if (movieIdArrayList.get(i) == FIRST_MOVIE) {

            System.out.println(getMovies().get(movieIdArrayList.get(i) - FIRST_MOVIE));
        }
    }

    private List<Integer> checkMovieId(){

        List<Integer> movieIdList;
        while(true){

            try{

                String movieIdValue = inputMovieId();
                movieIdList = printMovieList(movieIdValue);
                break;
            } catch(Exception e){

                System.out.println("다시 입력해주십시오.");
            }
        }

        return movieIdList;
    }

    private void getReservationTime(List<Integer> movieIdList) {

        System.out.println("예약할 시간표를 선택하세요");

        List<Integer> reservationTimeList;
        while (true) try {

            Scanner scanReservationTime = new Scanner(System.in);
            String getReservationTimeString = scanReservationTime.nextLine();
            reservationTimeList = invertReservationTimeStringToList(getReservationTimeString);
            checkSameSizeListReservationTimeAndMovieId(movieIdList, reservationTimeList);
            break;
        } catch (Exception e) {

            System.out.println("예약 시간으르 다시 입력해주십시오");
        }
    }

    private List<Integer> getInReservationList(String[] movieIdString){

        List<Integer> movieIdList = new ArrayList<>();

        for (String s : movieIdString) {

            movieIdList.add(Integer.parseInt(s));
        }
        return movieIdList;
    }

    private List<Integer> invertReservationTimeStringToList(String movieIdString) {

        String[] movieIdStringArrays = movieIdString.split("");
        List<Integer> movieIdArrayList;
        movieIdArrayList = getInReservationList(movieIdStringArrays);

        return movieIdArrayList;
    }

    private void checkSameSizeListReservationTimeAndMovieId(List<Integer> movieIdListSize, List<Integer> reservationTimeList){

        if(movieIdListSize.size() != reservationTimeList.size()){

            throw new IllegalArgumentException();
        }
    }

}
