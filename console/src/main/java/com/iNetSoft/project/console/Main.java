package com.iNetSoft.project.console;

import com.iNetSoft.project.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("Guess the Number Game");

        //create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        /**
         get number generator bean from context (container)
         NumberGenerator numberGenerator
         = context.getBean("numberGenerator", NumberGenerator.class);
         call method next() to get a random number
         int number = numberGenerator.next();
         int num = numberGenerator.getMaxNumber();
         log generated number
         log.info("Number for next method = {}", number);
         log.debug("Number = {}", number);
         log.info("num for getMaxNumber method = {}", num);

         get game bean from context (container)
         Game game = context.getBean(Game.class);

         get Message bean from context (container)
         MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
         log.info("getMainMessage = {}", messageGenerator.getMainMessage());
         log.info("getResultMessage = {}", messageGenerator.getResultMessage());
         call reset() method

         game.reset();
         */


        //close context (container)
        context.close();

    }
}
