package pl.cardtest;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Card implements Comparable{
    private CardRank rank;
    private CardColor color;
    private String imageURL;
    private ImageView cardImageView;



    //Konstruktor
    public Card(CardRank rank, CardColor color){
        this.rank = rank;
        this.color = color;
    }

    public Card(CardRank rank, CardColor color, ImageView backView, String imageURL) {
        this.cardImageView = backView;
        this.cardImageView.setFitHeight(Main.cardHeight);
        this.cardImageView.setFitWidth(Main.cardWidth);
        this.rank = rank;
        this.color = color;
        this.imageURL = imageURL;

    }



    //Getters
    public CardRank getRank() {
        return rank;
    }

    public CardColor getColor() {
        return color;
    }


    public ImageView getCardImageView() {
        return cardImageView;
    }

    public void turnCard(){
        this.cardImageView.setImage(new Image(imageURL));
    }


    //Setters


    //Porównania kart, czy te same kolory, czy te same ranki

    public int compareRanksByNumber(Card card) {
        return Integer.compare(this.getRank().number, card.getRank().number);
    }


    @Override
    public String toString() {
        return rank + " " + color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                color == card.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, color);
    }

    @Override
    public int compareTo(Object o) {
        if( this == o ) return 0;
        if( o == null || getClass() != o.getClass()) return 1;
        Card card = (Card) o;
        return getRank().number - card.getRank().number > 0 ? 1 : -1;
    }
}
