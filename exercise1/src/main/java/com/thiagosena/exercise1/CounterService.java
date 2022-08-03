package com.thiagosena.exercise1;

import com.thiagosena.exercise1.core.VisualNutsCounter;
import com.thiagosena.exercise1.exceptions.ValidateArgsException;
import com.thiagosena.exercise1.utils.StringUtil;

public interface CounterService {
    static void main(String[] args) throws ValidateArgsException {
        validateArgs(args);
        new VisualNutsCounter(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

    private static void validateArgs(String[] args) throws ValidateArgsException {
        if (args.length != 2) {
            throw new ValidateArgsException(
                    "Please, insert 2 parameters (initialCounter, finalCounter). Ex.: java -jar exercise1.jar 1 100");
        }

        if (!StringUtil.isNumber(args[0]) || !StringUtil.isNumber(args[1])) {
            throw new ValidateArgsException("Please, insert a numeric value. Ex.: java -jar exercise1.jar 1 100");
        }

        if (Integer.parseInt(args[0]) > Integer.parseInt(args[1])) {
            throw new ValidateArgsException(
                    "Sorry, the first number is greater than the second, adjust it so that the greater is the second . Ex.: java -jar exercise1.jar 1 100");
        }
    }
}