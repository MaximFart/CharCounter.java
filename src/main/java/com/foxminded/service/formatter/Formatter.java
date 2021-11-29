package com.foxminded.service.formatter;

import com.foxminded.service.counter.CharCounter;

import java.util.Map;

public class Formatter {

    private final CharCounter counter;

    public Formatter(CharCounter counter) {
        this.counter = counter;
    }

    public String formattingOutput(String inputLine) {
        if (inputLine == null) {
            throw new NullPointerException("Incorrect input");
        }
        StringBuilder output = new StringBuilder();
        output.append(inputLine + "\n");
        for (Map.Entry<Character, Integer> entry : counter.readingCharacters(inputLine).entrySet()) {
            output.append("\"" + entry.getKey() + "\"" + " - " + entry.getValue() + "\n");
        }
        return output.toString();
    }
}
