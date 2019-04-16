package domain;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final int numberOfPeople;

    public User(int id, int numberOfPeople) {
        this.id = id;
        this.numberOfPeople = numberOfPeople;
    }
    public int getId() {
        return id;
    }
    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}
