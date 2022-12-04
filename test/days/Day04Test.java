package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day04Test {

    String exampleInput;
    String realInput;
    Day04 day04 = new Day04();

    Day04Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day04/Day04ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day04/Day04RealInput.txt");
    }

    @Test
    void testGetCountOfEntireOverlapsExampleInput() {
        assertEquals(2, day04.getCountOfEntireOverlaps(exampleInput));
    }

    @Test
    void testGetCountOfEntireOverlapsRealInput() {
        assertEquals(532, day04.getCountOfEntireOverlaps(realInput));
    }

    @Test
    void testGetCountOfAllOverlapsExampleInput() {
        assertEquals(4, day04.getCountOfAllOverlaps(exampleInput));
    }

    @Test
    void testGetCountOfAllOverlapsRealInput() {
        assertEquals(854, day04.getCountOfAllOverlaps(realInput));
    }
}