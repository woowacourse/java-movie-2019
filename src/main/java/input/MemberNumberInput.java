package input;

import domain.Movie;

public class MemberNumberInput {
    int memberNumber;

    public MemberNumberInput(Movie movie, int scheduleId, String input) {
        if (checkValidity(movie, scheduleId, input) ==  false) {
            throw new IllegalStateException();
        }
    }

    private boolean checkValidity(Movie movie, int scheduleId, String input) {
        int memberNumber = Integer.parseInt(input);
        if (memberNumber <= 0) {
            return false;
        }
        return movie.getScheduleById(scheduleId).isCrowded(memberNumber) != true;
    }

    public int toMemberNumber() {
        return memberNumber;
    }

}
