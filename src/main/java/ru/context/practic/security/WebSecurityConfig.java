package ru.context.practic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Profile("dot")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/faculty/*","/department/*","/profession/*").hasRole("GUEST")
                .antMatchers("/student/**", "/profession/**","/marks/*","/teacher/**")
                    .hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/student/**").hasRole("USER")
                .antMatchers("/teacher/**", "/marks/**", "/post/**", "/timetable/**", "department/**")
                    .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/student/**").hasRole("ADMIN")
                .antMatchers("/profession/**", "/faculty/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("g").password("{noop}g").roles("GUEST");
        auth.inMemoryAuthentication().withUser("s").password("{noop}s").roles("USER", "GUEST");
        auth.inMemoryAuthentication().withUser("t").password("{noop}t").roles("ADMIN", "USER", "GUEST");

    }
}

