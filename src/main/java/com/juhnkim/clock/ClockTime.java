package com.juhnkim.clock;

import com.juhnkim.helpers.StringFormatter;

import java.time.LocalTime;

public class Time extends Clock{

    private LocalTime localTime;
    private StringFormatter stringFormatter;

    public Time(LocalTime localTime, StringFormatter stringFormatter) {
        this.localTime = localTime;
        this.stringFormatter = stringFormatter;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
