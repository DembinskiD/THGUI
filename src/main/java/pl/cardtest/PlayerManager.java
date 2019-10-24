package pl.cardtest;

import java.util.ArrayList;

public class PlayerManager {
    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private ArrayList<Player> listOfRealPlayers = new ArrayList<>();
    private ArrayList<OponentAI> listOfNPC = new ArrayList<>();
    private PlayerPosition initialPlayerPosition = PlayerPosition.BUTTON;
    private Player currentPlayer;



    public PlayerManager(String playerName, int initialComputerOpponents, int initialPlayerCash) {
        addPlayer(playerName, initialPlayerCash);
        for (int i = 0; i<  initialComputerOpponents; i++){
            addOpponent("NPC" + String.valueOf(i + 1), initialPlayerCash);
        }

        this.currentPlayer = listOfRealPlayers.get(0);
        listOfPlayers.addAll(listOfRealPlayers);
        listOfPlayers.addAll(listOfNPC);


    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    private void addPlayer(String playerName, int initialCash){
        this.listOfRealPlayers.add(new Player(playerName, initialCash, initialPlayerPosition));
        initialPlayerPosition = initialPlayerPosition.next();
    }

    private void addOpponent(String playerName, int initialCash) {
        this.listOfNPC.add(new OponentAI(playerName, initialCash, initialPlayerPosition));
        initialPlayerPosition = initialPlayerPosition.next();
    }

    public ArrayList<Player> getListOfRealPlayers() {
        return listOfRealPlayers;
    }

    public ArrayList<OponentAI> getListOfNPC() {
        return listOfNPC;
    }
}
