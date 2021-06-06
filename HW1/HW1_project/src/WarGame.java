import java.util.Arrays;

public class WarGame {
    private Player player1;
    private Player player2;
    private Deck middleDeck1;
    private Deck middleDeck2;
    Player [] playersArr = new Player[2];


    public WarGame(String name1, String name2){
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
        this.middleDeck1 = new Deck(false);
        this.middleDeck2 = new Deck(false);
    }

    public void InitializeGame(){
        //create main deck and shuffle it
        Deck mainDeck = new Deck(true);
        mainDeck.shuffle();

        sortPlayers(playersArr);

        //split dec to players:
        while(!mainDeck.isEmpty()) {
            for (int i = 0; i<2; i++) {
                Card currentCardToGive = mainDeck.removeTopCard();
                this.playersArr[i].addToSelfDeck(currentCardToGive);
            }
        }

    }

    public void sortPlayers(Player [] arr) {
        String[] names = {arr[0].getName(), arr[1].getName()};
        Arrays.sort(names);
        if (names[0] != arr[0].getName()) {
            Player temp_player = arr[0];
            arr[0] = arr[1];
            arr[1] = temp_player;
        }
    }

    String start() {
        System.out.println("Initializing the game...");
        String winner;

        while (!theresAWinner()) {
            //todo fix shichpul
            if (this.player1.getSelfDeck().isEmpty()) {
                this.player1.setSelfDeck(player1.getWinDeck());
                this.player1.setWinDeck(new Deck(false));
                this.player1.getSelfDeck().shuffle();
            } else if (this.player2.getSelfDeck().isEmpty()) {
                this.player2.setSelfDeck(player2.getWinDeck());
                this.player2.setWinDeck(new Deck(false));
                this.player2.getSelfDeck().shuffle();

            } else {
                int i = middleDeck1.getDeck().size() - 1;
                middleDeck1.addCard(player1.getSelfDeck().removeTopCard());
                System.out.println(player1.getName() + "drew" + middleDeck1.getDeck().get(i).toString());
                middleDeck2.addCard(player2.getSelfDeck().removeTopCard());
                System.out.println(player2.getName() + "drew" + middleDeck2.getDeck().get(i).toString());

                i = middleDeck1.getDeck().size() - 1;
                //WAR
                while (middleDeck1.getDeck().get(i).getNumber() == middleDeck1.getDeck().get(i).getNumber()) {

                    i = middleDeck1.getDeck().size() - 1;
                    for (int j = 0; j < 3; j++) {
                        middleDeck1.addCard(player1.getSelfDeck().removeTopCard());
//                        System.out.println(player1.getName() + "drew" + middleDeck1.getDeck().get(i).toString());
                        middleDeck2.addCard(player2.getSelfDeck().removeTopCard());
//                        System.out.println(player1.getName() + "drew" + middleDeck1.getDeck().get(i).toString());
                    }
                }
                if (middleDeck1.getDeck().get(i).getNumber() > middleDeck1.getDeck().get(i).getNumber()) {
                    player1.getWinDeck().addAllCards(middleDeck1);
                    player1.getWinDeck().addAllCards(middleDeck2);
                }
                else {
                    player2.getWinDeck().addAllCards(middleDeck1);
                    player2.getWinDeck().addAllCards(middleDeck2);
                }

            }
        }

        // set winner
        if (this.player1.getSelfDeck().isEmpty() && this.player1.getWinDeck().isEmpty()) {
            winner = player2.getName();
        } else {
            winner = player1.getName();
        }

        return winner;
    }

    boolean theresAWinner() {
        if ((this.player1.getSelfDeck().isEmpty() && this.player1.getWinDeck().isEmpty()) ||
            (this.player2.getSelfDeck().isEmpty() && this.player2.getWinDeck().isEmpty())) {
            return true;
        } else {
            return false;
        }
    }
}
