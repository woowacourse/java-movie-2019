package utils;

import java.io.IOException;

public class PrintUtils {
    public static void printErrorMessageWithPause(Exception e) {
        System.out.print(e.getMessage());
        pause();
    }

    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
