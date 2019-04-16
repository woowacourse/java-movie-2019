package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieRepositoryTest {
    @Test
    public void 선택한_Id로_영화_조회() {
        MovieRepository movieRepository = new MovieRepository();
        int selectMovieId = 7;
        Movie selectMovie = MovieRepository.getSelectMovie(selectMovieId);
        assertThat(selectMovie.getName()).isEqualTo("파이브피트");
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void 선택한_Id로_영화_조회_없는영화_익셉션() {
        MovieRepository movieRepository = new MovieRepository();
        int selectMovieId = 2;
        Movie selectMovie = MovieRepository.getSelectMovie(selectMovieId);
    }
}