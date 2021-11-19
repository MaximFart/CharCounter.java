package com.foxminded.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    private Formatter formatter = new Formatter();

    @Test
    void formattingOutputTest_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> formatter.formattingOutput(null));
    }
}