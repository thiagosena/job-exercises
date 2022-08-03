package com.thiagosena.exercise1.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisualNutsCounterTest {
    @Test
    void givenTwoValidNumbersShouldNotThrows() {
        Assertions.assertDoesNotThrow(() -> new VisualNutsCounter(1, 10));
    }
}
