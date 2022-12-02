package days;

import java.util.ArrayList;
import java.util.List;

public class Day02 {

    private final List<Shape> shapes;

    public Day02() {
        this.shapes = setUpShapes();
    }

    public int calculateScore(String outcomes) {
        String[] games = outcomes.split("\n");

        int score = 0;
        for (String game : games) {
            Shape opponent = getDecryptedShape(String.valueOf(game.charAt(0)), "opponent");
            Shape you = getDecryptedShape(String.valueOf(game.charAt(2)), "you");
            score += you.value;

            String result = determineResult(opponent, you);
            switch (result) {
                case "win" -> score += 6;
                case "draw" -> score += 3;
            }
        }
        return score;
    }

    public int calculateScoreByResult(String outcomes) {
        String[] games = outcomes.split("\n");

        int score = 0;
        for (String game : games) {
            Shape opponent = getDecryptedShape(String.valueOf(game.charAt(0)), "opponent");
            Shape you = getShapeByResult(opponent, game.charAt(2));
            score += you.value;

            switch (game.charAt(2)) {
                case 'Y' -> score += 3;
                case 'Z' -> score += 6;
            }
        }
        return score;
    }

    private Shape getShapeByResult(Shape opponent, char result) {
        if (result == 'Y') {
            return opponent;
        } else if (result == 'X') {
            return shapes.stream().filter(shape -> shape.sign.equals(opponent.win)).findFirst().orElseThrow();
        }
        return shapes.stream().filter(shape -> shape.sign.equals(opponent.loss)).findFirst().orElseThrow();
    }

    private String determineResult(Shape opponent, Shape you) {
        if (opponent.sign.equals(you.win)) {
            return "win";
        } else if (opponent.sign.equals(you.loss)) {
            return "loss";
        }
        return "draw";
    }


    private Shape getDecryptedShape(String sign, String player) {
        if (player.equals("you")) {
            return shapes.stream().filter(shape -> sign.equals(shape.youEncrypted)).findFirst().orElseThrow();
        }
        return shapes.stream().filter(shape -> sign.equals(shape.opponentEncrypted)).findFirst().orElseThrow();
    }

    private List<Shape> setUpShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("Rock", "A", "X", "Paper", "Scissors", 1));
        shapes.add(new Shape("Paper", "B", "Y", "Scissors", "Rock", 2));
        shapes.add(new Shape("Scissors", "C", "Z", "Rock", "Paper", 3));
        return shapes;
    }

    class Shape {
        private String sign;
        private String opponentEncrypted;
        private String youEncrypted;
        private String loss;
        private String win;
        private int value;

        public Shape(String sign, String opponentEncrypted, String youEncrypted, String loss, String win, int value) {
            this.sign = sign;
            this.opponentEncrypted = opponentEncrypted;
            this.youEncrypted = youEncrypted;
            this.loss = loss;
            this.win = win;
            this.value = value;
        }
    }
}
