package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public static String askUserWhatMovie() {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("##예약할 영화를 선택하세요:");
            isUserInputRight = checkUserInput(userInput);
        }
        return userInput;
    }

    public static String askAndReceiveInput(String sentence) {
        System.out.println(sentence);
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        return userInput;
    }

    public static boolean checkU
}
