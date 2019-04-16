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
		int purchasePrice = 0;
		
		if (purchaseMethod == CARD) {
			purchasePrice = (int) (totalPrice*0.95);
		}
		if (purchaseMethod == CASH) {
			purchasePrice = (int) (totalPrice*0.98);
		}
		 return purchasePrice - point;
	}
}
