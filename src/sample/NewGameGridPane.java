package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewGameGridPane {
    private Game game;
    private GameConsole gameConsole = new GameConsole();
    private MenuButtons leftMenuButtons = new MenuButtons(this, gameConsole);
    private GridPane newGameLayoutPane = new GridPane();
    private Scene newGameScene;
    private OneCardRectangle cardsStack = new OneCardRectangle();
    private ColumnConstraints column1 = new ColumnConstraints();
    private ColumnConstraints column2 = new ColumnConstraints();
    private ColumnConstraints column3 = new ColumnConstraints();
    private ColumnConstraints column4 = new ColumnConstraints();
    private FlopRectangle flopCardsRectangle = new FlopRectangle();
    private OneCardRectangle turnRectangle = new OneCardRectangle();
    private OneCardRectangle riverRectangle = new OneCardRectangle();
    private PlayersCardsRectangle playerCardsRectangle = new PlayersCardsRectangle();
    private PlayersCardsRectangle opponentCardsRectangle = new PlayersCardsRectangle();
    private Group cardsStackGroup = new Group();
    private Group playerCardsGroup = new Group();
    private Group opponentCardsGroup = new Group();
    private Group flopCardsGroup = new Group();
    private Group turnCardGroup = new Group();
    private Group riverCardGroup = new Group();

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
        playerCardsGroup.getChildren().add(playerCardsRectangle.getPlayersCardsRectangle());
        opponentCardsGroup.getChildren().add(opponentCardsRectangle.getPlayersCardsRectangle());
        flopCardsGroup.getChildren().add(flopCardsRectangle.getThreeCardRectangle());
        turnCardGroup.getChildren().add(turnRectangle.getCardsStack());
        riverCardGroup.getChildren().add(riverRectangle.getCardsStack());

        GridPane.setHalignment(riverCardGroup, HPos.LEFT);
        GridPane.setHalignment(turnCardGroup, HPos.LEFT);
        GridPane.setHalignment(flopCardsGroup, HPos.RIGHT);
        GridPane.setHalignment(opponentCardsGroup, HPos.RIGHT);
        GridPane.setHalignment(playerCardsGroup, HPos.RIGHT);
        GridPane.setHalignment(cardsStackGroup, HPos.CENTER);

        //lewa kolumna
        newGameLayoutPane.add(leftMenuButtons.getMenuButtons(), 0, 0);
        newGameLayoutPane.add(cardsStackGroup, 0 ,1);
        newGameLayoutPane.add(gameConsole.getHistoryConsole(), 0, 2);
        newGameLayoutPane.setStyle("-fx-background-color: green;");
        //srodkowa kolumna
        newGameLayoutPane.add(flopCardsGroup, 1, 1);
        newGameLayoutPane.add(turnCardGroup, 2, 1);
        newGameLayoutPane.add(riverCardGroup, 3, 1);
        newGameLayoutPane.add(playerCardsGroup, 1, 2);
        newGameLayoutPane.add(opponentCardsGroup, 1, 0);



        newGameScene = new Scene(newGameLayoutPane, Main.sceneWidth, Main.sceneHeight);
        Stage newGameStage = new Stage();
        newGameStage.getIcons().add(new Image("http://www.iconninja.com/files/281/254/528/poker-icon.png"));
        newGameStage.setTitle("TexasHoldEm - New Game");
        newGameStage.setResizable(false);
        newGameStage.setScene(newGameScene);
        newGameStage.show();



    }

    public Group getFlopCardsGroup() {
        return flopCardsGroup;
    }

    public Game getGame() {
        return game;
    }

    public void putDeckCardsOnItsPlace() {
        this.getGame().setStateOfTheGame(GameState.FLOP);
        for(Card card : this.game.getPlayingDeck().getDeckStack()) {
            card.getCardImageView().setTranslateX(10);
            this.cardsStackGroup.getChildren().add(card.getCardImageView());
        }
    }

    public void putCardsToPlayersHands() {
        System.out.println("Player cards");
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

    public void putCardsToOpponentHands() {
        System.out.println("Opponent cards");
        double posX = 10;
        for(Card card : this.game.getPlayerList().getListOfPlayers().get(1).getPlayerCardsList()) {
            System.out.println(card.toString());
            card.getCardImageView().setTranslateX(posX);
            posX = posX + Main.cardWidth + 10;
            this.opponentCardsGroup.getChildren().add(card.getCardImageView());
        }
    }

    public void putCardsOnFlop() {
        this.getGame().setStateOfTheGame(GameState.TURN);
        System.out.println("Flop cards");
        double posX = 10;
        for(Card card : this.game.getFlopCards()){
            card.turnCard();
            System.out.println(card.toString());
            card.getCardImageView().setTranslateX(posX);
            posX = posX + Main.cardWidth + 10;
            this.flopCardsGroup.getChildren().add(card.getCardImageView());
        }
    }

    public void putCardOnTurn() {
        this.getGame().setStateOfTheGame(GameState.RIVER);
        System.out.println("Turn card");
        this.game.getTurnCards().get(0).turnCard();
        System.out.println(this.game.getTurnCards().get(0));
        this.game.getTurnCards().get(0).getCardImageView().setTranslateX(10);
        this.turnCardGroup.getChildren().add(this.game.getTurnCards().get(0).getCardImageView());
    }

    public void putCardOnRiver() {
        this.getGame().setStateOfTheGame(GameState.END);
        System.out.println("River card");
        this.game.getRiverCards().get(0).turnCard();
        System.out.println(this.game.getRiverCards().get(0));
        this.game.getRiverCards().get(0).getCardImageView().setTranslateX(10);
        this.riverCardGroup.getChildren().add(this.game.getRiverCards().get(0).getCardImageView());
    }




}
