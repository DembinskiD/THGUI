package sample;

import java.util.ArrayList;
import java.util.Comparator;

public class LayoutComparing {
    ArrayList<Player> llistOfPlayers;

    //todo dopisac wszystkie mozliwosci wygrania, sprawdzanie wygranego z identycznymi ukladami kart, remis(rozdanie nagrody na 2 lub wiecej osob)


    public LayoutComparing(ArrayList<Player> llistOfPlayers) {
        this.llistOfPlayers = llistOfPlayers;
    }

    public Player getWinner() {
        return llistOfPlayers.stream().max(Comparator.comparing(Player::getPokerLayout)).get();
    }
}
