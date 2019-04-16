package domain;

public class Reservation {
        private static final char NEW_LINE = '\n';

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

        public PlaySchedule getPlaySchedule(){
                return movie.getSchedule(scheduleNo);
        }

        public long getTotalMoney(){
                return this.personnel * movie.getPrice();
        }

        @Override
        public String toString(){
                StringBuilder sb = new StringBuilder();
                sb.append(movie.printMovie());
                sb.append( movie.getSchedule(scheduleNo).printSchedule());
                sb.append("예약인원: "+personnel+"명");
                return sb.toString();

        }

}
