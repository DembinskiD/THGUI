package pl.cardtest.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class OptionsClass {
    private final Scene optionsScene;

    public OptionsClass() throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/FXMLs/OptionsMenu.fxml"));
        optionsScene = new Scene(root, 400, 400);
        Stage optionsStage = new Stage();
        optionsStage.getIcons().add(new Image("icon.png"));
        optionsStage.setTitle("TexasHoldEm - Options");
        optionsStage.setResizable(false);
        optionsStage.setScene(optionsScene);
        optionsStage.show();
    }
}
