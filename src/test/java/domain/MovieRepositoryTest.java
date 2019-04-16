/*
 * MovieRepositoryTest
 * 
 * version 1.0
 * 
 * 2019. 4. 16
 * 
 * Created by Wongeun Song
 */
package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import domain.MovieRepository;

public class MovieRepositoryTest {
	@Test
	public void hasMovie() {
		assertThat(MovieRepository.hasMovie(1)).isEqualTo(true);
		assertThat(MovieRepository.hasMovie(2)).isEqualTo(false);
	}
}
