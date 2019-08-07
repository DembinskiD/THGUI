package pl.cardtest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.cardtest.GUI.OptionsClass;


public class Main extends Application {
    //rozmiary sceny i kart
    public static final int sceneWidth = 1000;
    public static final int sceneHeight = 600;
    private static final int optionsSceneHeight = 480;
    public static final int cardHeight = sceneHeight/4;
    public static final double cardWidth = cardHeight/1.7;
    public static final int optionsCardHeight = optionsSceneHeight/7;
    public static final double optionsCardWidth = optionsCardHeight/1.7;



    public static String cardRewers = "blue_back.png";

// stage > scene > pane > node
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Texas Hold'em");
        Button exitBtn = new Button("Exit");
        Button newGameBtn = new Button("New Game");
        Button optionsBtn = new Button("Options");
        //Button actions
        exitBtn.setOnAction(event -> primaryStage.close());
        newGameBtn.setOnAction(event -> new Game());
        optionsBtn.setOnAction(event -> new OptionsClass());
        VBox pane = new VBox(10);
        Image image = new Image("main_menu_logo.png");
        ImageView logoView = new ImageView(image);
        Scene scene = new Scene(pane, 500, 500);
        pane.setStyle("-fx-background-color: green;");
        pane.getChildren().addAll(logoView, newGameBtn, optionsBtn, exitBtn);
        pane.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
