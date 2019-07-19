package sample;

import javafx.scene.text.Text;

import java.util.ArrayList;

public class Player {
    private Text playerName = new Text();
    private ArrayList<Card> playerCards = new ArrayList<>();
    private PlayerStatus playerStatus = null;
    private int initialPlayerCash;

    public Player(String playerName, int initialPlayerCash) {
        this.playerName.setText(playerName);
        this.initialPlayerCash = initialPlayerCash;
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


    public void addCardToPlayersHand(Card card){
        this.playerCards.add(card);
    }

    public Player() {
    }
}
