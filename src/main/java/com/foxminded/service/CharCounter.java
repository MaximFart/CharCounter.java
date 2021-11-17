package com.foxminded.service;



import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class CharCounter {
     private CharCounterCache cache;
     private HashMap<Character, Integer> charCounter;

    public CharCounter(CharCounterCache cache) {
        this.cache = cache;
        this.charCounter = new HashMap<>();
    }

    public HashMap<Character, Integer> readingCharacters(String string) {
        if (!charCounter.isEmpty()) {
            charCounter.clear();
        }
        HashSet<Character> charsSet = new HashSet<>();
        char[] charsArray = string.toCharArray();
        for (char c : charsArray) {
                charsSet.add(c);
        }
        if (cache.isCached(string)) {
            for (char key : charsSet) {
                charCounter.put(key, cache.getMap(key));
            }
            return charCounter;
        } else {
            cache.put(string);
            for (char key : charsSet) {
                charCounter.put(key, cache.getMap(key));
            }
            return charCounter;
        }
    }
}
