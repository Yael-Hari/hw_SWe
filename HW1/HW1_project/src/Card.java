public class Card {
    private final int number;
    private final String shape;
    static String[] symbols = {"♠", "♦", "♣", "♥"};
//    static String[] symbols = {"♥", "♠", "♦", "♣"};


    public Card(int number, int shape) {
        /**builder*/
        this.number = number;
        this.shape = symbols[shape];

    }

    public int getNumber() {
        return this.number;
    }

    public String getShape() {
        return this.shape;
    }

    public int compare(Card other) {
        /** comparing 2 cards
         *  @param  other the other card to compare this.card with
         *  @return int representing which ia larger.
         */
        if (this.number > other.getNumber()) {
            return 1;
        } else if (this.number == other.getNumber()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        if (this.number <= 10 && this.number > 1) {
            return this.getNumber() + " of " + this.getShape();
        } else {
            if (this.getNumber() == 1) {
                return "Ace of " + this.getShape();
            }
            if (this.getNumber() == 11) {
                return "Jack of " + this.getShape();
            }
            if (this.getNumber() == 12) {
                return "Queen of " + this.getShape();
            }
            return "King of " + this.getShape();
        }

    }
}
