package pl.cardtest.GUI;

import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import pl.cardtest.Main;

public class CardsRectangle {
    private final Rectangle cardsStack = new Rectangle();


    public CardsRectangle() {
        cardsStack.setWidth(Main.cardWidth + 20);
        cardsStack.setHeight(Main.cardHeight);
        cardsStack.setArcHeight(20);
        cardsStack.setArcWidth(20);
        cardsStack.setFill(Color.rgb(0,100,0));
        cardsStack.setStrokeType(StrokeType.INSIDE);
        cardsStack.setStroke(Color.BLACK);
        GridPane.setHalignment(this.cardsStack, HPos.CENTER);
    }

    public CardsRectangle(int cardsCount) {
        cardsStack.setWidth(cardsCount * Main.cardWidth + 20);
        cardsStack.setHeight(Main.cardHeight);
        cardsStack.setArcHeight(20);
        cardsStack.setArcWidth(20);
        cardsStack.setFill(Color.rgb(0,100,0));
        cardsStack.setStrokeType(StrokeType.INSIDE);
        cardsStack.setStroke(Color.BLACK);
        GridPane.setHalignment(this.cardsStack, HPos.CENTER);
    }


    public Rectangle getCardsStack() {
        return cardsStack;
    }
}



