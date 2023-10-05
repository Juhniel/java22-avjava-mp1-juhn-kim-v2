package com.juhnkim.helpers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringFormatter {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalTime formatTime(String timeString) {
        return LocalTime.parse(timeString, TIME_FORMAT);
    }

    public String formatTime(LocalTime time) {
        return time.format(TIME_FORMAT);
    }

    public LocalDate formatDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMAT);
    }

    public String formatDate(LocalDate date) {
        return date.format(DATE_FORMAT);
    }
}
