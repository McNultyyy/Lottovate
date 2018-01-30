package com.mcnulty.javaMillions;

import java.util.List;
import java.util.Optional;

public class JavaMillionsResult {
    private boolean isWinner;
    private List<Integer> matchedPool1Values;
    private List<Integer> matchesPool2Values;
    private Optional<JavaMillionsPrize> prize;


    public JavaMillionsResult(boolean isWinner, List<Integer> matchedPool1Values, List<Integer> matchedPool2Values, Optional<JavaMillionsPrize> prize) {
        this.isWinner = isWinner;
        this.matchedPool1Values = matchedPool1Values;
        this.matchesPool2Values = matchedPool2Values;
        this.prize = prize;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public Optional<JavaMillionsPrize> getPrize() {
        return prize;
    }

    public List<Integer> getMatchedPool1Values() {
        return matchedPool1Values;
    }

    public List<Integer> getMatchesPool2Values() {
        return matchesPool2Values;
    }
}
