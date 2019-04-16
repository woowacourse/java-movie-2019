package view;

import org.junit.Test;

import static org.junit.Assert.*;

public class OutputViewTest {

    @Test
    public void printResult() {
        int total = 16000;
        int point = 1000;
        double pay = 0.95;
        OutputView.printResult(total, point, pay);
    }
}