package com.mcnulty.springLotto;

public class SpringLottoPrize {
    private int prizeClass;
    private int poolMatches;
    private int prizeAmount;

    public SpringLottoPrize(int prizeClass, int poolMatches, int prizeAmount) {
        this.prizeClass = prizeClass;
        this.poolMatches = poolMatches;
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeClass() {
        return prizeClass;
    }

    public int getPoolMatches() {
        return poolMatches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
