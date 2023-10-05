package com.juhnkim.interfaces;

public interface ActionInterface {
    public void changeState(); // For changing state between DisplayTime & DisplayDate
    public void displayDateOrTime(); // For displaying Time or displaying Date if we are in the correct state
    public void changeDateOrTime(String userInput); // For changing the time if we are in ChangeTime State, and vice versa for date
}
