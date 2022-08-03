package com.thiagosena.exercise1.core;

import com.thiagosena.exercise1.core.messages.MessageCounter;
import com.thiagosena.exercise1.core.messages.rules.MessageCounterDividedByFifteenRule;
import com.thiagosena.exercise1.core.messages.rules.MessageCounterDividedByFiveRule;
import com.thiagosena.exercise1.core.messages.rules.MessageCounterDividedByThreeRule;
import com.thiagosena.exercise1.core.messages.rules.MessageCounterRule;

import java.util.ArrayList;
import java.util.List;

public class VisualNutsCounter {

    private static final List<MessageCounter> messageCounterRules = new ArrayList<>();

    static {
        messageCounterRules.add(new MessageCounterDividedByFifteenRule());
        messageCounterRules.add(new MessageCounterDividedByFiveRule());
        messageCounterRules.add(new MessageCounterDividedByThreeRule());
        messageCounterRules.add(new MessageCounterRule());
    }

    public VisualNutsCounter(Integer counter, Integer finalCounter) {
        for (; counter <= finalCounter; counter++) {
            System.out.println(start(counter));
        }
    }

    public String start(Integer count) {
        return messageCounterRules.stream()
                .filter(messageCounter -> messageCounter.isDivided(count))
                .map(message -> message.print(count))
                .findFirst()
                .orElseThrow();
    }
}
