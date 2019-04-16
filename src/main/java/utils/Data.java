package utils;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static int getMovieId(int number) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(7);
        numbers.add(8);
        return numbers.indexOf(number);
    }
}
