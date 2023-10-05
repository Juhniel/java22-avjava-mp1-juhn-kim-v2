package com.juhnkim.clock;

import com.juhnkim.interfaces.ActionInterface;

public class Clock implements ActionInterface {
    protected ClockState clockState;

    public Clock(ClockState clockState) {
        this.clockState = clockState;
    }


    @Override
    public void changeState() {
        if(clockState.getCurrentState() == ClockState.STATE.DisplayTime) {
            clockState.setCurrentState(ClockState.STATE.DisplayDate);
        } else if(clockState.getCurrentState() == ClockState.STATE.DisplayDate){
            clockState.setCurrentState(ClockState.STATE.DisplayTime);
        } else {
            System.out.println("Invalid State");
        }
    }

    @Override
    public void displayDateOrTime() {

    }

    @Override
    public void changeDateOrTime(String userInput) {

    }
}
