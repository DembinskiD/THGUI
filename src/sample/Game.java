package sample;

import java.util.ArrayList;

public class Game {
    private NewGameGridPane newGameGridPane;
    private PlayerManager playerList;
    private MoneyManager moneyManager;
    private Deck playingDeck;
    private ArrayList<Card> flopCards = new ArrayList<>();
    private ArrayList<Card> turnCards = new ArrayList<>();
    private ArrayList<Card> riverCards = new ArrayList<>();

    public Game() {
        this.playerList = new PlayerManager(2);
        this.moneyManager = new MoneyManager(this);
        this.playingDeck = new Deck();


        firstCardDistributionToPlayersHands();
        //bet here
        flop();
        //bet here
        turn();
        //bet here
        river();

        this.newGameGridPane  = new NewGameGridPane(this);

    }

    public PlayerManager getPlayerList() {
        return playerList;
    }

    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    public Deck getPlayingDeck() {
        return playingDeck;
    }

    private void firstCardDistributionToPlayersHands() {
        for(int i = 0 ; i < 3 ; i++){
            for(Player pl : getPlayerList().getListOfPlayers()){
                pl.addCardToPlayersHand(this.playingDeck.getDeckStack().pop());
            }
        }
    }

    private void flop() {
        for (int i = 0 ; i < 3 ; i++) flopCards.add(this.playingDeck.getDeckStack().pop());
    }

    private void turn() {
        turnCards.add(this.playingDeck.getDeckStack().pop());
    }

    private void river() {
        riverCards.add(this.playingDeck.getDeckStack().pop());
    }
}
