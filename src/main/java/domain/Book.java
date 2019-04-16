package domain;

public class Book {

  private Movie bookMovie;
  private int movieSequence;
  private int bookNum;

  private Movie FindMovie(int movieId) {
    for (Movie movie : MovieRepository.getMovies()) {
      if (movie.IsCorrectNumberOfMovie(movieId)) {
        return movie;
      }
    }
    return null;
  }

  public Book(int movieId, int movieSequence, int bookNum) {
    this.bookMovie = FindMovie(movieId);
    this.movieSequence = movieSequence;
    this.bookNum = bookNum;
  }

  public String ViewBooking() {
    String movieSchedule = this.bookMovie.getOneSchedule(movieSequence);
    return bookMovie.getMovieInfo()+ movieSchedule + "예약인원 : " + this.bookNum + "명";
  }
}
