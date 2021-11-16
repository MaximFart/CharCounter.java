package com.foxminded.service;

import java.util.HashMap;

public class CharCounter {
     private CharCounterCache cache;

    public CharCounter(CharCounterCache cache) {
        this.cache = cache;
    }

    public HashMap<Character, Integer> readingCharacters(String string) {
        if (cache.checkResult(string) != null) {
            return cache.getMap();
        }
        char[] charArray = string.toCharArray();
        int defaultValue = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (!cache.getMap().containsKey(charArray[i])) {
                cache.getMap().put(charArray[i], defaultValue);
            } else {
                cache.getMap().put(charArray[i], cache.getMap().get(charArray[i]) + 1);
            }
        }

        return cache.getMap();
    }
}
