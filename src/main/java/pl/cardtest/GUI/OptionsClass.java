package pl.cardtest.GUI;

import pl.cardtest.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionsClass {
    private final Scene optionsScene;
    private final StackPane optionsPane;
    public OptionsClass() {
        optionsPane = new StackPane();
        optionsPane.setStyle("-fx-background-color: green;");
        VBox options = new VBox();
        HBox reversList = new HBox();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        VBox column3 = new VBox();
        VBox column4 = new VBox();
        VBox column5 = new VBox();
        VBox column6 = new VBox();
        HBox buttons = new HBox();
        Button applyButton = new Button("Apply");
        Button exitButton = new Button("Exit");
        Button applyAndExit = new Button("Apply/Exit");

        reversList.getChildren().addAll(column1, column2, column3, column4, column5, column6);



        ImageView column1View = new ImageView("blue_back.png");
        column1View.setFitWidth(Main.optionsCardWidth);
        column1View.setFitHeight(Main.optionsCardHeight);
        ImageView column2View = new ImageView("gray_back.png");
        column2View.setFitWidth(Main.optionsCardWidth);
        column2View.setFitHeight(Main.optionsCardHeight);
        ImageView column3View = new ImageView("green_back.png");
        column3View.setFitWidth(Main.optionsCardWidth);
        column3View.setFitHeight(Main.optionsCardHeight);
        ImageView column4View = new ImageView("purple_back.png");
        column4View.setFitWidth(Main.optionsCardWidth);
        column4View.setFitHeight(Main.optionsCardHeight);
        ImageView column5View = new ImageView("red_back.png");
        column5View.setFitWidth(Main.optionsCardWidth);
        column5View.setFitHeight(Main.optionsCardHeight);
        ImageView column6View = new ImageView("yellow_back.png");
        column6View.setFitWidth(Main.optionsCardWidth);
        column6View.setFitHeight(Main.optionsCardHeight);
        ToggleGroup buttonsGroup = new ToggleGroup();

        RadioButton[] radioButtons = new RadioButton[6];
        for(int i = 0 ; i < 6 ; i++) radioButtons[i] = new RadioButton();
        for(RadioButton rb : radioButtons){
            rb.setToggleGroup(buttonsGroup);
        }

        radioButtons[0].setUserData("blue");
        radioButtons[1].setUserData("gray");
        radioButtons[2].setUserData("green");
        radioButtons[3].setUserData("purple");
        radioButtons[4].setUserData("red");
        radioButtons[5].setUserData("yellow");





        column1.getChildren().addAll(column1View, radioButtons[0]);
        column2.getChildren().addAll(column2View, radioButtons[1]);
        column3.getChildren().addAll(column3View, radioButtons[2]);
        column4.getChildren().addAll(column4View, radioButtons[3]);
        column5.getChildren().addAll(column5View, radioButtons[4]);
        column6.getChildren().addAll(column6View, radioButtons[5]);






        reversList.setSpacing(10);
        reversList.setAlignment(Pos.CENTER);

        buttons.getChildren().addAll(applyButton, applyAndExit, exitButton);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);


        options.setAlignment(Pos.CENTER);
        options.setSpacing(20);
        options.getChildren().addAll(reversList, buttons);


        optionsPane.getChildren().add(options);






        optionsScene = new Scene(optionsPane, 400, 400);
        Stage optionsStage = new Stage();
        optionsStage.getIcons().add(new Image("icon.png"));
        optionsStage.setTitle("TexasHoldEm - Options");
        optionsStage.setResizable(false);
        optionsStage.setScene(optionsScene);
        optionsStage.show();

        applyButton.setOnAction(event -> {
            if(buttonsGroup.getSelectedToggle() != null){
                Main.cardRewers = buttonsGroup.getSelectedToggle().getUserData().toString() + "_back.png";
            }
        });

        applyAndExit.setOnAction(event -> {
            if(buttonsGroup.getSelectedToggle() != null){
                Main.cardRewers = buttonsGroup.getSelectedToggle().getUserData().toString() + "_back.png";
                optionsStage.close();
            }
        });

        exitButton.setOnAction(event -> optionsStage.close());
    }
}
