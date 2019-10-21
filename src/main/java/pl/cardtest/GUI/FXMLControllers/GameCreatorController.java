package pl.cardtest.GUI.FXMLControllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.cardtest.Game;

public class GameCreatorController {
    public Button exitButton;
    public TextField startingCashText;
    public TextField oppsAmountText;
    public TextField playersNameText;

    public GameCreatorController() {
    }

    @FXML
    public void initialize() {
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
            }
        });


        playersNameText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(t1.length() > 16) playersNameText.setText(t1.substring(0, 16));
            }
        });



    }

    public void exit(ActionEvent actionEvent) {
        var stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void newGame(ActionEvent actionEvent) throws Exception {
        int opps = Integer.parseInt(oppsAmountText.getText());
        int startingCash = Integer.parseInt(startingCashText.getText());
        new Game(opps, playersNameText.getText(), startingCash);
    }
}
