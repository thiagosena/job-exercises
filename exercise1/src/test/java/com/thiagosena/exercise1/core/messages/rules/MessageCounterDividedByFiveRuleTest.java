package com.thiagosena.exercise1.core.messages.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageCounterDividedByFiveRuleTest {
    @Test
    void givenANumberDividedByFiveShouldReturnTrue() {
        MessageCounterDividedByFiveRule fiveRule = new MessageCounterDividedByFiveRule();
        Assertions.assertTrue(fiveRule.isDivided(5));
    }

    @Test
    void givenANumberNotDividedByFiveShouldReturnFalse() {
        MessageCounterDividedByFiveRule fiveRule = new MessageCounterDividedByFiveRule();
        Assertions.assertFalse(fiveRule.isDivided(9));
    }

    @Test
    void givenANumberDividedByFiveShouldReturnNuts() {
        MessageCounterDividedByFiveRule fiveRule = new MessageCounterDividedByFiveRule();
        Assertions.assertEquals(fiveRule.print(5), "Nuts");
    }
}
