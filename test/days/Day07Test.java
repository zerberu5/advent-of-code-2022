package days;

import org.junit.jupiter.api.Test;
import utils.AocUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {

    String exampleInput;
    String realInput;
    String ownTestInput;
    Day07 day07 = new Day07();

    Day07Test() throws IOException {
        this.exampleInput = AocUtils.readFile("test/resources/day07/Day07ExampleInput.txt");
        this.realInput = AocUtils.readFile("test/resources/day07/Day07RealInput.txt");
        this.ownTestInput = AocUtils.readFile("test/resources/day07/Day07OwnTestInput.txt");
    }

    @Test
    void testGetAllDirsOwnTestInput() {
        assertEquals(95443, day07.sumOfDirectoriesUnder100000(ownTestInput));
    }

    @Test
    void testSumOfDirectoriesUnder100000ExampleInput() {
        assertEquals(95437, day07.sumOfDirectoriesUnder100000(exampleInput));
    }

    @Test
    void testSumOfDirectoriesUnder100000RealInput() {
        assertEquals(1845346, day07.sumOfDirectoriesUnder100000(realInput));
    }

    @Test
    void testGetSmallestDirectorySizeForUpdateExampleInput() {
        assertEquals(24933642, day07.getSmallestDirectorySizeForUpdate(exampleInput));
    }

    @Test
    void testGetSmallestDirectorySizeForUpdateRealInput() {
        assertEquals(3636703, day07.getSmallestDirectorySizeForUpdate(realInput));
    }
}
