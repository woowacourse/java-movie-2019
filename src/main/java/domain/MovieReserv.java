package domain;

import java.util.ArrayList;
import java.util.List;

public class MovieReserv {
    private static final char NEW_LINE = '\n';

    private final Movie movie;

    private PlaySchedule playSchedules;

    public MovieReserv(Movie movie, PlaySchedule playSchedule) {
        this.movie = movie;
        this.playSchedules = playSchedule;
    }
}
