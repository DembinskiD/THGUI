package sample;

import sample.GUI.NewGameGridPane;

import java.util.ArrayList;

public class Game {
    private NewGameGridPane newGameGridPane;
    private PlayerManager playerList;
    private MoneyManager moneyManager;
    private Deck playingDeck;
    private ArrayList<Card> flopCards = new ArrayList<>();
    private ArrayList<Card> turnCards = new ArrayList<>();
    private ArrayList<Card> riverCards = new ArrayList<>();
    private GameState stateOfTheGame;
    public static int initialPlayerCash = 100;

    public Game() {
        this.playerList = new PlayerManager(1, 1);
        this.moneyManager = new MoneyManager(this);
        this.playingDeck = new Deck();

        playerList.getListOfPlayers().forEach(player -> player.setPlayerStatus(PlayerStatus.INGAME));
        firstCardDistributionToPlayersHands();
        decisionTurn();
        flop();
        //bet here
        turn();
        //bet here
        river();

        this.newGameGridPane  = new NewGameGridPane(this);

    }

    private void decisionTurn() {
        for(Player player : getPlayerList().getListOfRealPlayers()){
            System.out.println(player);
        }
        for(OponentAI opponent : getPlayerList().getListOfNPC()){
            opponent.decide();
        }
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

    public MoneyManager getMoneyManager() {
        return moneyManager;
    }

    public Deck getPlayingDeck() {
        return playingDeck;
    }

    private void firstCardDistributionToPlayersHands() {
        for(int i = 0 ; i < 2 ; i++){
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
