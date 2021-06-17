public class Player {
    private String name;
    private Deck selfDeck;
    private Deck winDeck;

    public Player(String name){
        /**builder*/
        this.name = name;
        this.selfDeck = new Deck(false);
        this.winDeck = new Deck(false);
    }

    public String getName() {
        /** return player's name */
        return this.name;
    }

    public Deck getSelfDeck() {
        return this.selfDeck;
    }

    public Deck getWinDeck() {
        return this.winDeck;
    }

    public void setName(String new_name) {
        this.name = new_name;
    }

    public void setSelfDeck(Deck new_self_deck) {
        this.selfDeck = new_self_deck;
    }

    public void setWinDeck(Deck new_win_deck){
        this.winDeck = new_win_deck;
    }

    public void addWinDeck(Card card){
        this.winDeck.addCard(card);
    }

    public void addToSelfDeck(Card card){
        this.selfDeck.addCard(card);
    }

    public Card drawCard(Card card){
        return this.selfDeck.removeTopCard();
    }

    public boolean outOfCards(){
        return this.selfDeck.isEmpty();
    }

    public String toString(){
        return this.name;
    }




}