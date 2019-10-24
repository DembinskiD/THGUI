package pl.cardtest;

import java.util.ArrayList;

public class Game {
    private PlayerManager playerList;
    private MoneyManager moneyManager;
    private Deck playingDeck;
    private ArrayList<Card> flopCards = new ArrayList<>();
    private ArrayList<Card> turnCards = new ArrayList<>();
    private ArrayList<Card> riverCards = new ArrayList<>();
    private GameState stateOfTheGame;
    public int initialPlayerCash;




    public Game(int opponentAmounts, String playerName, int initialPlayerCash, int smallBlind) throws Exception {
        this.initialPlayerCash = initialPlayerCash;
        this.stateOfTheGame = GameState.INITIAL;
        this.playerList = new PlayerManager(playerName, opponentAmounts, this.initialPlayerCash);
        this.moneyManager = new MoneyManager(smallBlind);
        this.playingDeck = new Deck();
        playerList.getListOfPlayers().forEach(player -> player.setPlayerStatus(PlayerStatus.INGAME));
        firstCardDistributionToPlayersHands();
        flop();
        turn();
        river();
    }

    public void newRound(int smallBlind) {
        this.stateOfTheGame = GameState.INITIAL;
        this.moneyManager = new MoneyManager(smallBlind);
        this.playingDeck = new Deck();
        playerList.getListOfPlayers().forEach(player -> {
            player.getPlayerCardsList().clear();
            player.setPokerLayout(PokerLayout.NONE);
        });
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
