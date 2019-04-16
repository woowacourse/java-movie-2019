package view;

import domain.MovieRepository;

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
        if (MovieRepository.getIdList().contains(id)) {
            return id;
        }
        throw new IllegalArgumentException();
    }
/*
    public static int inputSchedule(){
        try {
            System.out.println("## 예약할 시간표를 선택하세요.(첫 번째 상영 시간이 1번");
            int schedule = Integer.parseInt(scanner.nextLine());
            return isValidScheduleNumber(schedule);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 올바른 시간표 번호를 입력해주세요.");
            return inputMovieId();
        }
    }


    private static int isValidScheduleNumber(int number) {
        if(number < )
    }
    */
}

