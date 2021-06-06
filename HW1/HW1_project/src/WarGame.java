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
        playersArr[0] = player1;
        playersArr[1] = player2;
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
        InitializeGame();
        System.out.println("Initializing the game...");
        String winner;
        int index = 0;

        while (!theresAWinner()) {
            boolean warWinner = false;


//            for (int k = 0; k < player1.getSelfDeck().getDeck().size(); k++) {
//                System.out.print(player1.getSelfDeck().getDeck().get(k).toString() + " , ");
//            }
//            System.out.println();
//            for (int k = 0; k < player1.getWinDeck().getDeck().size(); k++) {
//                System.out.print(player1.getWinDeck().getDeck().get(k).toString() + " , ");
//            }
//            System.out.println();



            System.out.println("------------------------- Round number " + ++index + " -------------------------");
            //todo fix shichpul
            // if needed switch decks
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

            //

            middleDeck1.addCard(player1.getSelfDeck().removeTopCard());
            System.out.println(player1.getName() + " drew " + middleDeck1.getDeck().get(0).toString());
            middleDeck2.addCard(player2.getSelfDeck().removeTopCard());
            System.out.println(player2.getName() + " drew " + middleDeck2.getDeck().get(0).toString());

            //WAR
            if (middleDeck1.getDeck().get(0).getNumber() == middleDeck2.getDeck().get(0).getNumber()) {
                System.out.println("Starting a war...");
            }

            int i = 0;
            while (middleDeck1.getDeck().get(i).getNumber() == middleDeck2.getDeck().get(i).getNumber() && !warWinner){
                i = middleDeck1.getDeck().size() - 1;
                for (int j = 0; j < 3; j++) {
                    if (player1.getSelfDeck().isEmpty()) {
                        return player2.getName();
                    }
                    if (player2.getSelfDeck().isEmpty()) {
                        return player1.getName();
                    }

                    //take out card
                    middleDeck1.addCard(player1.getSelfDeck().removeTopCard());
                    middleDeck2.addCard(player2.getSelfDeck().removeTopCard());

                    if (j < 2) {
                        System.out.println(player1.getName() + " drew a war card");
                        System.out.println(player2.getName() + " drew a war card");
                    }
                }

                i = middleDeck1.getDeck().size() - 1;
                if (middleDeck1.getDeck().get(i).getNumber() != middleDeck2.getDeck().get(i).getNumber()){
                    System.out.println(player1.getName() + " drew " + middleDeck1.getDeck().get(i).toString());
                    System.out.println(player2.getName() + " drew " + middleDeck2.getDeck().get(i).toString());
                    if (middleDeck1.getDeck().get(i).getNumber() > middleDeck2.getDeck().get(i).getNumber()) {
                        System.out.println(player1.getName() + " won the war");
                        warWinner = true;
                    } else {
                        System.out.println(player2.getName() + " won the war");
                        warWinner = true;
                    }
                }
            }

            if (middleDeck1.getDeck().get(i).getNumber() > middleDeck2.getDeck().get(i).getNumber()) {
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
            warWinner = false;
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
        return (this.player1.getSelfDeck().isEmpty() && this.player1.getWinDeck().isEmpty()) ||
                (this.player2.getSelfDeck().isEmpty() && this.player2.getWinDeck().isEmpty());
    }
}
