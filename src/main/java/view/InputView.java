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

    public static int inputSchedule(Movie selecetedMovie) {
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
        if (number > movie.getScheduleSize() || number < 1) {
            System.out.println("시간표에 있는 시간을 선택해 주세요");
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static int inputNumberOfPeople(Movie selecetedMovie, int time) {
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            int count = Integer.parseInt(scanner.nextLine());
            return isValidNumberOfPeople(count, selecetedMovie, time);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 올바른 숫자를 입력해주세요");
            return inputNumberOfPeople(selecetedMovie, time);
        }
    }

    private static int isValidNumberOfPeople(int number, Movie movie, int time) {
        if (number > movie.getPlaySchedules().get(time).getCapacity()
                || number < 1) {
            System.out.println("예매 가능한 인원을 초과했습니다");
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static int inputEndOrRestart() {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가예약을 진행하려면 2번");
            int finish = Integer.parseInt(scanner.nextLine());
            return isValidEndOrRestart(finish);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 1 또는 2를 입력하세요");
            return inputEndOrRestart();
        }
    }

    private static int isValidEndOrRestart(int number) {
        if (number < 0 || number > 1) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static int inputPoint(){
        try {
            System.out.println("##포인트 사용금액을 입력하세요. 포인트가 없으면 0입력");
            int point = Integer.parseInt(scanner.nextLine());
            return isValidPoint(point);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 숫자를 입력하세요");
            return inputPoint();
        }
    }

    private static int isValidPoint(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }

}

