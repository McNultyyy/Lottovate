package com.mcnulty.springLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SpringLotto {

    private List<SpringLottoPrize> prizeStructure = Arrays.asList(
            new SpringLottoPrize(1, 6, 500000),
            new SpringLottoPrize(2, 5, 2000),
            new SpringLottoPrize(3, 4, 300),
            new SpringLottoPrize(4, 3, 50),
            new SpringLottoPrize(5, 2, 12),
            new SpringLottoPrize(6, 1, 3)
    );

    public SpringLottoResult calculate(SpringLottoTicket winningTicket, SpringLottoTicket inputTicket) {

        List<Integer> matchedValues = new ArrayList<>();

        List<Integer> values = winningTicket.getValues();
        for (int i = 0; i < values.size(); i++) {
            Integer winningTicketValue = values.get(i);
            Integer inputTicketValue = inputTicket.getValues().get(i);

            // if the winning and input ticket have matching values at the index 'i'
            if (winningTicketValue.equals(inputTicketValue)) {
                matchedValues.add(winningTicketValue);
            }
        }

        int matchesFromPool = matchedValues.size();

        Optional<SpringLottoPrize> prize = prizeStructure.stream()
                .filter(x -> x.getPoolMatches() == matchesFromPool)
                .findFirst();

        // User had a matching ticket
        if (prize.isPresent()) {
            return new SpringLottoResult(true, matchedValues, prize);
        } else {
            // User had a non-matching ticket, "empty prize" is given.
            return new SpringLottoResult(false, matchedValues, Optional.empty());
        }
    }
}
