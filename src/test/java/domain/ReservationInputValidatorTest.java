package domain;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class ReservationInputValidatorTest {

    @Test
    public void getReservations() {
        ReservationInputValidator validator = new ReservationInputValidator();
        List<Integer> actual = validator.getReservationMovieNumbers("1 , 5, 7, 8");
        assertEquals(Stream.of(1, 5, 7, 8).collect(Collectors.toList()), actual);
    }
}