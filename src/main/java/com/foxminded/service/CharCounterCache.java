package com.foxminded.service;

import java.util.HashMap;

public class CharCounterCache implements ICharCounterCache {
    private HashMap<Character, Integer> charactersMap;

    public CharCounterCache() {
        this.charactersMap = new HashMap<>();
    }

    @Override
    public boolean isCached(String string) {
        if (charactersMap.isEmpty()) {
            return false;
        }
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            if (charactersMap.containsKey(c)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void put(String string) {
        char[] charArray = string.toCharArray();
        int defaultValue = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (!charactersMap.containsKey(charArray[i])) {
                charactersMap.put(charArray[i], defaultValue);
            } else {
                charactersMap.put(charArray[i], charactersMap.get(charArray[i]) + 1);
            }
        }
    }

    @Override
    public Integer getMap(Character key) {
        return charactersMap.get(key);
    }
}
