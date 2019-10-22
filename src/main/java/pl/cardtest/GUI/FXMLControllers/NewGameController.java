package pl.cardtest.GUI.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pl.cardtest.GUI.GameConsole;
import pl.cardtest.Game;
import pl.cardtest.Main;

import java.net.URL;
import java.util.ResourceBundle;


public class NewGameController implements Initializable{
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
    @FXML public GridPane root;
    @FXML public Label playerLabel = new Label();
    @FXML public Label opponentLabel = new Label();
    @FXML public Label opponentPosition = new Label();
    @FXML public Label playerPosition = new Label();
    @FXML public Label playerCash = new Label();
    @FXML public Label opponentCash = new Label();



    public NewGameController(int enemies, String playerName, int startingCash) throws Exception {
        this.game = new Game(enemies, playerName, startingCash);
    }

    public NewGameController() {
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
        System.out.println(this.cardStackRect.getLayoutX() + " " + this.cardStackRect.getLayoutY());
        Rectangle tempRect = new Rectangle();
        tempRect.setFill(Color.BLUE);
        tempRect.setStroke(Color.WHITE);
        tempRect.setArcHeight(20);
        tempRect.setArcWidth(20);
        tempRect.setWidth(Main.cardWidth);
        tempRect.setHeight(Main.cardHeight);
        tempRect.setLayoutX(this.cardStackRect.getLayoutX());
        tempRect.setLayoutY(this.cardStackRect.getLayoutY());
        //this.root.add(tempRect, 2, 2);


        Rectangle tempRect2 = new Rectangle();
        tempRect2.setFill(Color.BLUE);
        tempRect2.setStroke(Color.WHITE);
        tempRect2.setWidth(Main.cardWidth);
        tempRect2.setHeight(Main.cardHeight);
        tempRect2.setArcWidth(20);
        tempRect2.setArcHeight(20);
        tempRect2.setLayoutX(this.cardStackRect.getLayoutX() + Main.cardWidth + 20);
        tempRect2.setLayoutY(this.cardStackRect.getLayoutY());
        //this.root.add(tempRect2, 3, 2);

        HBox hbox = new HBox();
        hbox.getChildren().add(tempRect);
        hbox.getChildren().add(tempRect2);
        this.root.add(hbox, 2, 2);




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
        if(Integer.parseInt(this.raiseLabel.getText()) < 100) {
            this.raiseLabel.setText(String.valueOf(Integer.parseInt(this.raiseLabel.getText()) + 10));
        }
    }

    public void decreaseButtonAction(ActionEvent actionEvent) {
        if(Integer.parseInt(this.raiseLabel.getText()) > 0) {
            this.raiseLabel.setText(String.valueOf(Integer.parseInt(this.raiseLabel.getText()) - 10));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.playerPosition.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerPosition().name());
        this.opponentPosition.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerPosition().name());
        this.playerCash.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerCash() + " $");
        this.opponentCash.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerCash() + " $");
        playerLabel.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerName());
        opponentLabel.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerName());

        System.out.println(this.game.getPlayerList().getListOfRealPlayers());

        this.console = new GameConsole(historyConsole);
        raiseButtonControls.setAlignment(Pos.CENTER);
        GridPane.setHalignment(raiseLabel, HPos.CENTER);
        rectSettings(cardStackRect, 1);
        rectSettings(OpponentCardStack, 2);
        rectSettings(PlayerCardStack, 2);
        rectSettings(FlopCardStack, 3);
        rectSettings(TurnCardStack, 1);
        rectSettings(RiverCardStack, 1);







    }

}
