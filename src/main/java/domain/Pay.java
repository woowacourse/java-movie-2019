package domain;

import java.util.HashMap;
import java.util.Map;

public class Pay {
    private static Map<Integer, Double> pays = new HashMap<>();

    static {
        pays.put(1, 0.95);
        pays.put(2, 0.98);
    }

    private Pay() {
    }

    public static Double getDiscountRate(int i) {
        return pays.get(i);
    }


}
