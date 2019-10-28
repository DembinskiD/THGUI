package pl.cardtest.GUI.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.cardtest.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class OptionsMenuController implements Initializable {
    public ImageView view1;
    public ImageView view2;
    public ImageView view3;
    public ImageView view4;
    public ImageView view5;
    public ImageView view6;
    public ToggleGroup toggleGroup;
    public Button applyButton;
    public Button applyAndExitButton;
    public Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.readDataFromFile();
        view1.setFitHeight(Main.optionsCardHeight);
        view1.setFitWidth(Main.optionsCardWidth);
        view2.setFitHeight(Main.optionsCardHeight);
        view2.setFitWidth(Main.optionsCardWidth);
        view3.setFitHeight(Main.optionsCardHeight);
        view3.setFitWidth(Main.optionsCardWidth);
        view4.setFitHeight(Main.optionsCardHeight);
        view4.setFitWidth(Main.optionsCardWidth);
        view5.setFitHeight(Main.optionsCardHeight);
        view5.setFitWidth(Main.optionsCardWidth);
        view6.setFitHeight(Main.optionsCardHeight);
        view6.setFitWidth(Main.optionsCardWidth);

        //read chosen background and use it as selected toggle
        for (int i = 0; i < toggleGroup.getToggles().size(); i++) {
            RadioButton tempRB = (RadioButton) toggleGroup.getToggles().get(i);
            if(Main.cardRewers.contains(tempRB.getId())) {
                toggleGroup.selectToggle(toggleGroup.getToggles().get(i));
                break;
            }
        }

    }

    public void exitButtonAction(ActionEvent actionEvent) {
        Stage scene = (Stage) exitButton.getScene().getWindow();
        scene.close();
    }

    public void applyButtonAction(ActionEvent actionEvent) throws IOException {
        File datFile = new File("creatorData.dat");
        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
        String text = String.valueOf(rb.getId()) + ".png";
        Main.cardRewers = text;
        Main.saveDataToFile();
    }

    public void applyAndExitButtonAction(ActionEvent actionEvent) throws IOException {
        applyButtonAction(actionEvent);
        exitButtonAction(actionEvent);
    }


}
