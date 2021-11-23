package com.foxminded.service;

import java.util.HashMap;

public class CharCounter {

     private CharCounterCache cache;
     private HashMap<Character, Integer> charCounter;

    public CharCounter() {
        this.charCounter = new HashMap<>();
    }

    public CharCounter(CharCounterCache cache) {
        this.cache = cache;
        this.charCounter = new HashMap<>();

    }

    public HashMap<Character, Integer> readingCharacters(String string) {
        if (!charCounter.isEmpty()) {
            charCounter.clear();
        }
        if (cache.isCached(string)) {
            return cache.get(string);
        } else {
            return countingCharacters(string);
        }
    }

    public HashMap<Character, Integer> countingCharacters(String string) {
        char[] charArray = string.toCharArray();
        int defaultValue = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (!charCounter.containsKey(charArray[i])) {
                charCounter.put(charArray[i], defaultValue);
                cache.put(string, charArray[i], defaultValue);
            } else {
               charCounter.put(charArray[i], charCounter.get(charArray[i]) + 1);
               cache.put(string, charArray[i], charCounter.get(charArray[i]));
            }
        }
        return charCounter;
    }
}
