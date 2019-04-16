package utils;

import java.util.*;

public class MyUtil {
    public List<Integer> numberToList(Integer number){
        List<Integer> numberList = new ArrayList<>();
        int size = number.toString().length();
        for(int i=0; i<size; i++){
            numberList.add(number%10);
            number/=10;
        }
        Collections.reverse(numberList);
        return numberList;
    }

    public List<String> tokenize(String input){
        List<String> names = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            names.add(token.nextToken());
        }
        return names;
    }

    /*
    public Vector<Car> tokenize(String input){
        Vector<Car> carList = new Vector<Car>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            carList.add(new Car(token.nextToken()));
        }
        return carList;
    }
    */

    public int[] numberToArr(int number){
        int[] ret = new int[3];
        for(int i=2; i>=0; i--){
            ret[i] = number % 10;
            number /= 10;
        }
        return ret;
    }

    public Integer getRandomNumber(){
        Random random = new Random();
        return random.nextInt(10); //0~9
    }
}
