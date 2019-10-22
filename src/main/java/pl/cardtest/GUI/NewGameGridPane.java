package pl.cardtest.GUI;

import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.cardtest.Card;
import pl.cardtest.Game;
import pl.cardtest.GameState;
import pl.cardtest.Main;

import java.io.IOException;

public class NewGameGridPane {
    private final Game game;
    private GameConsole gameConsole = new GameConsole();
    public MenuButtons leftMenuButtons = new MenuButtons(this, gameConsole);





    // stage > scene > pane > node



    public NewGameGridPane(Game game) throws Exception {
        this.game = game;
        GridPane newGameLayoutPane = new GridPane();
        newGameLayoutPane.setMinSize(Main.sceneWidth, Main.sceneHeight); //do ustawienia w inicjatorze kontrolera FXML






    }

    public MenuButtons getLeftMenuButtons() {
        return leftMenuButtons;
    }

    public Game getGame() {
        return game;
    }


    public Label getRaiseAmountLabel() {
        return leftMenuButtons.raiseAmountLabel;
    }

    public Button getDecreaseRaiseButton() {
        return leftMenuButtons.decreaseRaiseButton;
    }

    public Button getIncreaseRaiseButton() {
        return leftMenuButtons.increaseRaiseButton;
    }

    public Button getAllInButton() {
        return leftMenuButtons.allInButton;
    }

    public Button getPassButton() {
        return leftMenuButtons.passButton;
    }

    public Button getCallButton() {
        return leftMenuButtons.callButton;
    }

    public Button getRaiseButton() {
        return leftMenuButtons.raiseButton;
    }

}
