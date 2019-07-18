package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

// stage > scene > pane > node
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Texas Hold'em");
        Button exitBtn = new Button("Exit");
        Button newGameBtn = new Button("New Game");
        //Button actions
        exitBtn.setOnAction(event -> primaryStage.close());
        //newGameBtn.setOnAction(event -> newGameScene());
        newGameBtn.setOnAction(event -> new NewGameGridPane());
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
        GameConsole historyConsole = new GameConsole();

        //przyciski gry
        MenuButtons gameMenuButtons = new MenuButtons(historyConsole);



        //TODO: zrobic animacje krążka dla rozdajacego gracza, animacja pod przyciskiem startGame
        /*Circle circle = new Circle(20, Color.RED);
        Path path = new Path();
        path.getElements().addAll(new MoveTo(0,0), new LineTo(300, 300));
        path.setBlendMode(BlendMode.ADD);
        PathTransition pt = new PathTransition(Duration.millis(400), path, circle);
        pt.setCycleCount(1);
        pt.setAutoReverse(false);*/


        //dodanie node 'ów do pane 'a
        newGamePane.getChildren().addAll(
                deckStackRectangle,
                flopCardsRectangle,
                turnCardsRectangle,
                riverCardsRectangle,
                oponentCardsRectangle,
                playerCardsRectangle,
                gameMenuButtons.getMenuButtons(),
                historyConsole.getHistoryConsole());

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
