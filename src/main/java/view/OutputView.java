package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static void findMovie(List<Movie> movies, int movieId){
    	for(Movie movie : movies){
    		printSelectMovie(movie, movieId);
    	}
    }
    
    public static void printSelectMovie(Movie movie, int movieId){
    	if(movie.getId()==movieId){
			System.out.println(movie);
		}
    }
    
    public static void printResult(){
    	System.out.println("최종 결제한 금액은 " + "원 입니다.");
    	System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
    }
    
    
}
