package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    String exampleInput;
    String realInput;
    Day02 day02 = new Day02();

    Day02Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day02/Day02ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day02/Day02RealInput.txt");
    }


    @Test
    void testCalculateScoreExampleInput() {
        assertEquals(15, day02.calculateScore(exampleInput));
    }

    @Test
    void testCalculateScoreRealInput() {
        assertEquals(14297, day02.calculateScore(realInput));
    }

    @Test
    void testCalculateScoreByResultExampleInput() {
        assertEquals(12, day02.calculateScoreByResult(exampleInput));
    }

    @Test
    void testCalculateScoreByResultRealInput() {
        assertEquals(10498, day02.calculateScoreByResult(realInput));
    }
}