package view;

import domain.MovieRepository;
import domain.Movie;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            int id = Integer.parseInt(scanner.nextLine());
            return isValidMovieId(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 올바른 영화 번호를 입력해주세요.");
            return inputMovieId();
        }
    }

    private static int isValidMovieId(int id) {
        if (MovieRepository.getMovieMap().containsKey(id)) {
            return id;
        }
        throw new IllegalArgumentException();
    }

    public static int inputSchedule(Movie selecetedMovie){
        try {
            System.out.println("## 예약할 시간표를 선택하세요.(첫 번째 상영 시간이 1번)");
            int schedule = Integer.parseInt(scanner.nextLine());
            return isValidScheduleNumber(schedule, selecetedMovie);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 올바른 숫자를 입력해주세요");
            return inputMovieId();
        }
    }


    private static int isValidScheduleNumber(int number, Movie movie) {
        if(number >  movie.getScheduleSize()){
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static int inputNumberOfPeople(Movie selecetedMovie, int time){
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            int count = Integer.parseInt(scanner.nextLine());
            return isValidNumberOfPeople(count, selecetedMovie, time);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 올바른 숫자를 입력해주세요");
            return inputMovieId();
        }
    }

    private static int isValidNumberOfPeople(int number, Movie movie, int time) {
        if(number > movie.getPlaySchedules().get(time).getCapacity()){
            throw new IllegalArgumentException();
        }
        return number;
    }

}

