package com.foxminded.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {
    private CharCounter counter = new CharCounter();
    @Test
    void readingCharactersTest_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> counter.readingCharacters(null));
    }

    @Test
    void countingTest_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> counter.counting(null));
    }
}
