package Engine;

import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player implements PokerLayouts{
    private PlayerPosition playerPosition;
    private Text playerName = new Text();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private PlayerStatus playerStatus = null;
    private int initialPlayerCash;
    private PokerLayout pokerLayout;
    private ArrayList<Card> cardsContainedInLayout = new ArrayList<>();
    protected boolean isComputer;

    public ArrayList<Card> getCardsContainedInLayout() {
        return cardsContainedInLayout;
    }

    public void updateHandsLayout() {
        this.pokerLayout = finalLayoutOfPlayer(this.playerCards);
        this.cardsContainedInLayout = finalLayoutCardsOfPlayer(playerCards);

    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerName() {
        return playerName.getText();
    }

    public Player(String playerName, int initialPlayerCash, PlayerPosition playerPosition) {
        this.playerName.setText(playerName);
        this.initialPlayerCash = initialPlayerCash;
        this.pokerLayout = PokerLayout.NONE;
        this.playerStatus = PlayerStatus.INGAME;
        this.isComputer = false;
        this.setPlayerPosition(playerPosition);
        System.out.println("Created: " + this.getPlayerName());
    }

    public Player(String playerName, int initialPlayerCash) {
        this.playerName.setText(playerName);
        this.initialPlayerCash = initialPlayerCash;
        this.pokerLayout = PokerLayout.NONE;
        this.playerStatus = PlayerStatus.INGAME;
        this.isComputer = false;
        System.out.println("Created: " + this.getPlayerName());
    }

    public Card getHighestCardFromLayout() {
        return Collections.max(cardsContainedInLayout, Comparator.comparing(s -> s.getRank()));
    }

    public PokerLayout getPokerLayout() {
        return pokerLayout;
    }

    public void setCardsContainedInLayout(ArrayList<Card> cardsContainedInLayout) {
        this.cardsContainedInLayout = cardsContainedInLayout;
    }

    public ArrayList<Card> getPlayerCardsList() {
        return playerCards;
    }

    public void setPlayerName(String playerName) {
        this.playerName.setText(playerName);
    }


    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public void setInitialPlayerCash(int initialPlayerCash) {
        this.initialPlayerCash = initialPlayerCash;
    }

    public void setPokerLayout(PokerLayout pokerLayout) {
        this.pokerLayout = pokerLayout;
    }

    public void addCardToPlayersHand(Card card){
        this.playerCards.add(card);
    }

    @Override
    public String toString() {
        return "Engine.Player{" +
                "playerName=" + playerName.getText() +
                ", playerCards=" + playerCards +
                ", playerStatus=" + playerStatus +
                ", initialPlayerCash=" + initialPlayerCash +
                ", pokerLayout=" + pokerLayout +
                ",cardsContainedInLayout=" + cardsContainedInLayout +
                ",playerPosition=" + playerPosition +
                '}';
    }






}
