package pl.cardtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


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
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Texas Hold'em");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXMLs/MainMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
