package pl.cardtest.GUI.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.cardtest.*;
import pl.cardtest.GUI.GameConsole;


public class NewGameController{
    HBox playerCardsHBOX = new HBox();
    HBox opponentCardsHBOX = new HBox();
    StackPane cardsStackPane = new StackPane();
    HBox flopCardsHBOX = new HBox();
    HBox turnCardsHBOX = new HBox();
    HBox riverCardsHBOX = new HBox();

    public ScrollPane historyConsole = new ScrollPane();
    public GameConsole console;
    public Label raiseLabel;
    public GridPane raiseButtonControls;
    public Rectangle OpponentCardStack = new Rectangle();
    public Rectangle PlayerCardStack = new Rectangle();
    public Rectangle cardStackRect;
    public Rectangle FlopCardStack;
    public Rectangle RiverCardStack;
    public Rectangle TurnCardStack;
    public Game game;
    @FXML public VBox gameStats = new VBox();
    @FXML public Label moneyOnStack = new Label();
    @FXML public Label betCash = new Label();
    @FXML public GridPane root;
    @FXML public Label playerLabel = new Label();
    @FXML public Label opponentLabel = new Label();
    @FXML public Label opponentPosition = new Label();
    @FXML public Label playerPosition = new Label();
    @FXML public Label playerCash = new Label();
    @FXML public Label opponentCash = new Label();
    @FXML public Button startGameButton = new Button();
    @FXML public Button decreaseButton = new Button();
    @FXML public Button increaseButton = new Button();
    @FXML public Button callButton = new Button();
    @FXML public Button raiseButton = new Button();
    @FXML public Button allInButton = new Button();
    @FXML public Button passButton = new Button();
    private int roundCount = 0;
    private boolean containsFlop = false;
    private boolean containsTurn = false;
    private boolean containsRiver = false;






    public NewGameController(int enemies, String playerName, int startingCash) throws Exception {
        this.game = new Game(enemies, playerName, startingCash);
        cardsStackPane.setAlignment(Pos.CENTER);
        playerCardsHBOX.setSpacing(10);
        playerCardsHBOX.setAlignment(Pos.CENTER);
        opponentCardsHBOX.setSpacing(10);
        opponentCardsHBOX.setAlignment(Pos.CENTER);
        flopCardsHBOX.setSpacing(10);
        flopCardsHBOX.setAlignment(Pos.CENTER);
        turnCardsHBOX.setAlignment(Pos.CENTER);
        riverCardsHBOX.setAlignment(Pos.CENTER);
    }

    public NewGameController() {
    }

    private void setButtons(boolean var){
        this.decreaseButton.setDisable(var);
        this.increaseButton.setDisable(var);
        this.callButton.setDisable(var);
        this.raiseButton.setDisable(var);
        this.allInButton.setDisable(var);
        this.passButton.setDisable(var);
    }

    @FXML
    public void initialize() {
        setButtons(true);


        this.playerPosition.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerPosition().name());
        this.opponentPosition.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerPosition().name());
        this.playerCash.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerCash() + " $");
        this.opponentCash.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerCash() + " $");
        playerLabel.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerName());
        opponentLabel.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerName());
        gameStats.setAlignment(Pos.CENTER);


        this.console = new GameConsole(historyConsole);
        raiseButtonControls.setAlignment(Pos.CENTER);
        GridPane.setHalignment(raiseLabel, HPos.CENTER);
        GridPane.setHalignment(gameStats, HPos.CENTER);
        rectSettings(cardStackRect, 1);
        rectSettings(OpponentCardStack, 2);
        rectSettings(PlayerCardStack, 2);
        rectSettings(FlopCardStack, 3);
        rectSettings(TurnCardStack, 1);
        rectSettings(RiverCardStack, 1);

    }

    private void updateCashLabels() {
        this.playerCash.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerCash() + " $");
        this.opponentCash.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerCash() + " $");
        this.moneyOnStack.setText("Money in game: " + this.game.getMoneyManager().getOnTableCash());
        this.betCash.setText("Bet cash: " + this.game.getMoneyManager().getBetCash());
    }



    public void rectSettings(@org.jetbrains.annotations.NotNull Rectangle temp, int cardAmount) {
        int spaces = (cardAmount+1) * 10;
        temp.setWidth(cardAmount * Main.cardWidth + spaces);
        temp.setHeight(Main.cardHeight);
        temp.setArcWidth(20);
        temp.setArcHeight(20);
        temp.setFill(Color.rgb(0, 100, 0));
        temp.setStroke(Color.BLACK);
    }

    private void initialCardDistribution() {
        //put deck of cards to card stack
        for (int i = 0; i < this.game.getPlayingDeck().getDeckStack().size(); i++) {
            this.cardsStackPane.getChildren().add(this.game.getPlayingDeck().getDeckStack().get(i).getCardImageView());
        }
        //put cards to players hand
        for (Card c : this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerCardsList()) {
            c.turnCard();
            playerCardsHBOX.getChildren().add(c.getCardImageView());
        }
        //put cards to opponents hand
        for( Card c: this.game.getPlayerList().getListOfNPC().get(0).getPlayerCardsList()) {
            opponentCardsHBOX.getChildren().add(c.getCardImageView());
        }

        //get money from small and big blinds to ingame cash before updating and posting amount of cash visible
        for(Player pl : this.game.getPlayerList().getListOfPlayers()){
            if(pl.getPlayerPosition().equals(PlayerPosition.SMALL_BLIND)) {
                this.game.getMoneyManager().addCashToTable(pl.chipMoneyIn(this.game.getMoneyManager().getBetCash()));
                this.console.appendHistoryConsoleText(pl.getPlayerName() + ": chipped in small blind of " +
                        this.game.getMoneyManager().getBetCash() + "$");
            } else if(pl.getPlayerPosition().equals(PlayerPosition.BIG_BLIND)) {
                this.game.getMoneyManager().addCashToTable(pl.chipMoneyIn(2*this.game.getMoneyManager().getBetCash()));
                this.console.appendHistoryConsoleText(pl.getPlayerName() + ": chipped in big blind of " + 2*this.game.getMoneyManager().getBetCash() + "$");
            }
        }

        this.moneyOnStack.setText("Money in game: " + this.game.getMoneyManager().getOnTableCash());
        this.betCash.setText("Bet cash: " + this.game.getMoneyManager().getBetCash());
        for( Player pl : this.game.getPlayerList().getListOfPlayers()) {
            System.out.println(pl.getPlayerName() + " " + pl.getPlayerCash());
        }

        updateCashLabels();

        //add all items to root pane
        this.root.add(playerCardsHBOX, 2, 2);
        this.root.add(opponentCardsHBOX, 2, 0);
        this.root.add(cardsStackPane, 1, 1);
        this.root.add(flopCardsHBOX, 2, 1);
        this.root.add(turnCardsHBOX, 3, 1);
        this.root.add(riverCardsHBOX, 4, 1);

    }

    public void startTurns() {
        //roundCount++;
        //Changing name colors for current player
        if(this.game.getPlayerList().getListOfRealPlayers().contains(this.game.getPlayerList().getCurrentPlayer())) {
            playerLabel.setTextFill(Color.RED);
            opponentLabel.setTextFill(Color.BLACK);
        } else {
            opponentLabel.setTextFill(Color.RED);
            playerLabel.setTextFill(Color.BLACK);
        }

        //updating cash labels
        updateCashLabels();

    }


    public void nextTurn() {
        roundCount++;
        if(roundCount % this.game.getPlayerList().getListOfPlayers().size() == 0) {
            for (Card c: this.game.getFlopCards()) {
                if(!this.root.getChildren().contains(c)){
                c.turnCard();
                flopCardsHBOX.getChildren().add(c.getCardImageView());
                containsFlop = true;
                }
            }
        }//od razu wyrzuca wszystkie 5 kart //todo do zrobienia zeby bylo po kolei wyrzucane
        if(roundCount % this.game.getPlayerList().getListOfPlayers().size() == 0 && containsFlop) {
            for(Card c : this.game.getTurnCards()) {
                if(!this.root.getChildren().contains(c)) {
                    c.turnCard();
                    turnCardsHBOX.getChildren().add(c.getCardImageView());
                    containsTurn = true;
                }
            }
        }
        if(roundCount % this.game.getPlayerList().getListOfPlayers().size() == 0 && containsTurn && !containsRiver) {
            for(Card c : this.game.getRiverCards()) {
                if(!this.root.getChildren().contains(c)) {
                    c.turnCard();
                    riverCardsHBOX.getChildren().add(c.getCardImageView());
                    containsRiver = true;
                }
            }
        }

            //flopCardsHBOX
        //changing current player
        if(this.game.getPlayerList().getListOfRealPlayers().contains(this.game.getPlayerList().getCurrentPlayer())) {
            this.game.getPlayerList().setCurrentPlayer(this.game.getPlayerList().getListOfNPC().get(0));
        } else this.game.getPlayerList().setCurrentPlayer(this.game.getPlayerList().getListOfRealPlayers().get(0));

        //Changing name colors for current player
        if(this.game.getPlayerList().getListOfRealPlayers().contains(this.game.getPlayerList().getCurrentPlayer())) {
            playerLabel.setTextFill(Color.RED);
            opponentLabel.setTextFill(Color.BLACK);
        } else {
            opponentLabel.setTextFill(Color.RED);
            playerLabel.setTextFill(Color.BLACK);
        }

            //updating cash labels
        updateCashLabels();

        //setting status for current player
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.INGAME);

    }



    public void startGameButtonAction(ActionEvent actionEvent) throws Exception {
        startGameButton.setDisable(true);
        this.console.appendHistoryConsoleText("Clicked start game button.");
        initialCardDistribution();
        setButtons(false);
        startTurns();
    }

    public void callButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() +
                ": Calling in " + this.game.getMoneyManager().getBetCash() + "$");
        this.game.getMoneyManager().addCashToTable(this.game.getPlayerList().getCurrentPlayer().chipMoneyIn(this.game.getMoneyManager().getBetCash()));
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.CALL);
        nextTurn();
    }

    public void raiseButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() + ": raising by "
                + Integer.valueOf(this.raiseLabel.getText()) + "$");
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.RAISE);
        this.game.getMoneyManager().setBetCash(this.game.getMoneyManager().getBetCash() + Integer.parseInt(this.raiseLabel.getText()));
        this.game.getMoneyManager().addCashToTable(this.game.getPlayerList().getCurrentPlayer().chipMoneyIn(Integer.parseInt(this.raiseLabel.getText())));
        nextTurn();
    }

    public void allInButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() +
                ": all in with " + this.game.getPlayerList().getCurrentPlayer().getPlayerCash() + "$");
        this.game.getMoneyManager().setBetCash(this.game.getPlayerList().getCurrentPlayer().getPlayerCash());
        this.game.getMoneyManager().addCashToTable(this.game.getPlayerList().getCurrentPlayer().chipMoneyIn(this.game.getMoneyManager().getBetCash()));
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.ALLIN);
        nextTurn();
    }

    public void passButtonAction(ActionEvent actionEvent) {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() + ": passed.");
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.PASS);
        nextTurn();
    }

    public void increaseButtonAction(ActionEvent actionEvent) {
        if(Integer.parseInt(this.raiseLabel.getText()) < this.game.getPlayerList().getCurrentPlayer().getPlayerCash()) {
            this.raiseLabel.setText(String.valueOf(Integer.parseInt(this.raiseLabel.getText()) + 10));
        }
    }

    public void decreaseButtonAction(ActionEvent actionEvent) {
        if(Integer.parseInt(this.raiseLabel.getText()) > 0) {
            this.raiseLabel.setText(String.valueOf(Integer.parseInt(this.raiseLabel.getText()) - 10));
        }
    }



}
