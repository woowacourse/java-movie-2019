package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class BookMovie {
    List<Movie>  bookMovieList = new ArrayList<>();

    public BookMovie(){

    }

    public void addBookMovieList(Movie movie){
        bookMovieList.add(movie);
    }

    @Override
    public String toString(){
        return bookMovieList.toString();
    }
}
