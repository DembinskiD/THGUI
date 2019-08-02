package sample;

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

    public String getImageURL() {
        return imageURL;
    }


    public ImageView getCardImageView() {
        return cardImageView;
    }

    public void turnCard(){
        this.cardImageView.setImage(new Image(imageURL));
    }


    //Setters


    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    //Porównania kart, czy te same kolory, czy te same ranki

    public boolean areSameRanks(Card card){
        return this.rank.areTheSame(card.rank);
    }

    public boolean areSameColors(Card card) {
        return this.color.compareCardColors(card.color);
    }

    public boolean compareRanks(Card karta) {
        return this.rank.isBiggerThan(karta.rank);
    }

    public int compareRanksByNumber(Card card) {
        if(this.getRank().number < card.getRank().number) return -1;
        else if(this.getRank().number == card.getRank().number) return 0;
        else return 1;
    }

    public boolean areNeighbours(Card card) {
        return this.getRank().number - card.getRank().number == 1 || this.getRank().number - card.getRank().number == -1;
    }

    public boolean areNeighbours(Card card1, Card card2) {
        return card1.getRank().number - card2.getRank().number == 1 || card1.getRank().number - card2.getRank().number == -1;
    }



    @Override
    public String toString() {
        return rank + " " + color + " " + imageURL;
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
