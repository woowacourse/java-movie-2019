package domain;

import java.util.ArrayList;
import java.util.List;

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

  public boolean IsCorrectNumberOfMovie(int movieId) {
    return this.id == movieId;
  }

  public boolean IsBookableSequence(int movieSequence) {
    return this.playSchedules.size()>=movieSequence
        && movieSequence>0;
  }

  public boolean IsBookableNumber(int movieSequence, int bookNum){
    return this.playSchedules.get(movieSequence-1).ExceedCapacity(bookNum);
  }

  public String getOneSchedule(int movieSchedule) {
    StringBuilder sb = new StringBuilder();
    sb.append(playSchedules.get(movieSchedule - 1));
    return sb.toString();
  }
}
