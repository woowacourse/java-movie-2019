/*
 * InputView Class
 *
 * @version 1
 *
 * @date 2019-04-16
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

}
