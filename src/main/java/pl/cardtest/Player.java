package pl.cardtest;

import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player implements PokerLayouts{
    private PlayerPosition playerPosition;
    private final Text playerName = new Text();
    private final ArrayList<Card> playerCards = new ArrayList<>();
    private PlayerStatus playerStatus;
    private int playerCash;
    private PokerLayout pokerLayout;
    private ArrayList<Card> cardsContainedInLayout = new ArrayList<>();





    public int getPlayerCash() {
        return playerCash;
    }



    public void updateHandsLayout() {
        this.pokerLayout = finalLayoutOfPlayer(this.playerCards);
        this.cardsContainedInLayout = finalLayoutCardsOfPlayer(playerCards);

    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerName() {
        return playerName.getText();
    }

    public Player(String playerName, int initialPlayerCash, PlayerPosition playerPosition) {
        this.playerName.setText(playerName);
        this.playerCash = initialPlayerCash;
        this.pokerLayout = PokerLayout.NONE;
        this.playerStatus = PlayerStatus.INGAME;
        this.setPlayerPosition(playerPosition);
    }

    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
    }

    public int chipMoneyIn(int cashAmount) {
        this.playerCash -= cashAmount;
        return cashAmount;
    }

    public Player(String playerName, int initialPlayerCash) {
        this.playerName.setText(playerName);
        this.playerCash = initialPlayerCash;
        this.pokerLayout = PokerLayout.NONE;
        this.playerStatus = PlayerStatus.INGAME;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public Card getHighestCardFromLayout() {
        return Collections.max(cardsContainedInLayout, Comparator.comparing(Card::getRank));
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


    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public void setPokerLayout(PokerLayout pokerLayout) {
        this.pokerLayout = pokerLayout;
    }

    public void addCardToPlayersHand(Card card){
        this.playerCards.add(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName=" + playerName.getText() +
                ", playerCards=" + playerCards +
                ", playerStatus=" + playerStatus +
                ", initialPlayerCash=" + playerCash +
                ", pokerLayout=" + pokerLayout +
                ",cardsContainedInLayout=" + cardsContainedInLayout +
                ",playerPosition=" + playerPosition +
                '}';
    }






}
