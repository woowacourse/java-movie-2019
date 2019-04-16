package domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Movie> result;


    public Result() {
        this.result= new ArrayList<>();
    }

    public void add(Movie movie) {
        result.add(movie);
    }
}
