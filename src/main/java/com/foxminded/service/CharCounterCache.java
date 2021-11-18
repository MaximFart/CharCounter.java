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
    public void put(String string) {
        char[] charArray = string.toCharArray();
        int defaultValue = 1;
        cache.put(string, new HashMap<>());
        for (int i = 0; i < charArray.length; i++) {
            if (!cache.get(string).containsKey(charArray[i])) {
                cache.get(string).put(charArray[i], defaultValue);
            } else {
                cache.get(string).put(charArray[i],cache.get(string).get(charArray[i]) + 1);
            }
        }
    }

    @Override
    public HashMap<Character, Integer> get(String string) {
        return cache.get(string);
    }
}
