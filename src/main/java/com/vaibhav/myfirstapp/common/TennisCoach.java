package com.vaibhav.myfirstapp.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private TennisCoach() {
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "run 5 km on tennis ground";
    }
}
