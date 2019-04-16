package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static List<Movie> movies = MovieRepository.getMovies();
    private static List<SelectedMovie> selectedMovies = new ArrayList<>();
    private static int index = 0;
    private int totalPrice;
    private int point;

    public Reservation(){

    }

    public void startReservation(){
        boolean flag = true;
        do{
            int movieId = InputView.inputMovieId();
            OutputView.showSelectedMovie(movieId);
            selectedMovies.get(index).getData();
            selectedMovies.get(index).showSelectedMovieSchecule();
            index += 1;
            flag = InputView.inputContinueReservation();
        }while(flag);
    }


    private void calculateTotalPrice(){

    }

    public static Movie showMovie(int id) {
        for(int i = 0; i < movies.size(); i++){
            boolean tmp = movies.get(i).isMatchedId(id);
            if(tmp == true){
                selectedMovies.add(new SelectedMovie(movies.get(i)));
                return movies.get(i);
            }
        }
        return null;
    }

}
