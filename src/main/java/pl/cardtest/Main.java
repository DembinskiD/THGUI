package pl.cardtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main extends Application {
    //rozmiary sceny i kart
    public static final int sceneWidth = 1000;
    public static final int sceneHeight = 600;
    private static final int optionsSceneHeight = 480;
    public static final int cardHeight = sceneHeight/4;
    public static final double cardWidth = cardHeight/1.7;
    public static final int optionsCardHeight = optionsSceneHeight/7;
    public static final double optionsCardWidth = optionsCardHeight/1.7;
    //zmienne wymagane do rozgrywki, default values here
    public static String playerName = "player";
    public static int initialPlayerCash = 400;
    public static int smallBlind = 20;
    public static  int opponentsAmount = 1;
    public static String cardRewers = "blue_back.png";
    public static String datFileName = "creatorData.dat";


    public static void saveDataToFile()  {
        File datFile = new File(Main.datFileName);
        PrintWriter datWriter;
        try {
            datWriter = new PrintWriter(datFile);
            datWriter.println(cardRewers);
            datWriter.println(Main.opponentsAmount + ":" +
                    Main.playerName + ":" +
                    Main.initialPlayerCash + ":" +
                    Main.smallBlind);
            datWriter.close();
        } catch (FileNotFoundException e) {
            try {
                datFile.createNewFile();
                saveDataToFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void readDataFromFile() {
        File datFile = new File(Main.datFileName);
        String[] tempArray;
        try {
            Main.cardRewers = Files.readAllLines(Paths.get(String.valueOf(datFile))).get(0);
            tempArray = Files.readAllLines(Paths.get(String.valueOf(datFile))).get(1).split(":");
            Main.opponentsAmount = Integer.parseInt(tempArray[0]);
            Main.playerName = tempArray[1];
            Main.initialPlayerCash = Integer.parseInt(tempArray[2]);
            Main.smallBlind = Integer.parseInt(tempArray[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
