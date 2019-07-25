package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    //rozmiary sceny i kart
    static int sceneWidth = 1000;
    static int sceneHeight = 600;
    static int optionsSceneWidth = 640;
    static int optionsSceneHeight = 480;
    static int cardHeight = sceneHeight/4;
    static double cardWidth = cardHeight/1.7;
    static int optionsCardHeight = optionsSceneHeight/7;
    static double optionsCardWidth = optionsCardHeight/1.7;



    static String cardRewers = "sample/Graphics/blue_back.png";

// stage > scene > pane > node
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Texas Hold'em");
        Button exitBtn = new Button("Exit");
        Button newGameBtn = new Button("New Game");
        Button optionsBtn = new Button("Options");
        //Button actions
        exitBtn.setOnAction(event -> primaryStage.close());
        newGameBtn.setOnAction(event -> new Game());
        optionsBtn.setOnAction(event -> new OptionsClass());
        VBox pane = new VBox(10);
        Image image = new Image("https://cdn.howtoplay.org/wp-content/uploads/2016/03/Texas-Holdem-logo.png");
        ImageView logoView = new ImageView(image);
        Scene scene = new Scene(pane, 500, 500);
        pane.setStyle("-fx-background-color: green;");
        pane.getChildren().addAll(logoView, newGameBtn, optionsBtn, exitBtn);
        pane.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("http://www.iconninja.com/files/281/254/528/poker-icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
