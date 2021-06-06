import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    public List<Card> deck = new ArrayList<Card>();
    private boolean fillDeck;

    public Deck(boolean fillDeck) {
        if (fillDeck) { createDeck(); }
    }

    public List<Card> getDeck() {
        return deck;
    }

    /* create cards */
    public enum Shape {
        Spades,
        Diamonds,
        Clubs,
        Hearts
    }

    private void createDeck(){
        for(Shape shape : Shape.values()) {
            for (int i = 1; i <= 13; i++) {
                this.deck.add(new Card(i, shape.ordinal()));
            }
        }
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

    public Card removeTopCard() {
        int deckLength = this.deck.size();
        Card toRemoveCard = this.deck.get(deckLength - 1);
        this.deck.remove(deckLength - 1);
        return toRemoveCard;
    }

    public void addAllCards(Deck other) {
        int otherLen = other.getDeck().size();
        for (int i = 0; i<otherLen; i++) {
            this.deck.add(other.removeTopCard());
        }
    }

    public boolean isEmpty() {
        if (this.deck.size() == 0) { return true; }
        else { return false; }
    }

    public void shuffle() {
        for (int i = 0; i < 50; i++) {
            Main.rnd = new Random();
            int index1 = Main.rnd.nextInt();
            int index2 = Main.rnd.nextInt();

            Card temp = this.deck.get(index1);
            this.deck.set(index1, this.deck.get(index2));
            this.deck.set(index2, temp);
        }
    }
}
