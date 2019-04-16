package domain;

public class reserveList {
	private final int id;
	private final String name;
	private final int price;
	private final int ticketNum;
	private Movie movie;
	private final int movieTime;
	
	public reserveList(Movie movie, int movieTime, int ticketNum) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.price = movie.getPrice();
		this.ticketNum = ticketNum;
		this.movie = movie;
		this.movieTime = movieTime;
		
	}
	
	public void printHistory(){
		System.out.println(this.id + " - " + this.name + ", " + this.price + "원");
		System.out.print("시작시간" + movie.getSchedule().get(movieTime-1).getTime());
		System.out.println("예약 인원 : " + this.ticketNum + "명\n");
	}
	
	public int getTotalPrice(){
		return this.price*this.ticketNum;
	}
	
}
