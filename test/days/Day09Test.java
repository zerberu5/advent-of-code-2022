package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

public class Day09Test {

    String exampleInput;
    String realInput;
    Day09 day09 = new Day09();

    Day09Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day09/Day09ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day09/Day09RealInput.txt");
    }

    @Test
    void countTailPositionsExampleInput() {
        int expected = 13;
        assertEquals(expected, day09.countTailPositions(exampleInput));
    }

    @Test
    void countTailPositionsRealInput() {
        int expected = 5878;
        assertEquals(expected, day09.countTailPositions(realInput));
    }
}
