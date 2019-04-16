package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MovieRepositoryTest {
    @Test
    public void 일번영화번호확인() {
        //given
        int movieId = 1;

        //when
        Movie selectedMovies = MovieRepository.getSelectedMovie(movieId);

        //then
        assertThat(selectedMovies.isSelectedMovie(movieId)).isTrue();
    }

    @Test
    public void 틀린영화번호확인() {
        //given
        int movieId = 1;
        int falseMovieId = 2;
        //when
        Movie selectedMovies = MovieRepository.getSelectedMovie(movieId);

        //then
        assertThat(selectedMovies.isSelectedMovie(falseMovieId)).isFalse();
    }
}