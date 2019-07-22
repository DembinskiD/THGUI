package sample;

import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    public int maxCardsInDeck;
    public int AmountCardsInDeck;
    protected Stack<Card> deckStack  = new Stack<>();
    private String cardBackURL = "sample/Graphics/" + Main.cardRewers;
    private ImageView cardBackImageView;


    public Deck(){
        Arrays.stream(CardRank.values())
                .forEach(cardRank ->
                    Arrays.stream(CardColor.values())
                            .forEach(cardColor -> {
                                this.cardBackImageView = new ImageView(cardBackURL);
                                this.deckStack.push(new Card(cardRank, cardColor, this.cardBackImageView, ("sample/Graphics/" + cardRank.getLink() + cardColor.getLink() + ".png")));

                            }));

        Collections.shuffle(deckStack);
    }

    public Stack<Card> getDeckStack() {
        return deckStack;
    }
}
