package view;
import java.util.HashMap;

public class ErrorMessage {
    public static HashMap<String, String> errorMessage = new HashMap<String, String>() {
        {
            put("ERROR_USEABLEMOVIE","상영 가능한 영화가 아닙니다.");
            put("ERROR_MOVIETIMELIMIT","예약할 시간표를 다시 확인해주세요. ");
            put("ERROR_MOVIECAPACITYLIMIT","예약가능 인원이 초과되었습니다. ");
        }
    };

}
