package com.juhnkim.clock;

import com.juhnkim.helpers.StringFormatter;

import java.time.LocalTime;

public class ClockTime extends Clock{

    private LocalTime localTime;
    private StringFormatter stringFormatter;
    public ClockTime(ClockState clockState, StringFormatter stringFormatter) {
        super(clockState);
        this.stringFormatter = stringFormatter;
        this.localTime = LocalTime.now();
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    @Override
    public void displayDateOrTime() {
        if(clockState.getCurrentState() == ClockState.STATE.DisplayTime) {
            System.out.println(stringFormatter.formatTime(localTime));
        } else {
            System.out.println("Invalid State");
        }
    }

    @Override
    public void changeDateOrTime(String userInput) {
        if(clockState.getCurrentState() == ClockState.STATE.ChangeTime) {
            setLocalTime(LocalTime.parse(userInput));
        } else {
            System.out.println("Invalid State");
        }
    }
}
