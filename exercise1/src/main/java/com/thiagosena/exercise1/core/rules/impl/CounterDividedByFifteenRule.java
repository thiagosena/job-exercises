package com.thiagosena.exercise1.core.rules.impl;

import com.thiagosena.exercise1.core.rules.CounterRule;

public class CounterDividedByFifteenRule implements CounterRule {
    @Override
    public String print(int counter) {
        return "Visual Nuts";
    }

    @Override
    public boolean isDivided(int counter) {
        return (counter % 3) == 0 && (counter % 5) == 0;
    }
}
