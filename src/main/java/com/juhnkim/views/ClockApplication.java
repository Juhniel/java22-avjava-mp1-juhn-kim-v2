package com.juhnkim.views;

import com.juhnkim.clock.Clock;
import com.juhnkim.clock.ClockDate;
import com.juhnkim.clock.ClockState;
import com.juhnkim.clock.ClockTime;
import com.juhnkim.helpers.StringFormatter;

import java.util.Scanner;

public class ClockApplication {
    private Clock clock;
    private ClockState clockState;
    private ClockDate clockDate;
    private ClockTime clockTime;
    private final Scanner scan = new Scanner(System.in);
    String userInput = "";

    public static void main(String[] args) {
        ClockState clockState = new ClockState();
        Clock clock = new Clock(clockState);
        ClockDate clockDate = new ClockDate(clockState, new StringFormatter());
        ClockTime clockTime = new ClockTime(clockState, new StringFormatter());
        ClockApplication ca = new ClockApplication(clock, clockState, clockDate, clockTime);
        ca.timeMenu();
    }

    public ClockApplication(Clock clock, ClockState clockState, ClockDate clockDate, ClockTime clockTime) {
        this.clock = clock;
        this.clockState = clockState;
        this.clockDate = clockDate;
        this.clockTime = clockTime;
    }
    public void timeMenu() {
        while (!userInput.equals("0")) {
            System.out.println("------------------------------------------------------");
            System.out.println("Current State: " + clockState.getCurrentState());
            System.out.println("------------------------------------------------------");
            System.out.println("""
                    -- CLOCK --\s
                    1. Display Time \s
                    2. Edit time\s
                    3. Display Date\s
                    0. Exit""");

            userInput = scan.nextLine();
            switch (userInput) {
                case "1":
                    clockTime.displayDateOrTime();
                    break;
                case "2":
                    System.out.println("Enter new time in the format: 'HH:mm'");
                    userInput = scan.nextLine();
                    clockState.setCurrentState(ClockState.STATE.ChangeTime);
                    clockTime.changeDateOrTime(userInput);
                    changeTimeMenu();
                    break;
                case "3":
                    clock.changeState();
                    dateMenu();
                    break;
                case "0":
                    System.out.println("Bye :(");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void dateMenu() {
        while (!userInput.equals("0")) {
            System.out.println("------------------------------------------------------");
            System.out.println("Current State: " + clockState.getCurrentState());
            System.out.println("------------------------------------------------------");
            System.out.println("""
                    -- CLOCK --\s
                    1. Display Date\s
                    2. Edit date\s
                    3. Display Time\s
                    0. Exit""");

            userInput = scan.nextLine();
            switch (userInput) {
                case "1":
                    clockDate.displayDateOrTime();
                    break;
                case "2":
                    System.out.println("Enter new date in the format: 'yyyy-MM-dd'");
                    userInput = scan.nextLine();
                    clockState.setCurrentState(ClockState.STATE.ChangeDate);
                    clockDate.changeDateOrTime(userInput);
                    changeDateMenu();
                    break;
                case "3":
                    clockDate.changeState();
                    timeMenu();
                case "0":
                    System.out.println("Bye :(");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void changeTimeMenu() {
        while (!userInput.equals("0")) {
            System.out.println("------------------------------------------------------");
            System.out.println("Current State: " + clockState.getCurrentState());
            System.out.println("------------------------------------------------------");
            System.out.println("""
                    -- CLOCK --\s
                    1. Display Time\s
                    2. Edit Time\s
                    0. Exit""");

            userInput = scan.nextLine();
            switch(userInput) {
                case "1" :
                    // ändra logik?
                    clockState.setCurrentState(ClockState.STATE.DisplayTime);
                    timeMenu();
                    break;
                case "2" :
                    System.out.println("Enter new time in the format: 'HH:mm'");
                    userInput = scan.nextLine();
                    clockTime.changeDateOrTime(userInput);
                    changeTimeMenu();
                    break;
                case "0":
                    System.out.println("Bye :(");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void changeDateMenu() {
        while (!userInput.equals("0")) {
            System.out.println("------------------------------------------------------");
            System.out.println("Current State: " + clockState.getCurrentState());
            System.out.println("------------------------------------------------------");
            System.out.println("""
                    -- CLOCK --\s
                    1. Edit Date\s
                    2. Display Date\s
                    0. Exit""");

            userInput = scan.nextLine();
            switch(userInput) {
                case "1" :
                    System.out.println("Enter new date in the format: 'yyyy-MM-dd'");
                    userInput = scan.nextLine();
                    clockDate.changeDateOrTime(userInput);
                    changeDateMenu();
                    break;
                case "2" :
                    clockState.setCurrentState(ClockState.STATE.DisplayDate);
                    dateMenu();
                case "0":
                    System.out.println("Bye :(");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

}
