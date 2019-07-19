package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewGameGridPane {
    private Game game;
    private GameConsole gameConsole = new GameConsole();
    private MenuButtons leftMenuButtons = new MenuButtons(gameConsole);
    private GridPane newGameLayoutPane = new GridPane();
    private Scene newGameScene;
    private OneCardRectangle cardsStack = new OneCardRectangle();
    private ColumnConstraints column1 = new ColumnConstraints();
    private ColumnConstraints column2 = new ColumnConstraints();
    private ColumnConstraints column3 = new ColumnConstraints();
    private ColumnConstraints column4 = new ColumnConstraints();
    private ThreeCardsRectangle flopCardsRectangle = new ThreeCardsRectangle();
    private OneCardRectangle turnRectangle = new OneCardRectangle();
    private OneCardRectangle riverRectangle = new OneCardRectangle();
    private ThreeCardsRectangle playerCardsRectangle = new ThreeCardsRectangle();
    private ThreeCardsRectangle opponentCardsRectangle = new ThreeCardsRectangle();
    private Group cardsStackGroup = new Group();
    private Group playerCardsGroup = new Group();

    // stage > scene > pane > node



    public NewGameGridPane(Game game) {
        this.game = game;
        newGameLayoutPane.setMinSize(Main.sceneWidth, Main.sceneHeight);
        newGameLayoutPane.setPadding(new Insets(30, 5, 5, 30));
        newGameLayoutPane.setVgap(20);
        newGameLayoutPane.setHgap(20);
        newGameLayoutPane.setAlignment(Pos.CENTER);

        column1.setPercentWidth(20);
        column2.setPercentWidth(40);
        column3.setPercentWidth(10);
        column4.setPercentWidth(30);
        newGameLayoutPane.getColumnConstraints().addAll(column1, column2, column3, column4);

        cardsStackGroup.getChildren().add(cardsStack.getCardsStack());
        playerCardsGroup.getChildren().add(playerCardsRectangle.getThreeCardRectangle());
        GridPane.setHalignment(playerCardsGroup, HPos.RIGHT);
        GridPane.setHalignment(cardsStackGroup, HPos.CENTER);

        //lewa kolumna
        newGameLayoutPane.add(leftMenuButtons.getMenuButtons(), 0, 0);
        newGameLayoutPane.add(cardsStackGroup, 0 ,1);
        newGameLayoutPane.add(gameConsole.getHistoryConsole(), 0, 2);
        newGameLayoutPane.setStyle("-fx-background-color: green;");
        //srodkowa kolumna
        newGameLayoutPane.add(flopCardsRectangle.getThreeCardRectangle(), 1, 1);
        newGameLayoutPane.add(turnRectangle.getCardsStack(), 2, 1);
        newGameLayoutPane.add(riverRectangle.getCardsStack(), 3, 1);
        newGameLayoutPane.add(playerCardsGroup, 1, 2);
        newGameLayoutPane.add(opponentCardsRectangle.getThreeCardRectangle(), 1, 0);

        putDeckCardsOnItsPlace();
        putCardsToPlayersHands();



        newGameScene = new Scene(newGameLayoutPane, Main.sceneWidth, Main.sceneHeight);
        Stage newGameStage = new Stage();
        newGameStage.setTitle("New Game");
        newGameStage.setResizable(false);
        newGameStage.setScene(newGameScene);
        newGameStage.show();
    }

    public void putDeckCardsOnItsPlace() {
        for(Card card : this.game.getPlayingDeck().getDeckStack()) {
            this.cardsStackGroup.getChildren().add(card.getCardImageView());
        }
    }

    public void putCardsToPlayersHands() {
        double posX = 10;
        System.out.println(this.game.getPlayerList().getListOfPlayers().get(0).getPlayerCardsList().size());
        for(Card card : this.game.getPlayerList().getListOfPlayers().get(0).getPlayerCardsList()){
            System.out.println(card.toString());
            card.turnCard();
            card.getCardImageView().setTranslateX(posX);
            posX = posX + Main.cardWidth + 10;
            this.playerCardsGroup.getChildren().add(card.getCardImageView());
        }

    }




}
