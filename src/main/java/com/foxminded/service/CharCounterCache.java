package com.foxminded.service;

import java.util.HashMap;

public class CharCounterCache implements ICharCounterCache {
    private HashMap<String, HashMap<Character, Integer>> cache;

    public CharCounterCache() {
        this.cache = new HashMap<>();
    }

    @Override
    public boolean isCached(String string) {
        return cache.containsKey(string);
    }

    @Override
    public void put(String string, Character key, Integer value) {
        if (!cache.containsKey(string)) {
            cache.put(string, new HashMap<>());
        }
        cache.get(string).put(key, value);

    }

    @Override
    public HashMap<Character, Integer> get(String string) {
        return cache.get(string);
    }
}
