package domain;

import java.util.List;

public class TotalPrice {
	private static int totalPrice = 0;
	private static final int CARD = 1;
	private static final int CASH = 2;
	
	public void setTotalPrice(List<Movie> myMovies) {
		for (Movie movie : myMovies) {
			totalPrice += movie.getPrice() * movie.getPeople();
		}
	}
	
	public int getTotalPrice(int point, int purchaseMethod) {
		int purchasePrice = totalPrice-point;
		
		if (purchaseMethod == CARD) {
			return (int) (purchasePrice*0.95);
		}
		return (int) (purchasePrice*0.98);
	}
}
