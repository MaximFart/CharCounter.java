package com.foxminded.service;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter(new CharCounterCache());
        System.out.println(charCounter.readingCharacters("hello"));
        System.out.println(charCounter.readingCharacters("mapping"));
    }
}
