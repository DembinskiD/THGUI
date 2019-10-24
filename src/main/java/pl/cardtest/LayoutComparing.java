package pl.cardtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LayoutComparing {
    private ArrayList<Player> listOfPlayers;

    //todo dopisac wszystkie mozliwosci wygrania, sprawdzanie wygranego z identycznymi ukladami kart, remis(rozdanie nagrody na 2 lub wiecej osob)


    public LayoutComparing(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public LayoutComparing() {
        this.listOfPlayers = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.listOfPlayers.add(player);
    }

    public Player getWinner() {
        if(listOfPlayers.stream().allMatch(listOfPlayers.get(0)::equals)) {
            return Collections.max(listOfPlayers, Comparator.comparing(Player::getHighestCardFromLayout));
        } else return listOfPlayers.stream().max(Comparator.comparing(Player::getPokerLayout)).get();
    }
}
