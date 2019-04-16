import domain.UserMovie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<UserMovie> userMoviesList = new ArrayList<>();

    public static List<UserMovie> getUserList(){
        return userMoviesList;
    }
}
