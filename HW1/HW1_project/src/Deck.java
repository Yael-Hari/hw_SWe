import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public List<Card> deck = new ArrayList<>();
    private boolean fillDeck;

    public Deck(boolean fillDeck) {
        /**builder*/
        if (fillDeck) { createDeck(); }
    }

    public List<Card> getDeck() {
        /** return arrayList of cards */
        return deck;
    }

    private void createDeck(){
        /** this method fills this.deck with all cards (no jokers) */
        for(Shape shape : Shape.values()) {
            for (int i = 1; i <= 13; i++) {
                this.deck.add(new Card(i, shape.ordinal()));
            }
        }
    }

    public void addCard(Card card) {
        /** add card to the end of the cards list */
        this.deck.add(card);
    }

    public Card removeTopCard() {
        /** pops the last card from this.deck.
         * @ return poped card
         */
        int deckLength = this.deck.size();
        Card toRemoveCard = this.deck.get(deckLength - 1);
        this.deck.remove(deckLength - 1);
        return toRemoveCard;
    }

    public void addAllCards(Deck other1, Deck other2) {
        /** adding the cards from decks other1 and other2 to this.deck.
         * @ params other1, other2 decks from witch to add cards to this.deck
         */
        // make of cards to add
        int otherLen = other1.getDeck().size();
        List<Card> tempDeck = new ArrayList<>();
        for (int i = 0; i < otherLen; i++) {
            tempDeck.add(other2.removeTopCard());
            tempDeck.add(other1.removeTopCard());
        }
        Collections.reverse(tempDeck);

        // add cards to this.deck
        int tempDeckLen = tempDeck.size();
        for (int i = tempDeckLen - 1; i >= 0; i--) {
            this.addCard(tempDeck.get(i));
        }

    }

    public boolean isEmpty() {
        /** returns true if this.deck is empty */
        return this.deck.size() == 0;
    }

    public void shuffle() {
        /** shuffles this.deck */
        for (int i = 0; i < 50; i++) {
            // picking 2 indexes randomly
            int index1 = Main.rnd.nextInt(this.deck.size());
            int index2 = Main.rnd.nextInt(this.deck.size());

            //swap
            Card temp = this.deck.get(index1);
            this.deck.set(index1, this.deck.get(index2));
            this.deck.set(index2, temp);
        }
    }
}
