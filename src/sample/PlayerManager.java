package sample;

import java.util.ArrayList;

public class PlayerManager {
    private ArrayList<Player> listOfPlayers = new ArrayList<>();


    public PlayerManager(int initialPlayersAmount) {
        for (int i = 0; i<  initialPlayersAmount; i++){
            addPlayer("Player " + String.valueOf(i), 200);
            System.out.println("Created player " + String.valueOf(i));
        }

    }

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void addPlayer(String playerName, int initialCash){
        this.listOfPlayers.add(new Player(playerName, initialCash));
    }

}
