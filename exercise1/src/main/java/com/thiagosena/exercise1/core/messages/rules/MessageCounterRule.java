package com.thiagosena.exercise1.core.messages.rules;

import com.thiagosena.exercise1.core.messages.MessageCounter;

public class MessageCounterRule implements MessageCounter {
    @Override
    public String print(int counter) {
        return String.valueOf(counter);
    }

    @Override
    public boolean isDivided(int counter) {
        return true;
    }
}
