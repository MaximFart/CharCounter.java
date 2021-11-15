package com.foxminded.service;

import java.util.HashMap;

public interface ICharCounterCache {

    public void checkResult();
    public void getMap();
    public HashMap<Character, Integer> setMap(HashMap<Character, Integer> map);
}
