import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    public List<Card> deck = new ArrayList<>();
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

    public void addAllCards(Deck other1, Deck other2) {
        int otherLen = other1.getDeck().size();
        List<Card> tempDeck = new ArrayList<>();
        for (int i = 0; i < otherLen; i++) {
            tempDeck.add(other2.removeTopCard());
            tempDeck.add(other1.removeTopCard());
        }
        Collections.reverse(tempDeck);

        int tempDeckLen = tempDeck.size();
        for (int i = tempDeckLen - 1; i >= 0; i--) {
            this.addCard(tempDeck.get(i));
        }

    }

    public boolean isEmpty() {
        if (this.deck.size() == 0) { return true; }
        else { return false; }
    }

    public void shuffle() {
        for (int i = 0; i < 50; i++) {
            int index1 = Main.rnd.nextInt(this.deck.size());
            int index2 = Main.rnd.nextInt(this.deck.size());

            Card temp = this.deck.get(index1);
            this.deck.set(index1, this.deck.get(index2));
            this.deck.set(index2, temp);
        }
    }
}
