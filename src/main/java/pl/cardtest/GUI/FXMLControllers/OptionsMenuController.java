package pl.cardtest.GUI.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.cardtest.Main;

import java.net.URL;
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

    }

    public void exitButtonAction(ActionEvent actionEvent) {
        Stage scene = (Stage) exitButton.getScene().getWindow();
        scene.close();
    }

    public void applyButtonAction(ActionEvent actionEvent) {
        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
        String text = String.valueOf(rb.getId()) + ".png";
        Main.cardRewers = text;
    }

    public void applyAndExitButtonAction(ActionEvent actionEvent) {
        applyButtonAction(actionEvent);
        exitButtonAction(actionEvent);
    }


}
