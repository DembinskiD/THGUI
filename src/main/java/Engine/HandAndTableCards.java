package Engine;

import java.util.ArrayList;

public class HandAndTableCards {
    private Player player;
    private ArrayList<Card> allCardsCombined = new ArrayList<>();

    public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard) {
        this.player = player;
        handsCards.stream().forEach(card -> allCardsCombined.add(card));
        flopCards.stream().forEach(card -> allCardsCombined.add(card));
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
