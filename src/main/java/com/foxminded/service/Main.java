package com.foxminded.service;

public class Main {
    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter(new CharCounterCache());
        Formatter format = new Formatter(charCounter);
        format.formattingOutput(null);
        format.formattingOutput("Hello world!");
        format.formattingOutput("Makaronisa");
    }
}
