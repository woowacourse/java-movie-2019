package Program.Config;

public class Validation {
    public static void checkBookingPeopleNumber(int available, int want) throws Exception{
        if(available-want >= 0){
            return;
        }
        throw new Exception();
    }
}
