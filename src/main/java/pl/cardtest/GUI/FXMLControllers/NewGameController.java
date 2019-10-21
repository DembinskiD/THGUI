package pl.cardtest.GUI.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.cardtest.Card;
import pl.cardtest.GUI.CardsRectangle;
import pl.cardtest.GUI.GameConsole;
import pl.cardtest.Game;
import pl.cardtest.Main;


public class NewGameController {
    public ScrollPane historyConsole = new ScrollPane();
    public GameConsole console;
    public Label raiseLabel;
    public GridPane raiseButtonControls;
    public Rectangle OpponentCardStack = new Rectangle();
    public Rectangle PlayerCardStack = new Rectangle();
    public Rectangle cardStackRect;
    public Rectangle FlopCardStack;
    public Rectangle RiverCardStack;
    public Rectangle TurnCardStack;
    public GridPane FlopCards;
    public Game game;
    public Label playerLabel = new Label();

    public NewGameController() {
    }


    @FXML
    public void initialize() {
        this.console = new GameConsole(historyConsole);
        raiseButtonControls.setAlignment(Pos.CENTER);
        GridPane.setHalignment(raiseLabel, HPos.CENTER);
        rectSettings(cardStackRect, 1);
        rectSettings(OpponentCardStack, 2);
        rectSettings(PlayerCardStack, 2);   
        rectSettings(FlopCardStack, 3);
        rectSettings(TurnCardStack, 1);
        rectSettings(RiverCardStack,1);
        System.out.println(this.game.getPlayerList().getListOfRealPlayers().size());
        playerLabel.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerName());
    }



    public void rectSettings(@org.jetbrains.annotations.NotNull Rectangle temp, int cardAmount) {
        int spaces = (cardAmount+1) * 10;
        temp.setWidth(cardAmount * Main.cardWidth + spaces);
        temp.setHeight(Main.cardHeight);
        temp.setArcWidth(20);
        temp.setArcHeight(20);
        temp.setFill(Color.rgb(0, 100, 0));
        temp.setStroke(Color.BLACK);
    }



    public void startGameButtonAction(ActionEvent actionEvent) throws Exception {
        this.console.appendHistoryConsoleText("Clicked start game button.");
        this.game = new Game();

    }

    public void callButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText("Calling in.");
    }

    public void raiseButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText("Raising by " + Integer.valueOf(this.raiseLabel.getText()));
    }

    public void allInButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText("Going all in.");
    }

    public void passButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText("Passed.");
    }

    public void increaseButtonAction(ActionEvent actionEvent) {
        if(Integer.valueOf(this.raiseLabel.getText()) < 100) {
            this.raiseLabel.setText(String.valueOf(Integer.valueOf(this.raiseLabel.getText()) + 10));
        }
    }

    public void decreaseButtonAction(ActionEvent actionEvent) {
        if(Integer.valueOf(this.raiseLabel.getText()) > 0) {
            this.raiseLabel.setText(String.valueOf(Integer.valueOf(this.raiseLabel.getText()) - 10));
        }
    }
}
