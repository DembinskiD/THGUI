package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;





public class Main extends Application {
    //rozmiary sceny i kart
    static int sceneWidth = 1000;
    static int sceneHeight = 600;
    static int cardHeight = sceneHeight/4;
    static double cardWidth = cardHeight/1.7;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Texas Hold'em");
        Button exitBtn = new Button("Exit");
        Button newGameBtn = new Button("New Game");
        //Button actions
        exitBtn.setOnAction(event -> primaryStage.close());
        newGameBtn.setOnAction(event -> newGameScene());
        VBox pane = new VBox(10);
        Image image = new Image("https://cdn.howtoplay.org/wp-content/uploads/2016/03/Texas-Holdem-logo.png");
        ImageView logoView = new ImageView(image);
        Scene scene = new Scene(pane, 500, 500);
        pane.setStyle("-fx-background-color: green;");
        pane.getChildren().addAll(logoView, newGameBtn, exitBtn);
        pane.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void newGameScene() {
        Deck dck = new Deck();
        Stage newGameStage = new Stage();
        newGameStage.setTitle("New Game");
        newGameStage.setResizable(false);
        Pane newGamePane = new Pane();

       /* dck.deckStack.peek().getCardBackImageView().setLayoutX(10);
        dck.deckStack.peek().getCardBackImageView().setLayoutY(10);
        newGamePane.getChildren().add(dck.deckStack.pop().getCardBackImageView());

        dck.deckStack.peek().getCardBackImageView().setLayoutX(7);
        dck.deckStack.peek().getCardBackImageView().setLayoutY(7);
        newGamePane.getChildren().add(dck.deckStack.pop().getCardBackImageView());

        dck.deckStack.peek().getCardBackImageView().setLayoutX(4);
        dck.deckStack.peek().getCardBackImageView().setLayoutY(4);
        newGamePane.getChildren().add(dck.deckStack.pop().getCardBackImageView());

        dck.deckStack.peek().getCardBackImageView().setLayoutX(1);
        dck.deckStack.peek().getCardBackImageView().setLayoutY(1);
        newGamePane.getChildren().add(dck.deckStack.pop().getCardBackImageView());
        */


        //stos kart obróconych koszulką do góry, do dobierania kart
        Rectangle deckStackRectangle = new Rectangle();
        setDeckStackRectangle(deckStackRectangle);

        //pole na karty z flop,turn,river
        Rectangle flopCardsRectangle = new Rectangle();
        setflopRectangles(flopCardsRectangle, 200, sceneHeight/2 - cardHeight/2);

        Rectangle turnCardsRectangle = new Rectangle();
        setTurnRectangles(turnCardsRectangle, (int)(flopCardsRectangle.getX() + (3*cardWidth + 60) + 20), sceneHeight/2 - cardHeight/2);

        Rectangle riverCardsRectangle = new Rectangle();
        setRiverRectangles(riverCardsRectangle, (int) (turnCardsRectangle.getX() + cardWidth + 40), sceneHeight/2 - cardHeight/2);

        //miejsce na karty przeciwnika
        Rectangle oponentCardsRectangle = new Rectangle();
        setCardRectangles(oponentCardsRectangle, 200, 20);

        //miejsce na karty gracza
        Rectangle playerCardsRectangle = new Rectangle();
        setCardRectangles(playerCardsRectangle, 200, sceneHeight - cardHeight - 20);

        //game history
        ScrollPane historyPane = new ScrollPane();


        //przyciski gry
        Button startGame = new Button("Start Game");
        Button callButton = new Button("Call");
        Button raiseButton = new Button("Raise");
        Button passButton = new Button("Pass");
        Button lowerBetButton = new Button("-");
        Button higherBetButton = new Button("+");
        Button AllInButton = new Button("All in");
        Label betLabel = new Label();
        Group betGroup = new Group();
        HBox betBox = new HBox();
        VBox menu = new VBox();

        betBox.getChildren().addAll(lowerBetButton, betLabel, higherBetButton, raiseButton, AllInButton);
        betBox.setSpacing(3);
        menu.getChildren().addAll(startGame, betGroup, callButton, passButton);
        menu.setLayoutX(30);
        menu.setLayoutY(20);
        menu.setSpacing(5);
        menu.setAlignment(Pos.CENTER);

        betLabel.setMinWidth(10);
        int betValue = 10 ;
        betLabel.setText(String.valueOf(betValue));
        betGroup.getChildren().add(betBox);

        //pozycjonowanie przycisków
        /*betGroup.setLayoutX(30);
        betGroup.setLayoutY(100);
        startGame.setLayoutX(30);
        startGame.setLayoutY(20);
        callButton.setLayoutX(30);
        callButton.setLayoutY(60);
        passButton.setLayoutX(30);
        passButton.setLayoutY(140);*/

        lowerBetButton.setOnAction(event -> {
            int s = Integer.valueOf(betLabel.getText());
            if(s > 10) {
                s -=  10;
                betLabel.setText(String.valueOf(s));
                System.out.println("Value to call: " + s);
            }
        });

        higherBetButton.setOnAction(event -> {
            int s = Integer.valueOf(betLabel.getText());
            if(s < 100) {
                s += 10;
                betLabel.setText(String.valueOf(s));
                System.out.println("Value to call: " + s);
            }
        });

        AllInButton.setOnAction(event -> {
            betLabel.setText(String.valueOf(100));
            System.out.println("Calling All in");
        });




        //dodanie node 'ów do pane 'a

        newGamePane.getChildren().add(deckStackRectangle);
        newGamePane.getChildren().add(flopCardsRectangle);
        newGamePane.getChildren().add(turnCardsRectangle);
        newGamePane.getChildren().add(riverCardsRectangle);
        newGamePane.getChildren().add(oponentCardsRectangle);
        newGamePane.getChildren().add(playerCardsRectangle);
        newGamePane.getChildren().add(menu);
        newGamePane.getChildren().add(historyPane);
        /*newGamePane.getChildren().add(betGroup);
        newGamePane.getChildren().add(callButton);
        newGamePane.getChildren().add(passButton);*/


        Scene newGameScene = new Scene(newGamePane, sceneWidth, sceneHeight);
        newGamePane.setStyle("-fx-background-color: green;");
        newGameStage.setScene(newGameScene);
        newGameStage.show();
    }

    public void setDeckStackRectangle(Rectangle rect){
        rect.setX(50);
        rect.setY(sceneHeight/2 - cardHeight/2);
        rect.setWidth(cardWidth);
        rect.setHeight(cardHeight);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0,100,0));
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setStroke(Color.BLACK);
    }

    public void setflopRectangles(Rectangle rect, int X, int Y){
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth(3*cardWidth + 60);
        rect.setHeight(cardHeight);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0,100,0));
        rect.setStroke(Color.BLACK);
        rect.setStrokeType(StrokeType.INSIDE);
    }

    public void setTurnRectangles(Rectangle rect, int X, int Y){
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth(cardWidth + 20);
        rect.setHeight(cardHeight);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0,100,0));
        rect.setStroke(Color.BLACK);
        rect.setStrokeType(StrokeType.INSIDE);
    }

    public void setRiverRectangles(Rectangle rect, int X, int Y){
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth(cardWidth + 20);
        rect.setHeight(cardHeight);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0,100,0));
        rect.setStroke(Color.BLACK);
        rect.setStrokeType(StrokeType.INSIDE);
    }


    public void setCardRectangles(Rectangle rect, int X, int Y){
        rect.setX(X);
        rect.setY(Y);
        rect.setWidth(780);
        rect.setHeight(cardHeight);
        rect.setArcWidth(20);
        rect.setArcHeight(20);
        rect.setFill(Color.rgb(0,100,0));
        rect.setStroke(Color.BLACK);
        rect.setStrokeType(StrokeType.INSIDE);
    }





    public static void main(String[] args) {
        launch(args);
    }
}
