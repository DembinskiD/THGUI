package pl.cardtest;

import java.util.ArrayList;

public class PlayerManager {
    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private ArrayList<Player> listOfRealPlayers = new ArrayList<>();
    private ArrayList<OponentAI> listOfNPC = new ArrayList<>();
    private PlayerPosition initialPlayerPosition = PlayerPosition.SMALL_BLIND;



    public PlayerManager(String playerName, int initialComputerOpponents) {
        addPlayer(playerName, Game.initialPlayerCash);
        for (int i = 0; i<  initialComputerOpponents; i++){
            addOpponent("NPC" + String.valueOf(i + 1), Game.initialPlayerCash);
        }


        listOfPlayers.addAll(listOfRealPlayers);
        listOfPlayers.addAll(listOfNPC);


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
