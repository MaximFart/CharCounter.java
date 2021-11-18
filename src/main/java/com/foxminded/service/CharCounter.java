package com.foxminded.service;



import java.util.HashMap;
import java.util.HashSet;


public class CharCounter {
     private CharCounterCache cache;
     private HashMap<Character, Integer> charCounter;

    public CharCounter(CharCounterCache cache) {
        this.cache = cache;
        this.charCounter = new HashMap<>();
    }

    public HashMap<Character, Integer> readingCharacters(String string) {
        if (cache.isCached(string)) {
            return cache.get(string);
        } else {
            cache.put(string);
            return cache.get(string);
        }
    }
}
