import java.util.Arrays;

public class WarGame {
    private Player player1;
    private Player player2;
    private Deck middleDeck1;
    private Deck middleDeck2;


    public WarGame(String name1, String name2){
        /**builder*/
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.middleDeck1 = new Deck(false);
        this.middleDeck2 = new Deck(false);
    }

    public void InitializeGame(){
        /** create main deck and split it between players
         */
        //create main deck and shuffle it
        Deck mainDeck = new Deck(true);
        mainDeck.shuffle();

        sortPlayers(player1, player2);

        //split deck to players:
        while(!mainDeck.isEmpty()) {
            this.player1.addToSelfDeck(mainDeck.removeTopCard());
            this.player2.addToSelfDeck(mainDeck.removeTopCard());
        }
    }

    public void sortPlayers(Player player1, Player player2) {
        /** sort the players' names alphabetically
         * @params player1, player2: players
         */
        String[] names = {player1.getName(), player2.getName()};
        Arrays.sort(names);
        if (names[0].equals(player2.getName())) {
            String temp = player1.getName();
            player1.setName(player2.getName());
            player2.setName(temp);
        }
    }

    String start() {
        /** this func plays the game.
         * @return winner's name
         */
        // Initialize Game
        System.out.println("Initializing the game...");
        InitializeGame();
        String winner;
        int index = 0;

        //start turns
        while (!theresAWinner()) {
            System.out.println("------------------------- Round number " +
                               ++index + " -------------------------");
            boolean warWinner = false;
            int i = 0;

            // if needed switch decks
            reStockSelfDeck();

            // draw cards
            middleDeck1.addCard(player1.getSelfDeck().removeTopCard());
            System.out.println(player1.getName() + " drew " +
                    middleDeck1.getDeck().get(0).toString());
            middleDeck2.addCard(player2.getSelfDeck().removeTopCard());
            System.out.println(player2.getName() + " drew " +
                    middleDeck2.getDeck().get(0).toString());

            //WAR
            while (middleDeck1.getDeck().get(i).compare(middleDeck2.getDeck().get(i)) == 0
                    && !warWinner) {

                System.out.println("Starting a war...");

                // putting out 3 cards for each player
                for (int j = 0; j < 3; j++) {
                    //check if there's a winner
                    if (theresAWinner()) {
                        if (this.player1.getSelfDeck().isEmpty()
                                && this.player1.getWinDeck().isEmpty()) {
                            return player2.getName();
                        } else {
                            return player1.getName();
                        }
                    }
                    reStockSelfDeck();

                    //draw 1 card
                    middleDeck1.addCard(player1.getSelfDeck().removeTopCard());
                    middleDeck2.addCard(player2.getSelfDeck().removeTopCard());

                    if (j < 2) {
                        System.out.println(player1.getName() + " drew a war card");
                        System.out.println(player2.getName() + " drew a war card");
                    }

                }

                i = middleDeck1.getDeck().size() - 1;

                // print card drawing statement
                System.out.println(player1.getName() + " drew " +
                        middleDeck1.getDeck().get(i).toString());
                System.out.println(player2.getName() + " drew " +
                        middleDeck2.getDeck().get(i).toString());

                // if theres a winner, print war winner statement
                if (middleDeck1.getDeck().get(i).compare(middleDeck2.getDeck().get(i)) != 0){
                    if (middleDeck1.getDeck().get(i).compare(middleDeck2.getDeck().get(i)) == 1) {
                        System.out.println(player1.getName() + " won the war");
                    } else if (middleDeck1.getDeck().get(i).compare(middleDeck2.getDeck().get(i)) == -1) {
                        System.out.println(player2.getName() + " won the war");
                    }
                    warWinner = true;
                }
            } // end of war

            //print round winner statement (not if it was a win at a war)
            if (middleDeck1.getDeck().get(i).compare(middleDeck2.getDeck().get(i)) == 1) {

                player1.getWinDeck().addAllCards(middleDeck1, middleDeck2);
                if (!warWinner) {
                    System.out.println(player1.getName() + " won");
                }
            }
            else {
                player2.getWinDeck().addAllCards(middleDeck1, middleDeck2);
                if (!warWinner) {
                    System.out.println(player2.getName() + " won");
                }
            }
        }

        // set winner
        if (this.player1.getSelfDeck().isEmpty() &&
                this.player1.getWinDeck().isEmpty()) {
            winner = player2.getName();
        } else {
            winner = player1.getName();
        }

        return winner;
    }


    boolean theresAWinner() {
        /** true if someone's both decks are empty
         */
        return (this.player1.getSelfDeck().isEmpty() &&
                this.player1.getWinDeck().isEmpty()) ||
               (this.player2.getSelfDeck().isEmpty() &&
                this.player2.getWinDeck().isEmpty());
    }

    void reStockSelfDeck(){
        /** if self deck is empty, take cards from winning deck and shuffle it
         */
        if (this.player1.getSelfDeck().isEmpty()) {
            this.player1.setSelfDeck(player1.getWinDeck());
            this.player1.setWinDeck(new Deck(false));
            this.player1.getSelfDeck().shuffle();
        }
        if (this.player2.getSelfDeck().isEmpty()) {
            this.player2.setSelfDeck(player2.getWinDeck());
            this.player2.setWinDeck(new Deck(false));
            this.player2.getSelfDeck().shuffle();
        }
    }
}
