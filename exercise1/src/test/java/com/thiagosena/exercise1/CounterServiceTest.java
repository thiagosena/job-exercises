package com.thiagosena.exercise1;

import com.thiagosena.exercise1.exceptions.ValidateArgsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterServiceTest {

    @Test
    void givenInvalidArgsLengthShouldThrowsRuntimeException() {
        Assertions.assertThrows(ValidateArgsException.class, () -> CounterService.main(new String[]{"1"}));
    }

    @Test
    void givenInvalidFirstArgsShouldThrowsRuntimeException() {
        Assertions.assertThrows(ValidateArgsException.class, () -> CounterService.main(new String[]{"asd", "10"}));
    }

    @Test
    void givenInvalidSecondArgsShouldThrowsRuntimeException() {
        Assertions.assertThrows(ValidateArgsException.class, () -> CounterService.main(new String[]{"1", "-10"}));
    }

    @Test
    void givenFirstNumberGreaterThanSecondShouldThrowsRuntimeException() {
        Assertions.assertThrows(ValidateArgsException.class, () -> CounterService.main(new String[]{"10", "1"}));
    }

    @Test
    void givenValidArgsShouldNotThrowException() {
        Assertions.assertDoesNotThrow(() -> CounterService.main(new String[]{"1", "10"}));
    }

}
