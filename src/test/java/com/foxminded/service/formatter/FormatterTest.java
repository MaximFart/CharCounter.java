package com.foxminded.service.formatter;

import com.foxminded.service.cache.CharCounterCache;
import com.foxminded.service.counter.CharCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {
    private final Formatter formatter = new Formatter(new CharCounter(new CharCounterCache()));
    @Test
    void outputConsole_shouldReturnString_whenHashMapConvertToString() {
        String expected = "Hello world!\n" +
                "\" \" - 1\n" +
                "\"!\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n" +
                "\"e\" - 1\n" +
                "\"w\" - 1\n" +
                "\"H\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n";
        assertEquals(expected, formatter.formattingOutput("Hello world!"));
    }

    @Test
    void process_shouldThrowNullPointerException_whenInputNull() {
        assertThrows(NullPointerException.class, () -> formatter.formattingOutput(null));
    }


}