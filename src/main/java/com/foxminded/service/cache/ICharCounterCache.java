package com.foxminded.service.cache;

import java.util.HashMap;

public interface ICharCounterCache {

    boolean isCached(String inputLine);
    HashMap<Character, Integer> get(String inputLine);
    HashMap<String, HashMap<Character, Integer>> getCache();
    void put(String inputLine, Character key, Integer value);
}
