package com.foxminded.service.counter;

import com.foxminded.service.cache.CharCounterCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharCounterTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void stringInHashMap_shouldReturnHashMap_whenInputString(String str, HashMap<Character, Integer> map) {
        CountingCharacters counting = new CountingCharacters(new CharCounterCache());
        CountingCharacters countingMock = mock(CountingCharacters.class);
        when(countingMock.countingCharacters(str)).thenReturn(map);
        assertEquals(countingMock.countingCharacters(str), counting.countingCharacters(str));
    }

    @Test
    void countCharactersInString_shouldUseCache_whenInputIsRepeated() {
        CharCounterCache cacheSpy = spy(new CharCounterCache());
        CharCounter counter = new CharCounter(cacheSpy);
        final int numberOfCalls = 3;

        String inputString = "aa";
        HashMap<Character, Integer>  expectedOutput = new HashMap<>();
        expectedOutput.put('a', 2);

        for(int i = 0; i < numberOfCalls; i++) {
            HashMap<Character, Integer> actual = counter.readingCharacters(inputString);
            assertEquals(expectedOutput, actual);
        }

        verify(cacheSpy, times(1))
                .put(inputString, 'a', 2);

        verify(cacheSpy, times(numberOfCalls))
                .isCached(any());

        verify(cacheSpy, times(numberOfCalls - 1))
                .get(any());
    }

    @Test
    void checkReturnValue_shouldUseCacheValue_whenInputIsRepeated() {
        CharCounterCache cacheMock = mock(CharCounterCache.class);
        CharCounter counter = new CharCounter(cacheMock);
        String str = "Maks";
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1);
        map.put('a', 1);
        map.put('k', 1);
        map.put('s', 1);
        when(cacheMock.isCached(str)).thenReturn(true);
        when(cacheMock.get(str)).thenReturn(map);
        assertEquals(map, counter.readingCharacters(str));
    }

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
}
