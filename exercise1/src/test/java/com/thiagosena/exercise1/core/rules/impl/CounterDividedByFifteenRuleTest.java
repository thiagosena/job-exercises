package com.thiagosena.exercise1.core.rules.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterDividedByFifteenRuleTest {
    @Test
    void givenANumberDividedByFifteenShouldReturnTrue() {
        CounterDividedByFifteenRule fifteenRule = new CounterDividedByFifteenRule();
        Assertions.assertTrue(fifteenRule.isDivided(15));
    }

    @Test
    void givenANumberNotDividedByFiveAndDividedByThreeShouldReturnFalse() {
        CounterDividedByFifteenRule fifteenRule = new CounterDividedByFifteenRule();
        Assertions.assertFalse(fifteenRule.isDivided(9));
    }

    @Test
    void givenANumberNotDividedByThreeAndDividedByFiveShouldReturnFalse() {
        CounterDividedByFifteenRule fifteenRule = new CounterDividedByFifteenRule();
        Assertions.assertFalse(fifteenRule.isDivided(5));
    }

    @Test
    void givenANumberDividedByFifteenShouldReturnVisualNuts() {
        CounterDividedByFifteenRule fifteenRule = new CounterDividedByFifteenRule();
        Assertions.assertEquals(fifteenRule.print(15), "Visual Nuts");
    }
}
