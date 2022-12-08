package days;

public class Day08 {

    public int countVisibleTrees(String input) {
        int[][] grid = createGrid(input);
        int count = (grid.length * 4) - 4;

        for (int row = 1; row < grid.length - 1; row++) {
            for (int column = 1; column < grid[row].length - 1; column++) {
                Tree tree = new Tree(row, column, grid[row][column]);
                if (isToLeftGridSmaller(tree, grid) || isToRightGridSmaller(tree, grid) || isToLowerGridSmaller(tree, grid) || isToUpperGridSmaller(tree, grid))
                    count++;
            }
        }
        return count;
    }

    public int calcHighestScenicScore(String input) {
        int[][] grid = createGrid(input);
        int maxScenicScore = 0;

        for (int row = 0; row < grid.length - 1; row++) {
            for (int column = 0; column < grid[row].length - 1; column++) {
                Tree tree = new Tree(row, column, grid[row][column]);
                int currentScenicScore = 1;
                currentScenicScore *= scenicScoreLeft(tree, grid);
                currentScenicScore *= scenicScoreRight(tree, grid);
                currentScenicScore *= scenicScoreUp(tree, grid);
                currentScenicScore *= scenicScoreDown(tree, grid);

                if (currentScenicScore > maxScenicScore) {
                    maxScenicScore = currentScenicScore;
                }

            }
        }
        return maxScenicScore;
    }

    private int scenicScoreLeft(Tree tree, int[][] grid) {
        int count = 0;
        for (int i = tree.column - 1; i >= 0; i--) {
            if (tree.height <= grid[tree.row][i]) {
                count++;
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    private int scenicScoreRight(Tree tree, int[][] grid) {
        int count = 0;

        for (int i = tree.column + 1; i < grid[tree.row].length; i++) {
            if (tree.height <= grid[tree.row][i]) {
                count++;
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    private int scenicScoreUp(Tree tree, int[][] grid) {
        int count = 0;

        for (int i = tree.row - 1; i >= 0; i--) {
            if (tree.height <= grid[i][tree.column]) {
                count++;
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    private int scenicScoreDown(Tree tree, int[][] grid) {
        int count = 0;
        for (int i = tree.row + 1; i < grid.length; i++) {
            if (tree.height <= grid[i][tree.column]) {
                count++;
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    private boolean isToLeftGridSmaller(Tree tree, int[][] grid) {
        for (int i = tree.column - 1; i >= 0; i--) {
            if (tree.height <= grid[tree.row][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isToRightGridSmaller(Tree tree, int[][] grid) {
        for (int i = tree.column + 1; i < grid[tree.row].length; i++) {
            if (tree.height <= grid[tree.row][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isToLowerGridSmaller(Tree tree, int[][] grid) {
        for (int i = tree.row + 1; i < grid.length; i++) {
            if (tree.height <= grid[i][tree.column]) {
                return false;
            }
        }
        return true;
    }

    private boolean isToUpperGridSmaller(Tree tree, int[][] grid) {
        for (int i = tree.row - 1; i >= 0; i--) {
            if (tree.height <= grid[i][tree.column]) {
                return false;
            }
        }
        return true;
    }

    private int[][] createGrid(String input) {
        String[] rows = input.split("\n");
        int[][] grid = new int[rows.length][];
        int rowCount = 0;
        for (String row : rows) {
            int[] rowHeights = new int[rows.length];
            int treeCount = 0;
            for (char tree : row.toCharArray()) {
                rowHeights[treeCount] = tree - 48;
                treeCount++;
            }
            grid[rowCount] = rowHeights;
            rowCount++;
        }
        return grid;
    }

    static class Tree {
        int row;
        int column;
        int height;

        public Tree(int row, int column, int height) {
            this.row = row;
            this.column = column;
            this.height = height;
        }
    }
}
