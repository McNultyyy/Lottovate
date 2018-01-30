package com.mcnulty.javaMillions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaMillionsTicket {
    private List<Integer> values;
    private List<Integer> pool1;
    private List<Integer> pool2;

    public JavaMillionsTicket(List<Integer> values) {
        this.values = values;

        pool1 = getValues().stream().limit(5).collect(Collectors.toList());

        pool2 = new ArrayList<>();
        pool2.add(getValues().get(getValues().size() - 1));

        validate(values);
    }

    private void validate(List<Integer> values) {
        if (values.size() != 6)
            throw new IllegalArgumentException("JavaMillionsTicket requires 6 values.");

        for (int i = 0; i < values.size() - 1; i++) {
            Integer value = values.get(i);
            if (value > 49 || value < 1) {
                throw new IllegalArgumentException("JavaMillionsTicket pool 1 values must be between 1-49.");
            }
        }
        Integer value = values.get(values.size() - 1);
        if (value > 9 || value < 1) {
            throw new IllegalArgumentException("JavaMillionsTicket pool 2 value must be between 1-9");
        }


        Set<Integer> setOfValues = new HashSet<>(pool1);
        if (setOfValues.size() != values.size() - 1) {
            throw new IllegalArgumentException("JavaMillionsTicket pool 1 values cannot contain any duplicate values.");
        }

    }

    public List<Integer> getPool1Values() {
        return pool1;
    }

    public List<Integer> getPool2Values() {
        return pool2;
    }

    public List<Integer> getValues() {
        return values;
    }
}
