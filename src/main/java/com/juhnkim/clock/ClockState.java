package com.juhnkim.clock;

public class ClockState {
    private STATE currentState = STATE.DisplayTime;

    public enum STATE {
        DisplayTime,
        ChangeTime,
        DisplayDate,
        ChangeDate
    }

    public STATE getCurrentState() {
        return currentState;
    }

    public void setCurrentState(STATE currentState) {
        this.currentState = currentState;
    }
}
