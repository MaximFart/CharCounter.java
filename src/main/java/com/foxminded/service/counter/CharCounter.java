package com.foxminded.service.counter;

import com.foxminded.service.cache.CharCounterCache;

import java.util.HashMap;

public class CharCounter {
     private final CharCounterCache cache;
     private final CountingCharacters counting;

    public CharCounter(CharCounterCache cache) {
        this.cache = cache;
        this.counting = new CountingCharacters(cache);

    }

    public HashMap<Character, Integer> readingCharacters(String inputLine) {
        if (cache.isCached(inputLine)) {
            return cache.get(inputLine);
        } else {
            return counting.countingCharacters(inputLine);
        }
    }
}
