package com.foxminded.service;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter(new CharCounterCache());
        HashMap<Character, Integer> map =  charCounter.readingCharacters("hello");
        System.out.println(map);
    }
}
