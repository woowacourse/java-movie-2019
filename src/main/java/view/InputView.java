/*
 * InputView Class
 *
 * @version 1.1
 *
 * @date 2019-04-16
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package view;

import domain.Movie;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTime(){
        System.out.println("## 예약할 시간표를 선택하세요. (첫번쨰 상영 시간이 1번)");
        return scanner.nextInt()- Movie.PLAYSCHECULE_START_INDEX;
    }

}
