package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionsClass {
    Scene optionsScene;
    Pane optionsPane;
    public OptionsClass() {
        optionsPane = new Pane();
        optionsPane.setStyle("-fx-background-color: green;");
        HBox optionsMenu = new HBox();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        VBox column3 = new VBox();
        VBox column4 = new VBox();
        VBox column5 = new VBox();
        VBox column6 = new VBox();
        optionsMenu.getChildren().addAll(column1, column2, column3, column4, column5, column6);
        ImageView column1View = new ImageView("sample/Graphics/blue_back.png");
        column1View.setFitWidth(Main.cardWidth);
        column1View.setFitHeight(Main.cardHeight);
        ImageView column2View = new ImageView("sample/Graphics/gray_back.png");
        column2View.setFitWidth(Main.cardWidth);
        column2View.setFitHeight(Main.cardHeight);
        ImageView column3View = new ImageView("sample/Graphics/green_back.png");
        column3View.setFitWidth(Main.cardWidth);
        column3View.setFitHeight(Main.cardHeight);
        ImageView column4View = new ImageView("sample/Graphics/purple_back.png");
        column4View.setFitWidth(Main.cardWidth);
        column4View.setFitHeight(Main.cardHeight);
        ImageView column5View = new ImageView("sample/Graphics/red_back.png");
        column5View.setFitWidth(Main.cardWidth);
        column5View.setFitHeight(Main.cardHeight);
        ImageView column6View = new ImageView("sample/Graphics/yellow_back.png");
        column6View.setFitWidth(Main.cardWidth);
        column6View.setFitHeight(Main.cardHeight);

        column2.getChildren().add(column1View);
        column3.getChildren().add(column2View);
        column4.getChildren().add(column3View);
        column5.getChildren().add(column4View);
        column6.getChildren().add(column5View);
        column1.getChildren().add(column6View);


        optionsPane.getChildren().add(optionsMenu);




        optionsScene = new Scene(optionsPane, 400, 400);
        Stage newGameStage = new Stage();
        newGameStage.getIcons().add(new Image("http://www.iconninja.com/files/281/254/528/poker-icon.png"));
        newGameStage.setTitle("TexasHoldEm - Options");
        newGameStage.setResizable(false);
        newGameStage.setScene(optionsScene);
        newGameStage.show();
    }
}
