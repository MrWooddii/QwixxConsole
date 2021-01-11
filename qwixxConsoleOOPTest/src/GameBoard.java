import java.util.Arrays;

public class GameBoard {

    private Lines redLine;
    private Lines yellowLine;
    private Lines greenLine;
    private Lines blueLine;

    public GameBoard(Lines redLine, Lines yellowLine, Lines greenLine, Lines blueLine) {

        this.redLine = redLine;
        this.yellowLine = yellowLine;
        this.greenLine = greenLine;
        this.blueLine = blueLine;

    }

    public void printGameBoard(String[] redLine, String[] yellowLine, String[] greenLine, String[] blueLine, int noMoveCounter) {
        System.out.println("Red:    " + Arrays.toString(redLine));
        System.out.println("Yellow: " + Arrays.toString(yellowLine));
        System.out.println("Green:  " + Arrays.toString(greenLine));
        System.out.println("Blue:   " + Arrays.toString(blueLine));
        System.out.println("You have " + noMoveCounter + " out of 4 missthrows.");
    }

    public static void finalScore(String[] redLine, String[] yellowLine, String[] greenLine, String[] blueLine, int noMoveCounter) {

        System.out.println();
        int redPoints = calculatePoints(redLine, noMoveCounter);
        System.out.println("Points for the red line: " + redPoints);

        int yellowPoints = calculatePoints(yellowLine, noMoveCounter);
        System.out.println("Points for the yellow line: " + yellowPoints);

        int greenPoints = calculatePoints(greenLine, noMoveCounter);
        System.out.println("Points for the green line: " + greenPoints);

        int bluePoints = calculatePoints(blueLine, noMoveCounter);
        System.out.println("Points for the blue line: " + bluePoints);

        int minusPoints = noMoveCounter*5;
        System.out.println("You have " + minusPoints + " minus points for " + noMoveCounter + " missthrows.");

        System.out.println("In total you have " + (redPoints + yellowPoints + greenPoints + bluePoints - noMoveCounter*5) + " points.");

    }

    public static int calculatePoints(String[] line, int noMoveCounter) {

        int xCounter = 0;
        int pointsSum = 0;

        for (String num : line) {
            if (num.contains("x")) {
                xCounter++;
            }
        }

        for (int i = 1; i <= xCounter; i++) {
            pointsSum += i;
        }

        return pointsSum;
    }

    public void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }



}

