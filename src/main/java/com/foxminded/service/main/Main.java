package com.foxminded.service.main;

import com.foxminded.service.cache.CharCounterCache;
import com.foxminded.service.counter.CharCounter;
import com.foxminded.service.formatter.Formatter;

public class Main {
    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter(new CharCounterCache());
        Formatter format = new Formatter(charCounter);
        System.out.println(format.formattingOutput("Hello world!"));
    }
}
