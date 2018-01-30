package com.mcnulty.springLotto;

import java.util.List;
import java.util.Optional;

public class SpringLottoResult {
    private boolean isWinner;
    private List<Integer> matchedValues;
    private Optional<SpringLottoPrize> prize;


    public SpringLottoResult(boolean isWinner, List<Integer> matchedValues, Optional<SpringLottoPrize> prize) {
        this.isWinner = isWinner;
        this.matchedValues = matchedValues;
        this.prize = prize;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public List<Integer> getMatchedValues() {
        return matchedValues;
    }

    public Optional<SpringLottoPrize> getPrize() {
        return prize;
    }
}
