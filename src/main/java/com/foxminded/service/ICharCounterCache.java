package com.foxminded.service;

import java.util.HashMap;

public interface ICharCounterCache {

    public boolean isCached(String string);
    public Integer getMap(Character key);
    public void put(String string);

}
