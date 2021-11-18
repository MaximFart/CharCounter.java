package com.foxminded.service;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter(new CharCounterCache());
        System.out.println(charCounter.readingCharacters("hello"));
        System.out.println(charCounter.readingCharacters("mp"));
        System.out.println(charCounter.readingCharacters("hello"));
        System.out.println(charCounter.readingCharacters("mp"));
        System.out.println(charCounter.readingCharacters("hello"));
        System.out.println(charCounter.readingCharacters("mapping"));
        System.out.println(charCounter.readingCharacters("kkkk"));
        System.out.println(charCounter.readingCharacters("mapping"));

    }
}
