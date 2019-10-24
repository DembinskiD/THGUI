package pl.cardtest;

import java.util.ArrayList;

public class HandAndTableCards implements PokerLayouts{
    private Player player;
    private ArrayList<Card> allCardsCombined = new ArrayList<>();

    public HandAndTableCards(Player player, ArrayList<Card> flopCards, Card turnCard, Card riverCard) {
        this.player = player;
        allCardsCombined.addAll(player.getPlayerCardsList());
        allCardsCombined.addAll(flopCards);
        allCardsCombined.add(turnCard);
        allCardsCombined.add(riverCard);
    }

    public ArrayList<Card> getAllCardsCombined() {
        return allCardsCombined;
    }

    public PokerLayout getLayout() {
        this.player.setPokerLayout(finalLayoutOfPlayer(this.allCardsCombined));
        return this.player.getPokerLayout();

    }

    public Player getPlayer() {
        return player;
    }
}
