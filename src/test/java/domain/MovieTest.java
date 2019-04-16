package domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DateTimeUtils.createDateTime;

public class MovieTest {
    @Before
    public void 영화표_생성() {
        MovieRepository movieRepository = new MovieRepository();
    }

    @Test
    public void 스케쥴_선택_정상적인구매_() {
        BoxOffice boxOffice = new BoxOffice(MovieRepository.getSelectMovie(1));
        PlaySchedule playSchedule = boxOffice.selectSchedule(4, 1, createDateTime("2019-04-16 18:41"));
        assertThat(playSchedule.getCapacity()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 영화_시간이_지났을_경우() {
        BoxOffice boxOffice = new BoxOffice(MovieRepository.getSelectMovie(1));
        PlaySchedule playSchedule = boxOffice.selectSchedule(4, 1, createDateTime("2019-04-16 19:41"));

    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void 존재하지_않는_스케쥴_선택_익셉션() {
        BoxOffice boxOffice = new BoxOffice(MovieRepository.getSelectMovie(1));
        PlaySchedule playSchedule = boxOffice.selectSchedule(6, 1, LocalDateTime.now());
    }


}