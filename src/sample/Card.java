package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card{
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


}
