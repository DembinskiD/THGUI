package sample;

import javafx.scene.text.Text;

import java.util.ArrayList;

public class Player {
    private Text playerName = new Text();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private PlayerStatus playerStatus = null;
    private int initialPlayerCash;
    private PokerLayout pokerLayout;
    private ArrayList<Card> cardsContainedInLayout = new ArrayList<>();

    public Player(String playerName, int initialPlayerCash) {
        this.playerName.setText(playerName);
        this.initialPlayerCash = initialPlayerCash;
        this.pokerLayout = PokerLayout.NONE;
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
