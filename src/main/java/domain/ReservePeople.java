package domain;

public class ReservePeople {
    private final int reservePeople;

    public ReservePeople(PlaySchedule reserveSchedule,int reservePeople){
        int capaCity = reserveSchedule.getCapacity();

        if(capaCity < reservePeople){
            throw new IllegalArgumentException("예약가능 인원을 초과하였습니다.");
        }

        this.reservePeople = reservePeople;

    }
}
