package com.iNetSoft.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game{

    //constants
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // fields
    //It is not best practices to use @Autowired on fields
    //rather we use Constructor injection
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;
    private final int minNumber;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount, @MinNumber int minNumber) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
        this.minNumber = minNumber;
    }

    /**
    // constructor based dependency injection/ioc(inversion of control)
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    } */

    //Constructors


    //init method
    @Override
    @PostConstruct
    public void reset() {
        smallest = minNumber;          //or numberGenerator.getMinNumber();
        guess = minNumber;          //or numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);


    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    //setter based dependency injection
//    public void setNumberGenerator (NumberGenerator numberGenerator){
//        this.numberGenerator = numberGenerator;
//    }

    //public methods
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess =guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuess() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if (validNumberRange){
            if (guess > number) {
                biggest = guess -1;
            }
            if (guess < number ) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    //private methods
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) &&
                (guess <= biggest);
    }
}
