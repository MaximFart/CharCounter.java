package com.foxminded.service;

import java.util.Map;

public class Formatter {

    private CharCounter counter;

    public Formatter() {
    }

    public Formatter(CharCounter counter) {
        this.counter = counter;
    }
    public void formattingOutput(String string) {
        if (string == null) {
            throw new NullPointerException("Incorrect input");
        }
        System.out.println(string);
        for (Map.Entry entry : counter.readingCharacters(string).entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"" + " - " + entry.getValue());
        }
    }


}
