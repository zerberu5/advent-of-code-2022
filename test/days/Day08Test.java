package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day08Test {

    String exampleInput;
    String realInput;
    Day08 day08 = new Day08();

    Day08Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day08/Day08ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day08/Day08RealInput.txt");
    }

    @Test
    void countVisibleTreesExampleInput() {
        assertEquals(21, day08.countVisibleTrees(exampleInput));
    }

    @Test
    void countVisibleTreesRealInput() {
        assertEquals(1823, day08.countVisibleTrees(realInput));
    }

    @Test
    void calcScenicScoreExampleInput() {
        assertEquals(8, day08.calcHighestScenicScore(exampleInput));
    }

    @Test
    void calcScenicScoreRealInput() {
        assertEquals(211680, day08.calcHighestScenicScore(realInput));
    }
}