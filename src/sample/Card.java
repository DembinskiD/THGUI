package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private CardRank rank;
    private CardColor color;
    private String imageURL;
    Image cardImage;
    ImageView cardImageView;
    private String cardBackURL = "http://dembik.cba.pl/PNG/blue_back.png";
    private Image cardBackImage;
    private ImageView cardBackImageView;



    //Konstruktor
    public Card(CardRank rank, CardColor color){
        this.rank = rank;
        this.color = color;
    }

    public Card(CardRank rank, CardColor color, String imageURL) {
        this.rank = rank;
        this.color = color;
        //System.out.println(imageURL);
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

    public Image getCardImage() {
        return cardImage;
    }

    public ImageView getCardImageView() {
        this.cardImage = new Image(imageURL);
        this.cardImageView = new ImageView(this.imageURL);
        this.cardImageView.setFitHeight(100);
        this.cardImageView.setFitWidth(60);
        return cardImageView;
    }

    public ImageView getCardBackImageView() {
        this.cardBackImage = new Image(this.cardBackURL);
        this.cardBackImageView = new ImageView(this.cardBackURL);
        this.cardBackImageView.setFitHeight(100);
        this.cardBackImageView.setFitWidth(60);
        return this.cardBackImageView;
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
