package com.iNetSoft.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    // fields
    private final Random random = new Random();

    // it is not best practices to @Autowired fields
    //rather you @Autowired a Constructor instead
    //as such we comment out the @Autowired and @MinNumber and @MaxNumber annotation
   // @Autowired
    // @MaxNumber

    private final int maxNumber;
//    @Autowired
  //  @MinNumber
    private final int minNumber;

    // public methods


    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        //example: min=5 max=20 -> range 0-15 + min -> 5-20
        //return random.nextInt(maxNumber);
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
