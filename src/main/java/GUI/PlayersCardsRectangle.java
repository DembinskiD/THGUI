package GUI;


import Engine.Main;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class PlayersCardsRectangle {
    private Rectangle playersCardsRectangle = new Rectangle();

    public PlayersCardsRectangle() {
        playersCardsRectangle.setWidth(30 + 2* Main.cardWidth);
        playersCardsRectangle.setHeight(Main.cardHeight);
        playersCardsRectangle.setArcHeight(20);
        playersCardsRectangle.setArcWidth(20);
        playersCardsRectangle.setFill(Color.rgb(0,100,0));
        playersCardsRectangle.setStrokeType(StrokeType.INSIDE);
        playersCardsRectangle.setStroke(Color.BLACK);
        GridPane.setHalignment(this.playersCardsRectangle, HPos.RIGHT);
    }

    public Rectangle getPlayersCardsRectangle() {
        return playersCardsRectangle;
    }
}
