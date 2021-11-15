package com.foxminded.service;

import java.util.HashMap;

public class CharCounter {
    public HashMap<Character, Integer> charactersMap;

    public CharCounter() {
        this.charactersMap = new HashMap<>();
    }

    public void readingCharacters(String string) {
        char[] charArray = string.toCharArray();
        int defaultValue = 1;
        for (int i = 0; i < charArray.length; i++) {
            if (!charactersMap.containsKey(charArray[i])) {
                charactersMap.put(charArray[i], defaultValue);
            } else {
                charactersMap.put(charArray[i], charactersMap.get(charArray[i]) + 1);
            }
        }

        System.out.println(charactersMap);
    }
}
