package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewGameGridPane {
    private GameConsole gameConsole = new GameConsole();
    private MenuButtons leftMenuButtons = new MenuButtons(gameConsole);
    private GridPane newGameLayoutPane = new GridPane();
    private Scene newGameScene;
    private OneCardRectangle cardsStack = new OneCardRectangle();
    private ColumnConstraints column1 = new ColumnConstraints();
    private ColumnConstraints column2 = new ColumnConstraints();
    private ColumnConstraints column3 = new ColumnConstraints();
    private ColumnConstraints column4 = new ColumnConstraints();
    private FlopRectangle flopRectangle = new FlopRectangle();
    private OneCardRectangle turnRectangle = new OneCardRectangle();
    private OneCardRectangle riverRectangle = new OneCardRectangle();

    // stage > scene > pane > node



    public NewGameGridPane() {
        newGameLayoutPane.setMinSize(Main.sceneWidth, Main.sceneHeight);
        newGameLayoutPane.setPadding(new Insets(5, 5, 5, 5));
        newGameLayoutPane.setVgap(50);
        newGameLayoutPane.setHgap(50);
        newGameLayoutPane.setAlignment(Pos.CENTER);

        column1.setPercentWidth(20);
        column2.setPercentWidth(60);
        column3.setPercentWidth(10);
        column4.setPercentWidth(10);

        newGameLayoutPane.getColumnConstraints().addAll(column1, column2, column3, column4);

        GridPane.setHalignment(cardsStack.getCardsStack(), HPos.CENTER);
        GridPane.setHalignment(leftMenuButtons.getMenuButtons(), HPos.CENTER);
        GridPane.setHalignment(gameConsole.getHistoryConsole(), HPos.CENTER);
        GridPane.setHalignment(flopRectangle.getFlopRectangle(), HPos.CENTER);
        GridPane.setHalignment(turnRectangle.getCardsStack(), HPos.CENTER);
        GridPane.setHalignment(riverRectangle.getCardsStack(), HPos.CENTER);
        //lewa kolumna
        newGameLayoutPane.add(leftMenuButtons.getMenuButtons(), 0, 0);
        newGameLayoutPane.add(cardsStack.getCardsStack(), 0 ,1);
        newGameLayoutPane.add(gameConsole.getHistoryConsole(), 0, 2);
        newGameLayoutPane.setStyle("-fx-background-color: green;");
        //srodkowa kolumna
        newGameLayoutPane.add(flopRectangle.getFlopRectangle(), 1, 1);
        newGameLayoutPane.add(turnRectangle.getCardsStack(), 2, 1);
        newGameLayoutPane.add(riverRectangle.getCardsStack(), 3, 1);



        newGameScene = new Scene(newGameLayoutPane, Main.sceneWidth, Main.sceneHeight);
        Stage newGameStage = new Stage();
        newGameStage.setTitle("New Game");
        newGameStage.setResizable(false);
        newGameStage.setScene(newGameScene);
        newGameStage.show();
    }


}
