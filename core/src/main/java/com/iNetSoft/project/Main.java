package com.iNetSoft.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("Guess the Number Game");

        //create context (container)
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator",NumberGenerator.class);
        //call method next() to get a random number
        int number = numberGenerator.next();
        int num = numberGenerator.getMaxNumber();

        //log generated number
        log.info("Number for next method = {}", number);
        log.info("num for getMaxNumber method = {}", num);

        //close context (container)
        context.close();

    }
}
