/*
 * 선택한 영화의 정보를 나타내는 객체
 */

package domain;

public class SelectedMovie {
	private Movie movie;

	public SelectedMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public int getSelectedMovieId() {
		return movie.getId();
	}
}
