public class Card {
    private int number;
    private String shape;
    static String[] symbols = {"♥", "♠", "♦", "♣"};


    public Card(int number, int shape) {
        this.number = number;
        this.shape = symbols[shape];

    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }

    public String getShape() {
        return this.shape;
    }

    public void setShape(String newShape) {
        this.shape = newShape;
    }

    public int compare(Card other) {
        if (this.number > other.getNumber()) {
            return 1;
        } else if (this.number == other.getNumber()) {
            return 0;
        } else {
            return -1;
        }
    }

    public String toString() {
        if (this.number <= 10) {
            return this.getNumber() + " of " + this.getShape();
        } else {
            if (this.getNumber() == 11) {
                return "Prince of " + this.getShape();
            }
            if (this.getNumber() == 12) {
                return "Queen of " + this.getShape();
            }
            return "King of " + this.getShape();
        }

    }
}
