package com.foxminded.service.cache;

import java.util.HashMap;

public interface ICharCounterCache {

    boolean isCached(String inputLine);
    HashMap get(String inputLine);
    void put(String inputLine, Character key, Integer value);
}
