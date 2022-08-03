package com.thiagosena.exercise1.core.messages.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageCounterDividedByThreeRuleTest {
    @Test
    void givenANumberDividedByThreeShouldReturnTrue() {
        MessageCounterDividedByThreeRule threeRule = new MessageCounterDividedByThreeRule();
        Assertions.assertTrue(threeRule.isDivided(3));
    }

    @Test
    void givenANumberNotDividedByThreeShouldReturnFalse() {
        MessageCounterDividedByThreeRule threeRule = new MessageCounterDividedByThreeRule();
        Assertions.assertFalse(threeRule.isDivided(5));
    }

    @Test
    void givenANumberDividedByThreeShouldReturnVisual() {
        MessageCounterDividedByThreeRule threeRule = new MessageCounterDividedByThreeRule();
        Assertions.assertEquals(threeRule.print(3), "Visual");
    }
}
