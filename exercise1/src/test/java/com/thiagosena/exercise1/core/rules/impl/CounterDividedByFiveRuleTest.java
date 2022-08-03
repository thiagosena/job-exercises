package com.thiagosena.exercise1.core.rules.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterDividedByFiveRuleTest {
    @Test
    void givenANumberDividedByFiveShouldReturnTrue() {
        CounterDividedByFiveRule fiveRule = new CounterDividedByFiveRule();
        Assertions.assertTrue(fiveRule.isDivided(5));
    }

    @Test
    void givenANumberNotDividedByFiveShouldReturnFalse() {
        CounterDividedByFiveRule fiveRule = new CounterDividedByFiveRule();
        Assertions.assertFalse(fiveRule.isDivided(9));
    }

    @Test
    void givenANumberDividedByFiveShouldReturnNuts() {
        CounterDividedByFiveRule fiveRule = new CounterDividedByFiveRule();
        Assertions.assertEquals(fiveRule.print(5), "Nuts");
    }
}
