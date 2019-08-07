package Engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LayoutComparing {
    ArrayList<Player> listOfPlayers;

    //todo dopisac wszystkie mozliwosci wygrania, sprawdzanie wygranego z identycznymi ukladami kart, remis(rozdanie nagrody na 2 lub wiecej osob)


    public LayoutComparing(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public Player getWinner() {
        if(listOfPlayers.stream().allMatch(listOfPlayers.get(0)::equals)) {
            return Collections.max(listOfPlayers, Comparator.comparing(player -> player.getHighestCardFromLayout()));
        } else return listOfPlayers.stream().max(Comparator.comparing(Player::getPokerLayout)).get();
    }
}
