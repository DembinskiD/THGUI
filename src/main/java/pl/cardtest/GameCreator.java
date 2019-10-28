package pl.cardtest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.cardtest.GUI.FXMLControllers.GameCreatorController;

import java.io.IOException;

public class GameCreator {

    //argumentless constructor takes default values that has to be changed within GUI
    public GameCreator() throws IOException {
        Main.readDataFromFile();


        GameCreatorController gameCreatorController = new GameCreatorController(Main.initialPlayerCash, Main.opponentsAmount, Main.playerName, Main.smallBlind);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/GameCreator.fxml"));
        loader.setController(gameCreatorController);
        GridPane gridPane = loader.load();
        Scene createGameScene = new Scene(gridPane, Main.sceneWidth, Main.sceneHeight);
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


}
