package Exceptions;

public class PeopleException {
    public static boolean setCapacity(int capacity, int people){
        if(capacity - people < 0){
            return false;
        }
        return true;
    }
}
