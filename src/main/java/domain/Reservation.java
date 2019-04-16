package domain;

public class Reservation {

        private final Movie movie;
        private final int personnel;
        private final int scheduleNo;

        public Reservation(Movie movie, int personnel, int scheduleNo) {
                this.movie = movie;
                this.personnel = personnel;
                this.scheduleNo = scheduleNo;
        }

}
