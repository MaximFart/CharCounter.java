package com.foxminded.service.counter;

import com.foxminded.service.cache.CharCounterCache;

import java.util.HashMap;

public class CharCounter {

     public CharCounterCache cache;
     private final HashMap<Character, Integer> charCounter;

    public CharCounter() {
        this.charCounter = new HashMap<>();
    }

    public CharCounter(CharCounterCache cache) {
        this.cache = cache;
        this.charCounter = new HashMap<>();

    }

    public HashMap<Character, Integer> readingCharacters(String inputLine) {
        if (cache.isCached(inputLine)) {
            return cache.get(inputLine);
        } else {
            return countingCharacters(inputLine);
        }
    }

    public HashMap<Character, Integer> countingCharacters(String inputLine) {
        char[] charArray = inputLine.toCharArray();
        int defaultValue = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (!charCounter.containsKey(charArray[i])) {
                charCounter.put(charArray[i], defaultValue);
                cache.put(inputLine, charArray[i], defaultValue);
            } else {
               charCounter.put(charArray[i], charCounter.get(charArray[i]) + 1);
               cache.put(inputLine, charArray[i], charCounter.get(charArray[i]));
            }
        }
        return charCounter;
    }
}
