/*
 * @(#)DateTimeUtils.java
 *
 * v 0.0.0
 *
 * 2019.04.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTime 유틸 클래스
 *
 * @version 0.0.0
 * @author WoowahanTechCamp
 */
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

    public static boolean isOneHourWithinRange(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDateTime startDateTime = dateTime1.minusHours(ONE_HOURS);
        LocalDateTime endDateTime = dateTime1.plusHours(ONE_HOURS);
        return dateTime2.isAfter(startDateTime) && dateTime2.isBefore(endDateTime);
    }
}
