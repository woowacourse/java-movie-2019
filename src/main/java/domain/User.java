package domain;

import java.math.BigDecimal;

public class User {
    private double point;

    public double getPoint(){
        return point;
    }

    public void addPoint(double willGetPoint){
        point+=willGetPoint;
    }
    public void usePointforPayment(double usePoint){
        point -= usePoint;
    }
}
