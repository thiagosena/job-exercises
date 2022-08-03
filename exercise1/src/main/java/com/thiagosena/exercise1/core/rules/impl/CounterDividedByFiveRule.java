package com.thiagosena.exercise1.core.rules.impl;

import com.thiagosena.exercise1.core.rules.CounterRule;

public class CounterDividedByFiveRule implements CounterRule {
    @Override
    public String print(int counter) {
        return "Nuts";
    }

    @Override
    public boolean isDivided(int counter) {
        return (counter % 5) == 0;
    }
}
