import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize dices
        Dice whiteDice1 = new Dice("white");
        Dice whiteDice2 = new Dice("white");
        Dice redDice = new Dice("red");
        Dice yellowDice = new Dice("yellow");
        Dice greenDice = new Dice("green");
        Dice blueDice = new Dice("blue");

        String[] redLine = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "?"};
        String[] yellowLine = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "?"};
        String[] greenLine = new String[] {"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "?"};
        String[] blueLine = new String[] {"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "?"};

        Lines red = new Lines("red", 2, redLine);
        Lines yellow = new Lines("yellow", 2, yellowLine);
        Lines green = new Lines("green", 12, greenLine);
        Lines blue = new Lines("blue", 12, blueLine);

        GameBoard gameBoard = new GameBoard(red, yellow, green, blue);
        boolean game = true;
        int checkNoMoveDone = 0;
        int noMoveCounter = 0;

        while(game) {       //while loop for the game
            gameBoard.printGameBoard(redLine, yellowLine, greenLine, blueLine, noMoveCounter);
            checkNoMoveDone = 0;
            int[] rolledNumbers = roll(whiteDice1, whiteDice2, redDice, yellowDice, greenDice, blueDice);
            System.out.println();

                while (game) {      //while loop for white dices
                    boolean validMove;
                    System.out.println("For which line do you want to use the WHITE dices? red/yellow/green/blue/none");
                    String whichLine = scanner.nextLine().toLowerCase();

                    if (whichLine.equals("red")) {
                        validMove = red.checkValidMove(rolledNumbers[0], rolledNumbers[1], "");
                        if (!validMove) {
                            continue;
                        } else {
                            red.markNumber(rolledNumbers[0], rolledNumbers[1]);                                            // white Dices are always on 0 and 1
                            break;
                        }

                    } else if (whichLine.equals("yellow")) {
                        validMove = yellow.checkValidMove(rolledNumbers[0], rolledNumbers[1], "");
                        if (!validMove) {
                            continue;
                        } else {
                            yellow.markNumber(rolledNumbers[0], rolledNumbers[1]);                                            // white Dices are always on 0 and 1
                            break;
                        }

                    } else if (whichLine.equals("green")) {
                        validMove = green.checkValidMove(rolledNumbers[0], rolledNumbers[1], "");
                        if (!validMove) {
                            continue;
                        } else {
                            green.markNumber(rolledNumbers[0], rolledNumbers[1]);                                            // white Dices are always on 0 and 1
                            break;
                        }

                    } else if (whichLine.equals("blue")) {
                        validMove = blue.checkValidMove(rolledNumbers[0], rolledNumbers[1], "");
                        if (!validMove) {
                            continue;
                        } else {
                            blue.markNumber(rolledNumbers[0], rolledNumbers[1]);                                            // white Dices are always on 0 and 1
                            break;
                        }

                    } else if (whichLine.equals("none")) {
                        checkNoMoveDone += 1;
                        break;

                    } else {
                        System.out.println("Please choose a valid colour.");
                        continue;
                    }
                }
            game = checkGame(redLine, yellowLine, greenLine, blueLine, noMoveCounter);
            if (!game) {
                break;
            }
            gameBoard.printGameBoard(redLine, yellowLine, greenLine, blueLine, noMoveCounter);
            System.out.println();
            System.out.println("Now you can choose a combination of one white dice and one COLORED dice.");

            while (game) {                                                                                              //while loop for colored dice
                boolean validMove;
                int whichDice = 0;
                System.out.println("For which line do you want to use the dices? red/yellow/green/blue/none");
                String whichLine = scanner.nextLine().toLowerCase();
                if (whichLine.equals("red")) {
                    whichDiceMessage();                                                                              // asks the user which white dice he wants to use
                    whichDice = Integer.valueOf(scanner.nextLine());
                    validMove = red.checkValidMove(rolledNumbers[0], rolledNumbers[1], rolledNumbers[2], whichDice);
                    if (!validMove) {
                        continue;
                    }

                    if (whichDice == 1) {
                        red.markNumber(rolledNumbers[0], rolledNumbers[2]);
                        break;
                    } else if (whichDice == 2) {
                        red.markNumber(rolledNumbers[1], rolledNumbers[2]);
                        break;
                    } else {
                        System.out.println("Please choose a valid option (1 or 2)");
                        continue;
                    }

                } else if (whichLine.equals("yellow")) {
                    whichDiceMessage();                                                                              // asks the user which white dice he wants to use
                    whichDice = Integer.valueOf(scanner.nextLine());
                    validMove = yellow.checkValidMove(rolledNumbers[0], rolledNumbers[1], rolledNumbers[3], whichDice);
                    if (!validMove) {
                        continue;
                    }

                    if (whichDice == 1) {
                        yellow.markNumber(rolledNumbers[0], rolledNumbers[3]);
                        break;
                    } else if (whichDice == 2) {
                        yellow.markNumber(rolledNumbers[1], rolledNumbers[3]);
                        break;
                    } else {
                        System.out.println("Please choose a valid option (1 or 2)");
                        continue;
                    }

                } else if (whichLine.equals("green")) {
                    whichDiceMessage();                                                                              // asks the user which white dice he wants to use
                    whichDice = Integer.valueOf(scanner.nextLine());
                    validMove = green.checkValidMove(rolledNumbers[0], rolledNumbers[1], rolledNumbers[4], whichDice);
                    if (!validMove) {
                        continue;
                    }

                    if (whichDice == 1) {
                        green.markNumber(rolledNumbers[0], rolledNumbers[4]);
                        break;
                    } else if (whichDice == 2) {
                        green.markNumber(rolledNumbers[1], rolledNumbers[4]);
                        break;
                    } else {
                        System.out.println("Please choose a valid option (1 or 2)");
                        continue;
                    }

                } else if (whichLine.equals("blue")) {
                    whichDiceMessage();                                                                              // asks the user which white dice he wants to use
                    whichDice = Integer.valueOf(scanner.nextLine());
                    validMove = blue.checkValidMove(rolledNumbers[0], rolledNumbers[1], rolledNumbers[5], whichDice);
                    if (!validMove) {
                        continue;
                    }

                    if (whichDice == 1) {
                        blue.markNumber(rolledNumbers[0], rolledNumbers[5]);
                        break;
                    } else if (whichDice == 2) {
                        blue.markNumber(rolledNumbers[1], rolledNumbers[5]);
                        break;
                    } else {
                        System.out.println("Please choose a valid option (1 or 2)");
                        continue;
                    }

                } else if (whichLine.equals("none")) {
                    checkNoMoveDone += 1;
                    break;

                } else {
                    System.out.println("Please choose a valid colour.");
                    continue;
                }
            }
            if (checkNoMoveDone == 2) {
               noMoveCounter++;
            }
            game = checkGame(redLine, yellowLine, greenLine, blueLine, noMoveCounter);
        }
        System.out.println("The game is now over. Please check your points.");
        System.out.println();
        gameBoard.printGameBoard(redLine, yellowLine, greenLine, blueLine, noMoveCounter);
        gameBoard.finalScore(redLine, yellowLine, greenLine, blueLine, noMoveCounter);
    }

    public static int[] roll(Dice whiteDice1, Dice whiteDice2, Dice redDice, Dice yellowDice, Dice greenDice, Dice blueDice) {

        int[] rolledNumbers = new int[] {whiteDice1.roll(), whiteDice2.roll(), redDice.roll(), yellowDice.roll(), greenDice.roll(), blueDice.roll()};
        String[] colours = new String[] {"white dice: ", "white dice: ", "red dice: ", "yellow dice: ", "green dice: ", "blue dice: "};

        System.out.println();
        System.out.println("white dice: " + rolledNumbers[0]);
        System.out.println("white dice: " + rolledNumbers[1]);
        System.out.println("The white dices have a combined value of " + (rolledNumbers[0] + rolledNumbers[1]));
        System.out.println();

        for (int i = 2; i < rolledNumbers.length; i++) {
            System.out.print(colours[i] + rolledNumbers[i]);
            System.out.print(" - Possible combinations: " + (rolledNumbers[0] + rolledNumbers[i]) + " or " + (rolledNumbers[1] + rolledNumbers[i]));
            System.out.println();
        }

        return rolledNumbers;
    }

    public static boolean checkGame(String[] redLine, String[] yellowLine, String[] greenLine, String[] blueLine, int noMoveCounter) {

        int finishedLines = 0;

        if (noMoveCounter >= 4) {
            return false;
        }

        if (redLine[11].contains("x")) {
            finishedLines++;
        }
        if (yellowLine[11].contains("x")) {
            finishedLines++;
        }
        if (greenLine[11].contains("x")) {
            finishedLines++;
        }
        if (blueLine[11].contains("x")) {
            finishedLines++;
        }

        if (finishedLines >= 2) {
            return false;       //game ends
        }
        return true;
    }

    public static void whichDiceMessage() {
        System.out.println("Which WHITE dice do you want to pick to combine with the colored dice? Write 1 or 2");
    }
}


