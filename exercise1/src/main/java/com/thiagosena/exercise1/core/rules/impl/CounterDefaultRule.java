package com.thiagosena.exercise1.core.rules.impl;

import com.thiagosena.exercise1.core.rules.CounterRule;

public class CounterDefaultRule implements CounterRule {
    @Override
    public String print(int counter) {
        return String.valueOf(counter);
    }

    @Override
    public boolean isDivided(int counter) {
        return true;
    }
}
