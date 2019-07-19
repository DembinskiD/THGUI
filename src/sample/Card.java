package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
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

    public boolean compareRanks(Card color) {
        return this.rank.isBiggerThan(color.rank);
    }

    @Override
    public String toString() {
        return rank + " " + color + " " + imageURL;
    }
}
