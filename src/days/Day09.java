package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day09 {

    final String DOT_SYMBOL = ".";
    final RopePart head;
    final RopePart tail;
    final String[][] grid = new String[1000][1000]; // y,x
    final List<Point> visitedPoints;
    List<Direction> directions;

    public Day09() {
        fillGridWithDots(grid);
        this.head = new RopePart("h", 499, 499);
        this.tail = new RopePart("t", 499, 499);
        grid[head.y][head.x] = head.symbol;

        this.visitedPoints = new ArrayList<>();
        // Starting point counts as visited
        visitedPoints.add(new Point(499, 499));
    }

    public int countTailPositions(String input) {

        directions = transformToDirections(input);
        for (Direction direction : directions) {
            if (direction.movesRight()) {
                moveToRight(direction.steps, head, tail);
            } else if (direction.movesLeft()) {
                moveToLeft(direction.steps, head, tail);
            } else if (direction.movesUp()) {
                moveUp(direction.steps, head, tail);
            } else if (direction.movesDown()) {
                moveDown(direction.steps, head, tail);
            }
        }

        return visitedPoints.size();
    }

    private void moveToRight(int steps, RopePart head, RopePart tail) {
        for (int i = 0; i < steps; i++) {
            saveOldHeadCoordinates(head);
            ++head.x;
            moveHeadAndTail(head, tail);
        }
    }

    private void moveToLeft(int steps, RopePart head, RopePart tail) {
        for (int i = 0; i < steps; i++) {
            saveOldHeadCoordinates(head);
            --head.x;
            moveHeadAndTail(head, tail);
        }
    }

    private void moveUp(int steps, RopePart head, RopePart tail) {
        for (int i = 0; i < steps; i++) {
            saveOldHeadCoordinates(head);
            --head.y;
            moveHeadAndTail(head, tail);
        }
    }

    private void moveDown(int steps, RopePart head, RopePart tail) {
        for (int i = 0; i < steps; i++) {
            saveOldHeadCoordinates(head);
            ++head.y;
            moveHeadAndTail(head, tail);
        }
    }

    private void saveOldHeadCoordinates(RopePart head) {
        head.previousX = head.x;
        head.previousY = head.y;
    }

    private void moveHeadAndTail(RopePart head, RopePart tail) {
        setHeadSymbolInGrid(head);

        if (!headCoversTail(head, tail)) {
            grid[tail.y][tail.x] = tail.symbol;
            tail.previousX = tail.x;
            tail.previousY = tail.y;
        }
        if (headCoversTail(head, tail)) {
            return;
        }
        if (!isTailConnectedToHead(tail, head)) {
            setTailStep(head, tail);
        }
    }

    private boolean headCoversTail(RopePart head, RopePart tail) {
        return tail.y == head.y && tail.x == head.x;
    }

    private void setTailStep(RopePart head, RopePart tail) {
        tail.x = head.previousX;
        tail.y = head.previousY;
        grid[tail.y][tail.x] = tail.symbol;
        grid[tail.previousY][tail.previousX] = DOT_SYMBOL;

        Point point = new Point(tail.y, tail.x);

        if (!visitedPoints.contains(point)) {
            visitedPoints.add(point);
        }
    }

    private boolean isTailConnectedToHead(RopePart tail, RopePart head) {
        return leftSideIsConnected(tail, head) || rightSideIsConnected(tail, head) || topIsConnected(tail, head)
                || bottomIsConnected(tail, head);
    }

    private boolean leftSideIsConnected(RopePart tail, RopePart head) {
        // look left
        if (tail.x - 1 >= 0 && (grid[tail.y][tail.x - 1].equals(head.symbol))) {
            return true;
        }

        // look upper left
        if (tail.y - 1 >= 0 && tail.x - 1 >= 0 && (grid[tail.y - 1][tail.x - 1].equals(head.symbol))) {
            return true;
        }

        // look bottom left
        return tail.y + 1 < grid.length && tail.x - 1 >= 0 && (grid[tail.y + 1][tail.x - 1].equals(head.symbol));
    }

    private boolean rightSideIsConnected(RopePart tail, RopePart head) {
        // look right
        if (tail.x + 1 < grid[tail.y].length && (grid[tail.y][tail.x + 1].equals(head.symbol))) {
            return true;
        }

        // look upper right
        if (tail.y - 1 > 0 && tail.x + 1 < grid[tail.y].length && (grid[tail.y - 1][tail.x + 1].equals(head.symbol))) {
            return true;
        }

        // look bottom right
        return tail.y + 1 < grid.length && tail.x + 1 < grid[tail.y].length && (grid[tail.y + 1][tail.x + 1].equals(head.symbol));
    }

    private boolean bottomIsConnected(RopePart tail, RopePart head) {
        // look down
        return tail.y + 1 < grid.length && (grid[tail.y + 1][tail.x].equals(head.symbol));
    }

    private boolean topIsConnected(RopePart tail, RopePart head) {
        // look up
        return tail.y - 1 > 0 && (grid[tail.y - 1][tail.x].equals(head.symbol));
    }

    private void setHeadSymbolInGrid(RopePart head) {
        fillGridWithDots(grid);
        grid[head.y][head.x] = head.symbol;
    }

    private List<Direction> transformToDirections(String input) {
        return Arrays.stream(input.split("\n")).map(jointDirection -> jointDirection.split(" ")).map(splitDirection -> new Direction(splitDirection[0], Integer.parseInt(splitDirection[1]))).toList();
    }

    private void fillGridWithDots(String[][] grid) {
        for (String[] row : grid) {
            Arrays.fill(row, DOT_SYMBOL);
        }
    }

    private void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println();
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    static class RopePart {
        String symbol;
        int x;
        int y;
        int previousX;
        int previousY;

        RopePart(String symbol, int x, int y) {
            this.symbol = symbol;
            this.x = x;
            this.y = y;
        }
    }

    static class Direction {
        String dir;
        int steps;

        Direction(String dir, int steps) {
            this.dir = dir;
            this.steps = steps;
        }

        boolean movesRight() {
            return dir.equals("R");
        }

        boolean movesLeft() {
            return dir.equals("L");
        }

        boolean movesUp() {
            return dir.equals("U");
        }

        boolean movesDown() {
            return dir.equals("D");
        }
    }
}
