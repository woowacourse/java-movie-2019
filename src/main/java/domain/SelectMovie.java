package domain;

public class SelectMovie {
    private static final char NEW_LINE = '\n';

    private final Movie movie;
    private final int time;
    private final int peopleNum;

    public SelectMovie(Movie movie, int time, int peopleNum) {
        this.movie = movie;
        this.time = time;
        this.peopleNum = peopleNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(movie.getScheduleInfo(time));
        return movie.getId() + " - " + movie.getName() + ", " + movie.getPrice() + "원" + NEW_LINE
                + sb.toString();
    }
}
