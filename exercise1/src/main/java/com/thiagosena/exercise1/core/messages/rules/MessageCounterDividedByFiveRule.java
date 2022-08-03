package com.thiagosena.exercise1.core.messages.rules;

import com.thiagosena.exercise1.core.messages.MessageCounter;

public class MessageCounterDividedByFiveRule implements MessageCounter {
    @Override
    public String print(int counter) {
        return "Nuts";
    }

    @Override
    public boolean isDivided(int counter) {
        return (counter % 5) == 0;
    }
}
