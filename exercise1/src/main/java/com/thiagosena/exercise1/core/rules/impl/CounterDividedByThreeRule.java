package com.thiagosena.exercise1.core.rules.impl;

import com.thiagosena.exercise1.core.rules.CounterRule;

public class CounterDividedByThreeRule implements CounterRule {
    @Override
    public String print(int counter) {
        return "Visual";
    }

    @Override
    public boolean isDivided(int counter) {
        return (counter % 3) == 0;
    }
}
