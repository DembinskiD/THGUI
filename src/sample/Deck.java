package sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    public int maxCardsInDeck;
    public int AmountCardsInDeck;
    protected Stack<Card> deckStack  = new Stack<>();


    public Deck(){
        Arrays.stream(CardRank.values())
                .forEach(cardRank -> {
                    Arrays.stream(CardColor.values())
                            .forEach(cardColor -> {
                                this.deckStack.push(new Card(cardRank, cardColor, ("http://dembik.cba.pl/PNG/" + cardRank.getLink() + cardColor.getLink() + ".png")));
                            });
                });
        Collections.shuffle(deckStack);
    }

}
