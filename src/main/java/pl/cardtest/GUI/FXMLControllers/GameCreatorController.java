package pl.cardtest.GUI.FXMLControllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.cardtest.Main;


public class GameCreatorController {
    @FXML public Button exitButton;
    @FXML public TextField startingCashText;
    @FXML public TextField oppsAmountText;
    @FXML public TextField playersNameText;
    @FXML public TextField blindCashText;
    private int startingCash;
    private int oppsAmount;
    private String playersName;
    private int blindCash;

    public GameCreatorController(int startingCash, int oppsAmount, String playersName, int blindCash) {
        this.startingCash = startingCash;
        this.oppsAmount = oppsAmount;
        this.playersName = playersName;
        this.blindCash = blindCash;
    }

    @FXML
    public void initialize() {
        this.startingCashText.setText(String.valueOf(startingCash));
        this.oppsAmountText.setText(String.valueOf(oppsAmount));
        this.playersNameText.setText(playersName);
        this.blindCashText.setText(String.valueOf(blindCash));

        //force field to be numeric only
        startingCashText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    startingCashText.setText(newValue.replaceAll("[^\\d]", ""));
                }
                //limit field to be max 3 digits long
                if (newValue.length() > 3) {
                    startingCashText.setText(newValue.substring(0, 3));
                }
            }
        });

        oppsAmountText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    oppsAmountText.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 1) {
                    oppsAmountText.setText(newValue.substring(0, 1));
                }
                if (!newValue.equals("1")) {
                    oppsAmountText.setText("1");
                }
            }
        });

        blindCashText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    blindCashText.setText(t1.replaceAll("[^\\d]", ""));
                } if (t1.length() > 2) {
                    blindCashText.setText(t1.substring(0, 2));
                }
            }
        });


        playersNameText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(t1.length() > 16) playersNameText.setText(t1.substring(0, 16));
            }
        });

        this.oppsAmountText.setDisable(true); //todo oppsAmountText jest wylaczony tymczasowo(zmienione po wprowadzeniu wiekszej ilosci graczy)

    }

    public void exit(ActionEvent actionEvent) {
        var stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void newGame(ActionEvent actionEvent) throws Exception {
        int opps = Integer.parseInt(oppsAmountText.getText());
        int startingCash = Integer.parseInt(startingCashText.getText());
        int startingBlind = Integer.parseInt(blindCashText.getText());
        //todo dodać w tym miejscu zapis do pliku
        NewGameController gameController = new NewGameController(opps, playersNameText.getText(), startingCash, startingBlind);
        Main.saveDataToFile();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLs/NewGame.fxml"));
        loader.setController(gameController);
        GridPane gridPane = loader.load();
        Scene newGameScene = new Scene(gridPane, Main.sceneWidth, Main.sceneHeight);
        newGameScene.getStylesheets().add("StyleSheets/SceneStyle.css");
        Stage newGameStage = new Stage();
        newGameStage.getIcons().add(new Image("icon.png"));
        newGameStage.setTitle("TexasHoldEm - New Game");
        //newGameStage.setResizable(false);
        newGameStage.setScene(newGameScene);
        newGameStage.setMaximized(true);
        newGameStage.show();
    }
}
