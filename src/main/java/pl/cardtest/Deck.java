package pl.cardtest;

import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> deckStack  = new Stack<>();
    private final String cardBackURL = Main.cardRewers;
    private ImageView cardBackImageView;


    public Deck(){
        Arrays.stream(CardRank.values())
                .forEach(cardRank ->
                    Arrays.stream(CardColor.values())
                            .forEach(cardColor -> {
                                this.cardBackImageView = new ImageView(cardBackURL);
                                this.deckStack.push(new Card(cardRank, cardColor, this.cardBackImageView, (cardRank.getLink() + cardColor.getLink() + ".png")));

                            }));

        Collections.shuffle(deckStack);
    }

    public Stack<Card> getDeckStack() {
        assert deckStack.size() < 13*4 : "DeckStack has more than 52 cards!";
        return deckStack;
    }
}
