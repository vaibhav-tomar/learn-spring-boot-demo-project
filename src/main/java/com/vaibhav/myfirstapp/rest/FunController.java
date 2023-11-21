package com.vaibhav.myfirstapp.rest;

import com.vaibhav.myfirstapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunController {

    Coach coach;

    @Autowired
    private FunController(@Qualifier("aquatic") Coach coach) {
        this.coach = coach;
    }
    @GetMapping("/")
    public String sayHello() {
        return coach.getDailyWorkout();
    }
}
