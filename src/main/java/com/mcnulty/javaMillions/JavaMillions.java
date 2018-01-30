package com.mcnulty.javaMillions;

import java.util.*;

public class JavaMillions {

    private List<JavaMillionsPrize> prizeStructure = Arrays.asList(
            new JavaMillionsPrize(1, 5, 1, 10000000),
            new JavaMillionsPrize(2, 5, 0, 100000),
            new JavaMillionsPrize(3, 4, 1, 10000),
            new JavaMillionsPrize(4, 4, 0, 500),
            new JavaMillionsPrize(5, 3, 1, 100),
            new JavaMillionsPrize(6, 3, 0, 30),
            new JavaMillionsPrize(7, 2, 1, 5),
            new JavaMillionsPrize(8, 2, 0, 2)
    );

    public JavaMillionsResult calculate(JavaMillionsTicket winningTicket, JavaMillionsTicket inputTicket) {

        Set<Integer> winningTicketPool1Set = new HashSet<>(winningTicket.getPool1Values());
        Set<Integer> winningTicketPool2Set = new HashSet<>(winningTicket.getPool2Values());

        List<Integer> pool1Matches = new ArrayList<>();
        List<Integer> pool2Matches = new ArrayList<>();

        // check pool 1 matches
        for (Integer value : inputTicket.getPool1Values()) {
            if (winningTicketPool1Set.contains(value)) {
                pool1Matches.add(value);
            }
        }

        // check pool 2 matches
        for (Integer value : inputTicket.getPool2Values()) {
            if (winningTicketPool2Set.contains(value)) {
                pool2Matches.add(value);
            }
        }

        int matchesFromPool1 = pool1Matches.size();
        int matchesFromPool2 = pool2Matches.size();

        // get the prize (if any)
        Optional<JavaMillionsPrize> prize = prizeStructure.stream()
                .filter(p -> p.getPool1Matches() == matchesFromPool1 && p.getPool2Matches() == matchesFromPool2)
                .findFirst();


        // User had a matching ticket
        if (prize.isPresent()) {
            return new JavaMillionsResult(true, pool1Matches, pool2Matches, prize);

        } else { //otherwise nothing
            return new JavaMillionsResult(false, pool1Matches, pool2Matches, Optional.empty());
        }

    }
}


