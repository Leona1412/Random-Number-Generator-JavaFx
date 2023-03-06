package com.example.localtime;

import java.util.Random;

public class RandomNumbers {
    private int lowerLimit;
    private int upperLimit;

    public RandomNumbers() {
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int generateRandomInt(int lowerLimit, int upperLimit) {
        Random random = new Random();
        return random.nextInt(lowerLimit, upperLimit);
    }
}
