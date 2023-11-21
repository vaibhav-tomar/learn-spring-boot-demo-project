package com.vaibhav.myfirstapp.config;

import com.vaibhav.myfirstapp.common.Coach;
import com.vaibhav.myfirstapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {  /* bean id defaults to the method name*/
        return new SwimCoach();
    }
}
