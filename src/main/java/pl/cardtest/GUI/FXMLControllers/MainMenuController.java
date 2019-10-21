package pl.cardtest.GUI.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.cardtest.GUI.OptionsClass;
import pl.cardtest.GameCreator;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    public Button newGameButton;
    public Button optionsButton;
    public Button exitButton;

    public void startNewGame(ActionEvent actionEvent) throws Exception {
        new GameCreator();
    }

    public void openOptions(ActionEvent actionEvent) throws Exception {
        new OptionsClass();
    }

    public void exitGame(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initializing...");

    }
}
