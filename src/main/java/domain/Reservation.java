package domain;

public class Reservation {

        private final Movie movie;
        private final int personnel;
        private final int scheduleNo;

        public Reservation(Movie movie, int personnel, int scheduleNo) {
                if(!movie.modifyScheduleCapacity(scheduleNo, personnel)){
                        throw new IllegalArgumentException("인원이 너무 많습니다.");
                }
                this.movie = movie;
                this.personnel = personnel;
                this.scheduleNo = scheduleNo;
        }

}
