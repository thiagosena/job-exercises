package com.thiagosena.exercise1.core.rules.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterDefaultRuleTest {
    @Test
    void givenAnyNumberShouldReturnTrue() {
        CounterDefaultRule numberRule = new CounterDefaultRule();
        Assertions.assertTrue(numberRule.isDivided(1));
    }

    @Test
    void givenAnyNumberShouldReturnItself() {
        CounterDefaultRule numberRule = new CounterDefaultRule();
        Assertions.assertEquals(numberRule.print(3), String.valueOf(3));
    }
}
