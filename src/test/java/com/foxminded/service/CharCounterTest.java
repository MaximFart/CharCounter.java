package com.foxminded.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharCounterTest {
    private final CharCounter counter = new CharCounter(new CharCounterCache());
    private final CharCounter counterMock = mock(CharCounter.class);

    private static Stream<Arguments> parameters() {
        return Stream.of(
             Arguments.of("a a a a a a", new HashMap<Character, Integer>(){{
            put('a', 6);
            put(' ', 5);
        }}), Arguments.of("!@#!@#", new HashMap<Character, Integer>(){{
                    put('!', 2);
                    put('@', 2);
                    put('#', 2);
        }}), Arguments.of("        ", new HashMap<Character, Integer>(){{
                    put(' ', 8);
                }}));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void countingCharactersTest(String str, HashMap<Character, Integer> map) {
        when(counterMock.countingCharacters(str)).thenReturn(map);
        assertEquals(counterMock.countingCharacters(str), counter.countingCharacters(str));
    }
}
