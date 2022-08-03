package com.thiagosena.exercise1.core.messages.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageCounterRuleTest {
    @Test
    void givenAnyNumberShouldReturnTrue() {
        MessageCounterRule numberRule = new MessageCounterRule();
        Assertions.assertTrue(numberRule.isDivided(1));
    }

    @Test
    void givenAnyNumberShouldReturnItself() {
        MessageCounterRule numberRule = new MessageCounterRule();
        Assertions.assertEquals(numberRule.print(3), String.valueOf(3));
    }
}
