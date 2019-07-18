package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class FlopRectangle {
    private Rectangle flopRectangle = new Rectangle();


    public FlopRectangle() {
        flopRectangle.setWidth(40 + 3*Main.cardWidth);
        flopRectangle.setHeight(Main.cardHeight);
        flopRectangle.setArcHeight(20);
        flopRectangle.setArcWidth(20);
        flopRectangle.setFill(Color.rgb(0,100,0));
        flopRectangle.setStrokeType(StrokeType.INSIDE);
        flopRectangle.setStroke(Color.BLACK);
    }

    public Rectangle getFlopRectangle() {
        return flopRectangle;
    }
}
