package com.foxminded.service;

import java.util.HashMap;

public class CharCounterCache implements ICharCounterCache {
    private HashMap<Character, Integer> charactersMap;

    public CharCounterCache() {
        this.charactersMap = new HashMap<>();
    }

    @Override
    public HashMap<Character, Integer> checkResult(String str) {
        if (charactersMap.isEmpty()) {
            return null;
        }
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (charactersMap.containsKey(strArray[i])) {
                continue;
            } else {
                return null;
            }
        }
        return charactersMap;
    }

    @Override
    public HashMap<Character, Integer> getMap() {
        return charactersMap;
    }
}
