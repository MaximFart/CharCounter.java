package com.foxminded.service.cache;

import java.util.HashMap;

public class CharCounterCache implements ICharCounterCache {

    private final HashMap<String, HashMap<Character, Integer>> cache;

    public CharCounterCache() {
        this.cache = new HashMap<>();
    }

    @Override
    public boolean isCached(String inputLine) {
        return cache.containsKey(inputLine);
    }

    @Override
    public void put(String inputLine, Character key, Integer value) {
        if (!cache.containsKey(inputLine)) {
            cache.put(inputLine, new HashMap<>());
        }
        cache.get(inputLine).put(key, value);

    }

    @Override
    public HashMap<Character, Integer> get(String inputLine) {
        return cache.get(inputLine);
    }
}
