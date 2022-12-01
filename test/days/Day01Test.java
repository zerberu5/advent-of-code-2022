package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {

    String exampleInput;
    String realInput;

    Day01Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day01/Day01ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day01/Day01RealInput.txt");
    }

    @Test
    void testGetCaloriesOfFattestElfExampleInput() {
        assertEquals(24000, Day01.getCaloriesOfFattestElf(exampleInput));

    }

    @Test
    void testGetCaloriesOfFattestElfRealInput() {
        assertEquals(70374, Day01.getCaloriesOfFattestElf(realInput));
    }

    @Test
    void testGetCaloriesOfThreeFattestElfExample() {
        assertEquals(45000, Day01.getCaloriesOfThreeFattestElves(exampleInput));
    }

    @Test
    void testGetCaloriesOfThreeFattestElvesRealInput() {
        assertEquals(204610, Day01.getCaloriesOfThreeFattestElves(realInput));
    }
}