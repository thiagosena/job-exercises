package com.thiagosena.exercise1.core.messages.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageCounterDividedByFifteenRuleTest {
    @Test
    void givenANumberDividedByFifteenShouldReturnTrue() {
        MessageCounterDividedByFifteenRule fifteenRule = new MessageCounterDividedByFifteenRule();
        Assertions.assertTrue(fifteenRule.isDivided(15));
    }

    @Test
    void givenANumberNotDividedByFiveAndDividedByThreeShouldReturnFalse() {
        MessageCounterDividedByFifteenRule fifteenRule = new MessageCounterDividedByFifteenRule();
        Assertions.assertFalse(fifteenRule.isDivided(9));
    }

    @Test
    void givenANumberNotDividedByThreeAndDividedByFiveShouldReturnFalse() {
        MessageCounterDividedByFifteenRule fifteenRule = new MessageCounterDividedByFifteenRule();
        Assertions.assertFalse(fifteenRule.isDivided(5));
    }

    @Test
    void givenANumberDividedByFifteenShouldReturnVisualNuts() {
        MessageCounterDividedByFifteenRule fifteenRule = new MessageCounterDividedByFifteenRule();
        Assertions.assertEquals(fifteenRule.print(15), "Visual Nuts");
    }
}
