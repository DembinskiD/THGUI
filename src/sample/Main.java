package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
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


        //przyciski gry
        Button startGame = new Button("Start Game");
        Button callButton = new Button("Call");
        Button raiseButton = new Button("Raise");
        Button passButton = new Button("Pass");
        ScrollBar raiseBar = new ScrollBar();
        Label raiseLabel = new Label();
        Button lowerBetButton = new Button("-");
        Button higherBetButton = new Button("+");
        Label betLabel = new Label();
        Group betGroup = new Group();
        HBox box = new HBox();


        box.getChildren().addAll(lowerBetButton, betLabel, higherBetButton, callButton);
        betLabel.setMinWidth(10);
        int betValue = 10 ;
        betLabel.setText(String.valueOf(betValue));
        betGroup.getChildren().add(box);
        betGroup.setLayoutX(50);
        betGroup.setLayoutY(sceneHeight/2 + cardHeight/2 + 60);


        startGame.setLayoutX(50);
        startGame.setLayoutY(sceneHeight/2 + cardHeight/2 + 20);

        callButton.setLayoutX(50);
        callButton.setLayoutY(sceneHeight/2 + cardHeight/2 + 60);

        raiseButton.setLayoutX(50);
        raiseButton.setLayoutY(sceneHeight/2 + cardHeight/2 + 100);

        passButton.setLayoutX(50);
        passButton.setLayoutY(sceneHeight/2 + cardHeight/2 + 140);

        raiseLabel.setText(String.valueOf(raiseBar.getValue()));
        raiseLabel.setLayoutY(passButton.getLayoutY());
        raiseLabel.setLayoutX(100);

        raiseBar.setOrientation(Orientation.HORIZONTAL);
        raiseBar.setLayoutX(50);
        raiseBar.setLayoutY(sceneHeight/2 + cardHeight/2 + 180);
        raiseBar.setBlockIncrement(10);
        raiseBar.setUnitIncrement(10);
        raiseBar.setMin(10);
        raiseBar.setMax(100);
        raiseBar.setValue(10);

        lowerBetButton.setOnAction(event -> {
            int s = Integer.valueOf(betLabel.getText());
            if(s > 10) {
                s -=  10;
                betLabel.setText(String.valueOf(s));
            }
        });

        higherBetButton.setOnAction(event -> {
            int s = Integer.valueOf(betLabel.getText());
            if(s < 100) {
                s += 10;
                betLabel.setText(String.valueOf(s));
            }
        });

        raiseBar.valueProperty().addListener((observable, old_val, new_val) -> {
            int intValueOfNewVal = new_val.intValue();
            intValueOfNewVal = intValueOfNewVal - intValueOfNewVal%10;
            raiseLabel.setText(Integer.toString(intValueOfNewVal));
            System.out.println(intValueOfNewVal);
        });



        //dodanie node 'ów do pane 'a

        newGamePane.getChildren().add(deckStackRectangle);
        newGamePane.getChildren().add(flopCardsRectangle);
        newGamePane.getChildren().add(turnCardsRectangle);
        newGamePane.getChildren().add(riverCardsRectangle);
        newGamePane.getChildren().add(oponentCardsRectangle);
        newGamePane.getChildren().add(playerCardsRectangle);
        newGamePane.getChildren().add(startGame);
        newGamePane.getChildren().add(betGroup);
        //newGamePane.getChildren().add(callButton);
        newGamePane.getChildren().add(raiseButton);
        newGamePane.getChildren().add(passButton);
        newGamePane.getChildren().add(raiseBar);
        newGamePane.getChildren().add(raiseLabel);

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
