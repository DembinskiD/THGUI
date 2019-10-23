package pl.cardtest;

import pl.cardtest.GUI.NewGameGridPane;

import java.util.ArrayList;

public class Game {
    private PlayerManager playerList;
    private MoneyManager moneyManager;
    private Deck playingDeck;
    private ArrayList<Card> flopCards = new ArrayList<>();
    private ArrayList<Card> turnCards = new ArrayList<>();
    private ArrayList<Card> riverCards = new ArrayList<>();
    private GameState stateOfTheGame;
    public static int initialPlayerCash = 100;

   /* public Game() throws Exception {
        this.playerList = new PlayerManager("temp", 1);
        this.moneyManager = new MoneyManager(20);
        this.playingDeck = new Deck();
        newGameGridPane = new NewGameGridPane(this);
        playerList.getListOfPlayers().forEach(player -> player.setPlayerStatus(PlayerStatus.INGAME));
        firstCardDistributionToPlayersHands();
        playerDecisionTurn();
        flop();
        playerDecisionTurn();
        turn();
        playerDecisionTurn();
        river();
    }*/

    public Game(int opponentAmounts, String playerName, int initialPlayerCash) throws Exception {
        Game.initialPlayerCash = initialPlayerCash;
        this.stateOfTheGame = GameState.INITIAL;
        this.playerList = new PlayerManager(playerName, opponentAmounts);
        this.moneyManager = new MoneyManager(20); //todo ustawic initialsmallblind w game creatorze
        this.playingDeck = new Deck();
        playerList.getListOfPlayers().forEach(player -> player.setPlayerStatus(PlayerStatus.INGAME));
        firstCardDistributionToPlayersHands();
        flop();
        turn();
        river();
    }


    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    public GameState getStateOfTheGame() {
        return stateOfTheGame;
    }

    public void setStateOfTheGame(GameState stateOfTheGame) {
        this.stateOfTheGame = stateOfTheGame;
    }

    public PlayerManager getPlayerList() {
        return playerList;
    }

    public Deck getPlayingDeck() {
        return playingDeck;
    }

    private void firstCardDistributionToPlayersHands() {
        for (int i = 0; i < 2; i++) {
            for (Player pl : getPlayerList().getListOfPlayers()) {
                pl.addCardToPlayersHand(this.playingDeck.getDeckStack().pop());
            }
        }
    }

    private void flop() {
        for (int i = 0; i < 3; i++) flopCards.add(this.playingDeck.getDeckStack().pop());
    }

    private void turn() {
        turnCards.add(this.playingDeck.getDeckStack().pop());
    }

    private void river() {
        riverCards.add(this.playingDeck.getDeckStack().pop());
    }

    public ArrayList<Card> getFlopCards() {
        return flopCards;
    }

    public ArrayList<Card> getTurnCards() {
        return turnCards;
    }

    public ArrayList<Card> getRiverCards() {
        return riverCards;
    }


}
