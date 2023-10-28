public class PairOfDice {

    private static Die die1;
    private static Die die2;

    public PairOfDice () {
        die1 = new Die();
        die2 = new Die();
    }
    public  void rollDice() {
        die1.roll();
        die2.roll();
    }

    public  int sumRoll() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    public  boolean isSnakeEyes() {
        if (die1.getFaceValue() == 1 && die2.getFaceValue() == 1) {
            pln("SNAKE EYES!");
            return true;
        }
        return false;
    }

    public  boolean isHalfSnakeEyes() {
        if( (die1.getFaceValue() == 1 && die2.getFaceValue() != 1) || (die1.getFaceValue() != 1 && die2.getFaceValue() == 1)) {
            pln("HALF SNAKE EYES!");
            return true;
        }
        return false;
    }

    public  void displayRoll() {
        pln ( "(Die One: " + die1.getFaceValue() + ", Die Two: " + die2.getFaceValue() + ")" );
    }

    public  void pln(String s) {
        System.out.println(s);
    }

}