package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
    public static final String PLAYING_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final int ONE_HOURS = 1;

    public static LocalDateTime createDateTime(String dateTime) {
        return createDateTime(dateTime, PLAYING_TIME_FORMAT);
    }

    public static LocalDateTime createDateTime(String dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static String format(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PLAYING_TIME_FORMAT);
        return dateTime.format(formatter);
    }
    
    public String createNowDateTime() {
		String nowDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(PLAYING_TIME_FORMAT));
		return nowDateTime;
    }

    // 1시간 이내인지 판단하는 메서드
    public static boolean isOneHourWithinRange(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDateTime startDateTime = dateTime1.minusHours(ONE_HOURS);
        LocalDateTime endDateTime = dateTime1.plusHours(ONE_HOURS);
        return dateTime2.isAfter(startDateTime) && dateTime2.isBefore(endDateTime);
    }
}
