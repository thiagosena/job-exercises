package com.thiagosena.exercise1.core.messages.rules;

import com.thiagosena.exercise1.core.messages.MessageCounter;

public class MessageCounterDividedByFifteenRule implements MessageCounter {
    @Override
    public String print(int counter) {
        return "Visual Nuts";
    }

    @Override
    public boolean isDivided(int counter) {
        return (counter % 3) == 0 && (counter % 5) == 0;
    }
}
