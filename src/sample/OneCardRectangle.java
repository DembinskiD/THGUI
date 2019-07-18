package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class OneCardRectangle {
    private Rectangle cardsStack = new Rectangle();


    public OneCardRectangle() {
        cardsStack.setWidth(Main.cardWidth);
        cardsStack.setHeight(Main.cardHeight);
        cardsStack.setArcHeight(20);
        cardsStack.setArcWidth(20);
        cardsStack.setFill(Color.rgb(0,100,0));
        cardsStack.setStrokeType(StrokeType.INSIDE);
        cardsStack.setStroke(Color.BLACK);
    }


    public Rectangle getCardsStack() {
        return cardsStack;
    }
}



