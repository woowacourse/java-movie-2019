package logic;

import domain.MovieRepository;

public class MovieApplication {
    public static void main(String[] args) {
        Player player = new Player();
        do {
            player.play();
            player.calculateCost();
        } while (MovieRepository.isAllMoviePossible());
    }
}
