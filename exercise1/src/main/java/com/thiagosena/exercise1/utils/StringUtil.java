package com.thiagosena.exercise1.utils;

public interface StringUtil {

    static boolean isNumber(final String str) {
        if (isEmpty(str)) {
            return false;
        }
        final int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }
}
