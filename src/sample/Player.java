package sample;

import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {
    private Text playerName = new Text();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private PlayerStatus playerStatus = null;
    private int initialPlayerCash;
    private PokerLayout pokerLayout;
    private ArrayList<Card> cardsContainedInLayout = new ArrayList<>();

    public ArrayList<Card> getCardsContainedInLayout() {
        return cardsContainedInLayout;
    }

    public String getPlayerName() {
        return playerName.getText();
    }

    public Player(String playerName, int initialPlayerCash) {
        this.playerName.setText(playerName);
        this.initialPlayerCash = initialPlayerCash;
        this.pokerLayout = PokerLayout.NONE;
        this.playerStatus = PlayerStatus.INGAME;
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
        return "Player{" +
                "playerName=" + playerName.getText() +
                ", playerCards=" + playerCards +
                ", playerStatus=" + playerStatus +
                ", initialPlayerCash=" + initialPlayerCash +
                ", pokerLayout=" + pokerLayout +
                ",cardsContainedInLayout=" + cardsContainedInLayout +
                '}';
    }




}
