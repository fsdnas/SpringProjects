package com.logger.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    Logger logger = LoggerFactory.getLogger(GreetController.class);

    @RequestMapping("/greet")
    public String greet() {
        logger.info("Greeting");
        logger.warn("this is warning");
        logger.error("this is error");
        logger.debug("this is debug");
        logger.trace("this is trace");
        return "Hello World";
    }

    @RequestMapping("/userDetails/{name}/{city}")
    public String userDetails(@PathVariable("name") String username, @PathVariable("city") String city) {
        logger.debug("inside userdetails");
        if (city.equals("ban")) {
            logger.debug("checking city");
            logger.warn("invalid input");
        }
        if (username.equals("Priya")) {
            logger.debug("checking name");
            logger.info("correct username " + username);
            return "welcome " + username + " from " + city;
        } else {
            logger.debug("username is wrong - debug");
            logger.error("wrong user");
            return "wrong user";
        }

    }
}
