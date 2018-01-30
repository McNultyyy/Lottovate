package com.mcnulty.springLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpringLottoTicket {
    private List<Integer> values;

    public SpringLottoTicket(List<Integer> values) {
        this.values = values;

        validate(values);
    }

    private void validate(List<Integer> values) {
        if (values.size() != 6)
            throw new IllegalArgumentException("SpringLottoTicket requires 6 values.");

        for (Integer value : values) {
            if (value > 36 || value < 1) {
                throw new IllegalArgumentException("SpringLottoTicket values must be between 1-36.");
            }
        }

        Set<Integer> setOfValues = new HashSet<Integer>(values);
        if (setOfValues.size() != values.size()) {
            throw new IllegalArgumentException("SpringLottoTicket cannot contain any duplicate values.");
        }

    }

    public List<Integer> getValues() {
        return values;
    }
}
