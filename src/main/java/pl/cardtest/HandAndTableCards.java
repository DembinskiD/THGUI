package pl.cardtest;

import java.util.ArrayList;

public class HandAndTableCards {
    private final Player player;
    private final ArrayList<Card> allCardsCombined = new ArrayList<>();

    public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard) {
        this.player = player;
        allCardsCombined.addAll(handsCards);
        allCardsCombined.addAll(flopCards);
        allCardsCombined.add(turnCard);
        allCardsCombined.add(riverCard);
    }

    public ArrayList<Card> getAllCardsCombined() {
        return allCardsCombined;
    }

    public Player getPlayer() {
        return player;
    }
}
