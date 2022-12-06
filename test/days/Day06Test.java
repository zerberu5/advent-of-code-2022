package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day06Test {

    String realInput;
    Day06 Day06 = new Day06();

    Day06Test() throws IOException {
        this.realInput = AocUtils.readFile("test/resources/day06/Day06RealInput.txt");
    }

    @Test
    void testExtractPacketMarkerIndexExampleInput() {
        assertEquals(7, Day06.extractPacketMarkerIndex("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(5, Day06.extractPacketMarkerIndex("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(6, Day06.extractPacketMarkerIndex("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(10, Day06.extractPacketMarkerIndex("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(11, Day06.extractPacketMarkerIndex("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));

    }

    @Test
    void testExtractPacketMarkerIndexRealInput() {
        assertEquals(1804, Day06.extractPacketMarkerIndex(realInput));
    }

    @Test
    void testExtractPacketMessageIndexExampleInput() {
        assertEquals(19, Day06.extractPacketMessageIndex("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(23, Day06.extractPacketMessageIndex("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(23, Day06.extractPacketMessageIndex("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(29, Day06.extractPacketMessageIndex("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(26, Day06.extractPacketMessageIndex("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));

    }

    @Test
    void testExtractPacketMessageIndexRealInput() {
        assertEquals(2508, Day06.extractPacketMessageIndex(realInput));
    }
}