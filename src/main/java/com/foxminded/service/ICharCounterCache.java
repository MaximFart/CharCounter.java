package com.foxminded.service;

import java.util.HashMap;

public interface ICharCounterCache {

    public boolean isCached(String string);
    public HashMap get(String string);
    public void put(String string, Character key, Integer value);

}
