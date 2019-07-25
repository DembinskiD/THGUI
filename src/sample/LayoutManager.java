package sample;

import java.util.ArrayList;

public class LayoutManager {
    private ArrayList<Card> inputCards = new ArrayList<>();
    private Player player;

    public LayoutManager(HandAndTableCards handAndTableCards) {
        this.inputCards = handAndTableCards.getAllCardsCombined();
        this.player = handAndTableCards.getPlayer();
    }

    //todo need to create all poker layouts to have output about players layouts and also comparers for same layouts

    public boolean hasPair() {
        return inputCards.stream().map(Card::getRank).distinct().count() == 2;
    }
}
