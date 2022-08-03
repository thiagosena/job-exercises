package com.thiagosena.exercise1.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
    @Test
    void givenStringThatIsNumberShouldReturnTrue() {
        Assertions.assertTrue(StringUtil.isNumber("4"));
    }

    @Test
    void givenStringThatIsNotNumberShouldReturnFalse() {
        Assertions.assertFalse(StringUtil.isNumber("abc"));
    }

    @Test
    void givenEmptyStringShouldReturnFalse() {
        Assertions.assertFalse(StringUtil.isNumber(""));
    }

    @Test
    void givenNullShouldReturnFalse() {
        Assertions.assertFalse(StringUtil.isNumber(null));
    }
}
