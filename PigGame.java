import java.util.Scanner;
public class PigGame {
    
    static int playerTotal, computerTotal, playerRoll, computerRoll, again;
    static PairOfDice twoDice;
    static boolean rollAgain;
    static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        twoDice = new PairOfDice();
        pln("Welcome to the Pig Dice Game!");
        while(playerTotal < 100 && computerTotal < 100) {
            player();
            displayTotalPoints();
            pln("------------------------------------------");
            computer();
            displayTotalPoints();
            pln("------------------------------------------");
        }

        if(playerTotal >= 100) {
            pln("***PLAYER WINS!***");
        } else {
            pln("***COMPUTER WINS!***");
        }

    }

    public static void player() {
        rollAgain = true;
        pln("Player: ");
        while(rollAgain) {
            twoDice.rollDice();
            twoDice.displayRoll();
            if(twoDice.isHalfSnakeEyes()) {
                playerRoll = 0;
                rollAgain = false;
                pln("");
            } else if (twoDice.isSnakeEyes()) {
                playerTotal = 0;
                playerRoll = 0;
                rollAgain = false;
                pln("");
            } else {
                playerRoll += twoDice.sumRoll();
                pln("Continue Turn : 1, End Turn: 0");
                again = scn.nextInt();
                if (again == 1) {
                    rollAgain = true;
                } else {
                    playerTotal += playerRoll;
                    playerRoll = 0;
                    rollAgain = false;
                    pln("");
                }
            }
        }
    }

    public static void computer() {
        pln("");
        rollAgain = true;
        pln("Computer: ");
        while (rollAgain) {
            twoDice.rollDice();
            twoDice.displayRoll();
            if(twoDice.isHalfSnakeEyes()) {
                computerRoll = 0;
                rollAgain = false;
                pln("");
            } else if (twoDice.isSnakeEyes()) {
                computerRoll = 0;
                computerTotal = 0;
                rollAgain = false;
                pln("");
            } else {
                computerRoll += twoDice.sumRoll();
                if(computerRoll >= 20) {
                    computerTotal += computerRoll;
                    computerRoll = 0;
                    rollAgain = false;
                    pln("");
                }
            }
        }
    }

    public  static void displayTotalPoints() {
        pln("Player Total: " + playerTotal + "\tComputer Total: " + computerTotal);
    }

    public static void pln(String s) {
        System.out.println(s);
    }

    public static void p(String s) {
        System.out.print(s);
    }
}