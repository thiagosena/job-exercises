package com.thiagosena.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterServiceTest {

    @Test
    void givenInvalidArgsLengthShouldThrowsRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> CounterService.main(new String[]{"1"}));
    }

    @Test
    void givenInvalidFirstArgsShouldThrowsRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> CounterService.main(new String[]{"asd", "10"}));
    }

    @Test
    void givenInvalidSecondArgsShouldThrowsRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> CounterService.main(new String[]{"1", "-10"}));
    }

    @Test
    void givenFirstNumberGreaterThanSecondShouldThrowsRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> CounterService.main(new String[]{"10", "1"}));
    }

    @Test
    void givenValidArgsShouldNotThrowException() {
        Assertions.assertDoesNotThrow(() -> CounterService.main(new String[]{"1", "10"}));
    }

}
