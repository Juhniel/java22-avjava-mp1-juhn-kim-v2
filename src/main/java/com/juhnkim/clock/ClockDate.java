package com.juhnkim.clock;

import com.juhnkim.helpers.StringFormatter;

import java.time.LocalDate;

public class ClockDate extends Clock {

    private LocalDate localDate;
    private StringFormatter stringFormatter;
    public ClockDate(ClockState clockState, StringFormatter stringFormatter) {
        super(clockState);
        this.stringFormatter = stringFormatter;
        this.localDate = LocalDate.now();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public void displayDateOrTime() {
        if(clockState.getCurrentState() == ClockState.STATE.DisplayDate) {
//            System.out.println(stringFormatter.formatDate(String.valueOf(localDate)));
            System.out.println(stringFormatter.formatDate(localDate));
        } else {
            System.out.println("Invalid State");
        }
    }

    @Override
    public void changeDateOrTime(String userInput) {
        if(clockState.getCurrentState() == ClockState.STATE.ChangeDate) {
            setLocalDate(stringFormatter.formatDate(userInput));
        } else {
            System.out.println("Invalid State");
        }
    }
}
