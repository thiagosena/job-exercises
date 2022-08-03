package com.thiagosena.exercise1.core;

import com.thiagosena.exercise1.core.rules.CounterRule;
import com.thiagosena.exercise1.core.rules.impl.CounterDividedByFifteenRule;
import com.thiagosena.exercise1.core.rules.impl.CounterDividedByFiveRule;
import com.thiagosena.exercise1.core.rules.impl.CounterDividedByThreeRule;
import com.thiagosena.exercise1.core.rules.impl.CounterDefaultRule;

import java.util.ArrayList;
import java.util.List;

public class VisualNutsCounter {

    private static final List<CounterRule> counterRules = new ArrayList<>();

    static {
        counterRules.add(new CounterDividedByFifteenRule());
        counterRules.add(new CounterDividedByFiveRule());
        counterRules.add(new CounterDividedByThreeRule());
        counterRules.add(new CounterDefaultRule());
    }

    public VisualNutsCounter(int counter, int finalCounter) {
        for (; counter <= finalCounter; counter++) {
            System.out.println(start(counter));
        }
    }

    private String start(int count) {
        return counterRules.stream()
                .filter(messageCounter -> messageCounter.isDivided(count))
                .map(message -> message.print(count))
                .findFirst()
                .orElseThrow();
    }
}
