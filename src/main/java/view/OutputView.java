package view;

import domain.Customer;
import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static void printSchedules(List<PlaySchedule> playSchedules) {
    	for(PlaySchedule playSchedule : playSchedules) {
    		playSchedule.toString();
    	}
    }
    
    public static void printErr(int errType) {
    	for(ErrMsg msg : ErrMsg.values())
    	if(errType == msg.index) System.out.println(msg.getMsg());
    }
    
    public static void printCurState(Customer customer) {
    	System.out.println("예약 내역");
    	for(int i = 0; i < customer.getUserMovies().size(); i++) {
    		System.out.println(customer.getUserMovies().get(i).getRst());
    		System.out.println(customer.getUserSchedules().get(i).getRst());
    		System.out.println("예약인원 : " + customer.getUsers().get(i) + "명");
    	}
    }

	public static void printResult(int result) {
		System.out.println("최종 예매한 금액은" +  result + " 원 입니다.");
		System.out.println("예매를 완료했습니다. 즐거운 영화관람 되세요.");
	}
}
