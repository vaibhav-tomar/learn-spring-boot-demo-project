package com.vaibhav.myfirstapp.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim a 100 m as a warmup";
    }
}
