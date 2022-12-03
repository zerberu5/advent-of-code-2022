package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day03Test {

    String exampleInput;
    String realInput;
    Day03 day03 = new Day03();

    Day03Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day03/Day03ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day03/Day03RealInput.txt");
    }

    @Test
    void testCalculateSumOfPrioritiesExample() {
        assertEquals(157, day03.calculateSumOfPriorities(exampleInput));
    }

    @Test
    void testCalculateSumOfPrioritiesReal() {
        assertEquals(7990, day03.calculateSumOfPriorities(realInput));
    }

    @Test
    void calculateSumOfElvesGroupPrioritiesExample() {
        assertEquals(70, day03.calculateSumOfElvesGroupPriorities(exampleInput));
    }

    @Test
    void calculateSumOfElvesGroupPrioritiesInput() {
        assertEquals(2602, day03.calculateSumOfElvesGroupPriorities(realInput));
    }
}