package com.hng12.backend_task_1.model;

import java.util.List;

public class NumberClassificationResponse {
    private int number;
    private boolean isPrime;
    private boolean isPerfect;
    private List<String> properties;
    private int digitSum;
    private String funFact;

    public NumberClassificationResponse(int number, boolean isPrime, boolean isPerfect, List<String> properties, int digitSum, String funFact) {
        this.number = number;
        this.isPrime = isPrime;
        this.isPerfect = isPerfect;
        this.properties = properties;
        this.digitSum = digitSum;
        this.funFact = funFact;
    }

    // Getters and Setters
    public int getNumber() {
        return number;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public boolean isPerfect() {
        return isPerfect;
    }

    public List<String> getProperties() {
        return properties;
    }

    public int getDigitSum() {
        return digitSum;
    }

    public String getFunFact() {
        return funFact;
    }
}
