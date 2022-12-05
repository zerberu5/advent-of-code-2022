package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day05 {

    public String getTopOfStacksByOldCrane(String input) {
        String[] inputSplitted = input.split("\n\n");
        List<Stack<Character>> stacks = getInitialStacks(inputSplitted[0]);
        List<Instruction> instructions = loadInstructions(inputSplitted[1]);
        moveStacksByInstructionsOfOldCrane(stacks, instructions);

        StringBuilder topOfStrings = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            topOfStrings.append(stack.lastElement());
        }

        return topOfStrings.toString();
    }

    private void moveStacksByInstructionsOfOldCrane(List<Stack<Character>> stacks, List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            List<Character> crateIntermediary = new ArrayList<>();
            for (int i = 0; i < instruction.count; i++) {
                Character crate = stacks.get(instruction.source - 1).pop();
                crateIntermediary.add(crate);
            }

            for (Character crate : crateIntermediary) {
                stacks.get(instruction.target - 1).push(crate);
            }
        }
    }

    public String getTopOfStacksByNewCrane(String input) {
        String[] inputSplitted = input.split("\n\n");
        List<Stack<Character>> stacks = getInitialStacks(inputSplitted[0]);
        List<Instruction> instructions = loadInstructions(inputSplitted[1]);
        moveStacksByInstructionsOfNewCrane(stacks, instructions);

        StringBuilder topOfStrings = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            topOfStrings.append(stack.lastElement());
        }

        return topOfStrings.toString();
    }

    private void moveStacksByInstructionsOfNewCrane(List<Stack<Character>> stacks, List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            List<Character> crateIntermediary = new ArrayList<>();
            for (int i = 0; i < instruction.count; i++) {
                Character crate = stacks.get(instruction.source - 1).pop();
                crateIntermediary.add(crate);
            }

            // sloppy, but for the sake of it
            Collections.reverse(crateIntermediary);

            for (Character crate : crateIntermediary) {
                stacks.get(instruction.target - 1).push(crate);
            }
        }
    }

    private List<Instruction> loadInstructions(String instructionsRaw) {
        String[] instructionLines = instructionsRaw.split("\n");

        List<Instruction> instructions = new ArrayList<>();
        for (String instructionLine : instructionLines) {
            String[] instructionSplitted = instructionLine.split(" ");
            int count = Integer.parseInt(instructionSplitted[1]);
            int source = Integer.parseInt(instructionSplitted[3]);
            int target = Integer.parseInt(instructionSplitted[5]);
            instructions.add(new Instruction(count, source, target));
        }

        return instructions;
    }

    private List<Stack<Character>> getInitialStacks(String stacksRaw) {
        // works only for count of stack from 0-9
        int stackCount = Character.getNumericValue(stacksRaw.charAt(stacksRaw.length() - 1));

        List<Stack<Character>> initialStacks = getEmptyStacks(stackCount);

        int stackPointer = 0;
        for (int i = 1; i < stacksRaw.length(); i = i + 4) {
            char crate = stacksRaw.charAt(i);
            if (Character.isDigit(crate)) {
                initialStacks.forEach(Collections::reverse);
                return initialStacks;
            }
            if (crate != ' ') {
                initialStacks.get(stackPointer).add(crate);
            }
            if (stackPointer == stackCount - 1 || stacksRaw.charAt(i + 2) == '\n') {
                stackPointer = 0;
                continue;
            }
            stackPointer++;

        }

        return initialStacks;
    }

    private List<Stack<Character>> getEmptyStacks(int stackCount) {
        List<Stack<Character>> emptyStacks = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            emptyStacks.add(new Stack<>());
        }
        return emptyStacks;
    }

    class Instruction {

        public Instruction(int count, int source, int target) {
            this.count = count;
            this.source = source;
            this.target = target;
        }

        private int count;
        private int source;
        private int target;
    }
}
