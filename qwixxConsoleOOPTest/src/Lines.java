import java.util.Scanner;

public class Lines {

    private String color;
    private int startNumber;
    private String[] line;

    public Lines(String color, int startNumber, String[] line) {

        this.color = color;
        this.startNumber = startNumber;
        this.line = line;

    }

    public void markNumber(int rolledNumberOne, int rolledNumberTwo) {
        for (int i = 0; i < this.line.length; i++) {
            String checkNum = String.valueOf(rolledNumberOne + rolledNumberTwo);

            if (this.line[10].equals(checkNum)) {
                this.line[10] += "x";
            }

            if (this.line[i].contains(checkNum)) {
                if (this.line[i].equals(checkNum)) {
                    this.line[i] += "x";
                }
                break;
            }
        }
        if (this.line[10].contains("x")) {
            this.line[11] += "x";
            System.out.println("This line is now closed. You can´t use this dice further.");
        }

    }

    public boolean checkValidMove(int firstWhiteDice, int secondWhiteDice, String checkNum) {    //checks for a valid move with both white dices

        boolean alreadyMarked = false;
        boolean higherAlreadyMarked = false;

        if(checkNum.equals("")) {
            checkNum = String.valueOf(firstWhiteDice + secondWhiteDice);
        }

        int checkEnd = 0;

        if (checkNum.equals(line[10])) {
            for (int i = 0; i < line.length-1; i++) {
                if (line[i].contains("x")) {
                    checkEnd++;
                }
            }
            if (checkEnd <= 4) {
                System.out.println("You can only mark the last number if you have at least 5 fields marked. You only have " + checkEnd + " marked.");
                return false;
            }
        }

        if (this.line[11].contains("x")) {                                                                              // prüft, ob das ? abgekreuzt wurde. Wenn ja, kann diese Zeile nicht mehr genutzt werden
            System.out.println("This line is closed. You can´t use this line and dice anymore.");
            return false;
        }

        //checks alreadyMarked
        for (int i = 0; i < this.line.length; i++) {

            if (this.line[i].equals(checkNum + "x")) {
                alreadyMarked = true;                                                                                   // When the field is already marked, it is not a valid move
                System.out.println("You already marked this number. Please choose an other line.");
                return false;
            } else if (this.line[i].equals(checkNum)) {
                alreadyMarked = false;
                break;
            }
        }

        //checks higherAlreadyMarked
        for (int i = 0; i < this.line.length; i++) {

            if (this.line[i].equals(checkNum) || this.line[i].equals(checkNum + "x")) {
                for (int j = i; j < this.line.length; j++) {
                    if (this.line[j].contains("x")) {
                        System.out.println("You already marked a higher number. Please choose an other line.");
                        higherAlreadyMarked = true;
                        return false;                                                                                   // a higher number is already marked, therefore the method returns "valid move = false"
                    } else {
                        higherAlreadyMarked = false;
                        continue;
                    }
                }
                return true;
            }
        }
    return true;
    }

    public boolean checkValidMove(int firstWhiteDice, int secondWhiteDice, int coloredDice, int whichDice) {            //check for combination with colored dice

        Scanner scanner = new Scanner(System.in);
        boolean alreadyMarked = false;
        boolean higherAlreadyMarked = false;

        String checkNum;

        while (true) {
            if (whichDice == 1) {
                checkNum = String.valueOf(firstWhiteDice + coloredDice);
                break;
            } else if (whichDice == 2) {
                checkNum = String.valueOf(secondWhiteDice + coloredDice);
                break;
            } else {
                System.out.println("Please pick a valid option (1 or 2)");
            }
        }

        return checkValidMove(firstWhiteDice, secondWhiteDice, checkNum);
    }


    public String getColor() {
        return color;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public String[] getLine() {
        return line;
    }
}
