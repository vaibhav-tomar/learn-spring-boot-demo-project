package com.vaibhav.myfirstapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class CricketCoach implements Coach{

    private CricketCoach() {
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "run 5 km on ground";
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("Inside post construct: " + getClass().getSimpleName());
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("Inside pre destroy: " + getClass().getSimpleName());
    }
}
