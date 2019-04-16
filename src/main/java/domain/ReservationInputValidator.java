package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReservationInputValidator {

    public ReservationInputValidator() {
    }

    List<Integer> getReservations(String line) {
        List<Integer> idCandidates = parseIntegers(line);
        if (idAllExists(idCandidates) && idIsNotDuplicated(idCandidates, line)) {
            return idCandidates;
        }
        throw new IllegalArgumentException("올바른 영화 번호가 아닙니다.");
    }

    private List<Integer> parseIntegers(String line) {
        try {
            return Arrays.stream(line.split("\\s*,\\s*"))
                .map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 영화번호 포맷이 아닙니다.");
        }
    }

    private boolean idAllExists(List<Integer> idCandidates) {
        Set<Movie> movieSet = new HashSet<>(MovieRepository.getMovies());
        return idCandidates.stream()
            .allMatch(id -> movieSet.stream().anyMatch(movie -> movie.matchId(id)));
    }

    private boolean idIsNotDuplicated(List<Integer> idCandidates, String line) {
        int commaCount = (int) line.chars().filter(i -> (char) i == ',').count();
        return idCandidates.stream().distinct().count() == commaCount + 1;
    }
}
