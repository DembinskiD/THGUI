package pl.cardtest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameCreator {
    int opponentsAmount;
    String playerName;
    int startingCash;


    public GameCreator(int opponentsAmount, String playerName, int startingCash) {
        this.opponentsAmount = opponentsAmount;
        this.playerName = playerName;
        this.startingCash = startingCash;
    }

    //argumentless constructor takes default values that has to be changed within GUI
    public GameCreator() throws IOException {
        this.opponentsAmount = 1;
        this.playerName = "player";
        this.startingCash = 200;

        Parent root = FXMLLoader.load(this.getClass().getResource("/FXMLs/GameCreator.fxml"));
        Scene createGameScene = new Scene(root, 400, 400);
        createGameScene.getStylesheets().add("StyleSheets/SceneStyle.css");
        Stage createGameStage = new Stage();
        createGameStage.getIcons().add(new Image("icon.png"));
        createGameStage.setTitle("TexasHoldEm - Create game");
        createGameStage.setResizable(false);
        createGameStage.setScene(createGameScene);
        createGameStage.initStyle(StageStyle.UTILITY);
        createGameStage.setResizable(false);
        createGameStage.show();
    }

    public int getOpponentsAmount() {
        return opponentsAmount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getStartingCash() {
        return startingCash;
    }

    public void setOpponentsAmount(int opponentsAmount) {
        this.opponentsAmount = opponentsAmount;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setStartingCash(int startingCash) {
        this.startingCash = startingCash;
    }
}
