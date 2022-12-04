package days;

public class Day04 {

    public int getCountOfEntireOverlaps(String input) {
        int overlapCount = 0;
        for (String group : input.split("\n")) {
            String[] ranges = group.split(",");
            String[] firstRange = ranges[0].split("-");
            String[] secondRange = ranges[1].split("-");

            int startFirst = Integer.parseInt(firstRange[0]);
            int endFirst = Integer.parseInt(firstRange[1]);
            int startSecond = Integer.parseInt(secondRange[0]);
            int endSecond = Integer.parseInt(secondRange[1]);

            if (overlapsEntirely(startFirst, endFirst, startSecond, endSecond)) {
                overlapCount++;
            }
        }
        return overlapCount;
    }

    private boolean overlapsEntirely(int startFirst, int endFirst, int startSecond, int endSecond) {
        return (startFirst >= startSecond && endFirst <= endSecond) || (startSecond >= startFirst) && (endSecond <= endFirst);
    }

    public int getCountOfAllOverlaps(String input) {
        int overlapCount = 0;
        for (String group : input.split("\n")) {
            String[] ranges = group.split(",");
            String[] firstRange = ranges[0].split("-");
            String[] secondRange = ranges[1].split("-");

            int startFirst = Integer.parseInt(firstRange[0]);
            int endFirst = Integer.parseInt(firstRange[1]);
            int startSecond = Integer.parseInt(secondRange[0]);
            int endSecond = Integer.parseInt(secondRange[1]);

            if (overlapsEntirely(startFirst, endFirst, startSecond, endSecond) || overlapsPartially(startFirst, endFirst, startSecond, endSecond)) {
                overlapCount++;
            }
        }
        return overlapCount;
    }

    private boolean overlapsPartially(int startFirst, int endFirst, int startSecond, int endSecond) {
        return startFirst >= startSecond && startFirst <= endSecond || startSecond >= startFirst && startSecond <= endFirst;
    }
}
