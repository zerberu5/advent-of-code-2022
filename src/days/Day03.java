package days;

import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public int calculateSumOfElvesGroupPriorities(String input) {
        List<String> groups = divideElvesInGroups(input);

        int sum = 0;
        for (String group : groups) {
            String[] elves = group.split("\n");
            Character duplicate = extractDuplicate(elves[0], elves[1], elves[2]);
            if (Character.isLowerCase(duplicate)) {
                sum += duplicate - 96;
            } else {
                sum += duplicate - 38;
            }
        }
        return sum;
    }

    private Character extractDuplicate(String firstElf, String secondElf, String thirdElf) {
        for (int i = 0; i < firstElf.length(); i++) {
            for (int j = 0; j < secondElf.length(); j++) {
                for (int k = 0; k < thirdElf.length(); k++) {
                    if (firstElf.charAt(i) == secondElf.charAt(j) && thirdElf.charAt(k) == firstElf.charAt(i)) {
                        return firstElf.charAt(i);
                    }
                }
            }
        }
        return null;
    }

    private List<String> divideElvesInGroups(String input) {
        String[] elves = input.split("\n");
        List<String> groups = new ArrayList<>();
        for (int i = 0; i < elves.length - 2; i = i + 3) {
            String group = elves[i] + "\n" + elves[i + 1] + "\n" + elves[i + 2];
            groups.add(group);
        }
        return groups;
    }

    public int calculateSumOfPriorities(String input) {
        String[] rucksacks = input.split("\n");

        int sum = 0;
        for (String rucksack : rucksacks) {
            String firstCompartment = rucksack.substring(0, rucksack.length() / 2);
            String secondCompartment = rucksack.substring(rucksack.length() / 2);
            Character duplicate = extractDuplicate(firstCompartment, secondCompartment);
            if (Character.isLowerCase(duplicate)) {
                sum += duplicate - 96;
            } else {
                sum += duplicate - 38;
            }
        }
        return sum;
    }

    private Character extractDuplicate(String firstCompartment, String secondCompartment) {
        for (int i = 0; i < firstCompartment.length(); i++) {
            for (int j = 0; j < secondCompartment.length(); j++) {
                if (firstCompartment.charAt(i) == secondCompartment.charAt(j)) {
                    return firstCompartment.charAt(i);
                }
            }
        }
        return null;
    }
}
