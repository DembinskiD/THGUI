package sample;

import java.util.ArrayList;

public class HandAndTableCards {
    private Player player;
    private ArrayList<Card> allCardsCombined = new ArrayList<>();
    private ArrayList<Card> handsCards;
    private ArrayList<Card> flopCards;
    private Card turnCard;
    private Card riverCard;

    public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard) {
        this.player = player;
        this.handsCards = handsCards;
        this.flopCards = flopCards;
        this.turnCard = turnCard;
        this.riverCard = riverCard;
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
