package com.foxminded.service.counter;

import com.foxminded.service.cache.CharCounterCache;

import java.util.HashMap;

public class CountingCharacters {
    private final CharCounterCache cache;
    private final HashMap<Character, Integer> charCounter;

    public CountingCharacters(CharCounterCache cache) {
        this.cache = cache;
        this.charCounter = new HashMap<>();
    }

    public HashMap<Character, Integer> countingCharacters(String inputLine) {
        charCounter.clear();
        char[] charArray = inputLine.toCharArray();
        int defaultValue = 1;
        cache.getCache().put(inputLine, new HashMap<>());
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
