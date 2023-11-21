package com.vaibhav.myfirstapp.security;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/students").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.POST, "/api/students").hasAnyRole("ADMIN") );

        //use http basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable csrf. In genaral, not required for stateless rest apis that use post, put, delete or patch
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
