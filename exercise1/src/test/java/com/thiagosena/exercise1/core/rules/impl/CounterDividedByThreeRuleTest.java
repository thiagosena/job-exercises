package com.thiagosena.exercise1.core.rules.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterDividedByThreeRuleTest {
    @Test
    void givenANumberDividedByThreeShouldReturnTrue() {
        CounterDividedByThreeRule threeRule = new CounterDividedByThreeRule();
        Assertions.assertTrue(threeRule.isDivided(3));
    }

    @Test
    void givenANumberNotDividedByThreeShouldReturnFalse() {
        CounterDividedByThreeRule threeRule = new CounterDividedByThreeRule();
        Assertions.assertFalse(threeRule.isDivided(5));
    }

    @Test
    void givenANumberDividedByThreeShouldReturnVisual() {
        CounterDividedByThreeRule threeRule = new CounterDividedByThreeRule();
        Assertions.assertEquals(threeRule.print(3), "Visual");
    }
}
