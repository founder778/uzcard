package com.company.UzCard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController  {

    @GetMapping("")
    public String test(){
        return "adminjon";
    }
}

//http
//        .csrf()
//        .disable()
//        .authorizeRequests()
//        .antMatchers("/card/number/*").hasRole("ADMIN")
////                .permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .formLogin().loginPage("searching.html");