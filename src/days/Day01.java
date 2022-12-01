package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day01 {

    public static int getCaloriesOfFattestElf(String elfCalories) {
        List<Integer> caloriesSums = convertInputToCaloriesSums(elfCalories);
        return Collections.max(caloriesSums);
    }

    public static int getCaloriesOfThreeFattestElves(String elfCalories) {
        List<Integer> caloriesSums = convertInputToCaloriesSums(elfCalories);
        int caloriesCount = 0;
        for (int i = 0; i < 3; i++) {
            int currentMaxCalories = Collections.max(caloriesSums);
            caloriesCount += currentMaxCalories;
            int indexOfFattestElf = caloriesSums.indexOf(currentMaxCalories);
            //noinspection
            caloriesSums.remove(indexOfFattestElf);
        }
        return caloriesCount;
    }

    public static List<Integer> convertInputToCaloriesSums(String inputData) {
        String[] caloriesWithBreak = inputData.split("\n\n");

        List<Integer> calorieSums = new ArrayList<>();
        for (String cals : caloriesWithBreak) {
            calorieSums.add(Arrays.stream(cals.split("\n")).mapToInt(Integer::valueOf).sum());
        }

        return calorieSums;
    }
}
