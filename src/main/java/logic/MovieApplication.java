package logic;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        Player player = new Player();
        player.play();
        player.calculateCost();
    }
}
