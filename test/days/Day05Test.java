package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {

    String exampleInput;
    String realInput;
    Day05 day05 = new Day05();

    Day05Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day05/Day05ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day05/Day05RealInput.txt");
    }

    @Test
    void testTopOfStacksByOldCraneExampleInput() {
        assertEquals("CMZ", day05.getTopOfStacksByOldCrane(exampleInput));
    }

    @Test
    void testTopOfStacksByOldCraneRealInput() {
        assertEquals("VQZNJMWTR", day05.getTopOfStacksByOldCrane(realInput));
    }

    @Test
    void testGetTopOfStacksByNewCraneExampleInput() {
        assertEquals("MCD", day05.getTopOfStacksByNewCrane(exampleInput));
    }

    @Test
    void testGetTopOfStacksByNewCraneRealInput() {
        assertEquals("NLCDCLVMQ", day05.getTopOfStacksByNewCrane(realInput));
    }
}
