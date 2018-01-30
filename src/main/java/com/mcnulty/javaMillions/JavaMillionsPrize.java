package com.mcnulty.javaMillions;

public class JavaMillionsPrize {
    private int prizeClass;
    private int pool1Matches;
    private int pool2Matches;
    private int prizeAmount;

    public JavaMillionsPrize(int prizeClass, int pool1Matches, int pool2Matches, int prizeAmount) {
        this.prizeClass = prizeClass;
        this.pool1Matches = pool1Matches;
        this.pool2Matches = pool2Matches;
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeClass() {
        return prizeClass;
    }

    public int getPool1Matches() {
        return pool1Matches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getPool2Matches() {
        return pool2Matches;
    }
}
