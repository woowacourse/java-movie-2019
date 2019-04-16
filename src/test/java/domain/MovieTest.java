package domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DateTimeUtils.createDateTime;

public class MovieTest {

    @Test
    public void 스케쥴_선택_정상적인구매_() {
        MovieRepository movieRepository = new MovieRepository();
        BoxOffice boxOffice = new BoxOffice(MovieRepository.getSelectMovie(1));
        PlaySchedule playSchedule = boxOffice.selectSchedule(4, 1, createDateTime("2019-04-16 18:41"));
        assertThat(playSchedule.getCapacity()).isEqualTo(2);
    }

    @Test()
    public void 영화_시간이_지났을_경우() {
        MovieRepository movieRepository = new MovieRepository();
        BoxOffice boxOffice = new BoxOffice(MovieRepository.getSelectMovie(1));
        PlaySchedule playSchedule = boxOffice.selectSchedule(4, 1, createDateTime("2019-04-16 14:41"));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void 존재하지_않는_스케쥴_선택_익셉션() {
        MovieRepository movieRepository = new MovieRepository();
        BoxOffice boxOffice = new BoxOffice(MovieRepository.getSelectMovie(1));
        PlaySchedule playSchedule = boxOffice.selectSchedule(6, 1, LocalDateTime.now());
    }


}