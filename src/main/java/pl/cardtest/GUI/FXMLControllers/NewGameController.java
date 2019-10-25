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
import org.jetbrains.annotations.NotNull;
import pl.cardtest.*;
import pl.cardtest.GUI.GameConsole;


public class NewGameController{
    public HBox playerCardsHBOX = new HBox();
    public HBox opponentCardsHBOX = new HBox();
    public StackPane cardsStackPane = new StackPane();
    public HBox flopCardsHBOX = new HBox();
    public HBox turnCardsHBOX = new HBox();
    public HBox riverCardsHBOX = new HBox();

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
    public HandAndTableCards playerCheck;
    public HandAndTableCards AICheck;
    int enemies;
    String playerName;
    int startingCash;
    int smallBlind;







    public NewGameController(int enemies, String playerName, int startingCash, int smallBlind) throws Exception {
        this.enemies = enemies;
        this.playerName = playerName;
        this.startingCash = startingCash;
        this.smallBlind = smallBlind;
        this.game = new Game(enemies, playerName, startingCash, smallBlind);
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

    private void setButtons(boolean var, boolean endOfTurn){
        this.decreaseButton.setDisable(var);
        this.increaseButton.setDisable(var);
        this.callButton.setDisable(var);
        this.raiseButton.setDisable(var);
        this.allInButton.setDisable(var);
        this.passButton.setDisable(var);
        if (endOfTurn) this.startGameButton.setDisable(!var);
    }

    @FXML
    public void initialize() {
        setButtons(true, false);


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

        //add all items to root pane
        this.root.add(playerCardsHBOX, 2, 2);
        this.root.add(opponentCardsHBOX, 2, 0);
        this.root.add(cardsStackPane, 1, 1);
        this.root.add(flopCardsHBOX, 2, 1);
        this.root.add(turnCardsHBOX, 3, 1);
        this.root.add(riverCardsHBOX, 4, 1);

    }

    private void updateCashLabels() {
        this.playerCash.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerCash() + " $");
        this.opponentCash.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerCash() + " $");
        this.moneyOnStack.setText("Money in game: " + this.game.getMoneyManager().getOnTableCash());
        this.betCash.setText("Bet cash: " + this.game.getMoneyManager().getBetCash());
        this.playerPosition.setText(this.game.getPlayerList().getListOfRealPlayers().get(0).getPlayerPosition().name());
        this.opponentPosition.setText(this.game.getPlayerList().getListOfNPC().get(0).getPlayerPosition().name());
    }



    public void rectSettings(@org.jetbrains.annotations.NotNull Rectangle temp, int cardAmount) {
        int spaces = (cardAmount-1) * 10;
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
            c.turnCard(); //todo temporary for checking purpose, got to remove it later
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


        updateCashLabels();


    }

    public void startTurns() {
        //roundCount++;
        //Changing name colors for current player
        System.out.println("current player: " + this.game.getPlayerList().getCurrentPlayer());
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

    //end of game method
    private void endOfGame(@NotNull Player winner) throws Exception {
        for(Player player : this.game.getPlayerList().getListOfPlayers()) {
            System.out.println(player.toString());
        }
        console.appendHistoryConsoleText(winner.getPlayerName() + " has won with " + winner.getPokerLayout());
        setButtons(true, true);
        playerCardsHBOX.getChildren().clear();
        opponentCardsHBOX.getChildren().clear();
        riverCardsHBOX.getChildren().clear();
        turnCardsHBOX.getChildren().clear();
        flopCardsHBOX.getChildren().clear();
        cardsStackPane.getChildren().clear();
        winner.setPlayerCash(winner.getPlayerCash() + this.game.getMoneyManager().getOnTableCash());
        this.game.getPlayerList().getListOfPlayers().forEach(player -> { //todo ta funkcja dziala tylko dla dwóch graczy, trzeba ja zmienic przy wprowadzeniu wiekszej ilosci playerów
            player.setPlayerPosition(player.getPlayerPosition().equals(PlayerPosition.BUTTON) ? PlayerPosition.SMALL_BLIND : PlayerPosition.BUTTON);
        });

        roundCount = 0;
        //this.game = new Game(this.enemies, this.playerName, this.startingCash, this.smallBlind); //todo game nie może być update 'owane bo zeruje 'startingCash'
        this.game.newRound(this.smallBlind);
        updateCashLabels();
    }
//todo nie updateuje pieniedzy po skonczeniu tury, do zrobienia

    public void nextTurn() throws Exception {
        System.out.println(this.game.getFlopCards() + "\n" + this.game.getTurnCards() + "\n" + this.game.getRiverCards() + "\n" + "===="); //test purposes
        roundCount++;

            //wystawienie kart po danej turze
            if(roundCount % this.game.getPlayerList().getListOfPlayers().size() == 0) {
                if(roundCount / this.game.getPlayerList().getListOfPlayers().size() == 1) {
                    for(Card c : this.game.getFlopCards()) {
                        c.turnCard();
                        flopCardsHBOX.getChildren().add(c.getCardImageView());
                    }
                } if(roundCount / this.game.getPlayerList().getListOfPlayers().size() == 2) {
                    for(Card c: this.game.getTurnCards()) {
                        c.turnCard();
                        turnCardsHBOX.getChildren().add(c.getCardImageView());
                    }
                } if(roundCount / this.game.getPlayerList().getListOfPlayers().size() == 3) {
                    for(Card c : this.game.getRiverCards()) {
                        c.turnCard();
                        riverCardsHBOX.getChildren().add(c.getCardImageView());
                    }
                } if(roundCount / this.game.getPlayerList().getListOfPlayers().size() == 4) {
                    //todo compare layouts here

                    playerCheck = new HandAndTableCards(this.game.getPlayerList().getListOfPlayers().get(0), this.game.getFlopCards(),
                            this.game.getTurnCards().get(0), this.game.getRiverCards().get(0));
                    System.out.println(playerCheck.getLayout());
                    AICheck = new HandAndTableCards(this.game.getPlayerList().getListOfPlayers().get(1), this.game.getFlopCards(),
                            this.game.getTurnCards().get(0), this.game.getRiverCards().get(0));
                    System.out.println(AICheck.getLayout());
                    LayoutComparing cmp = new LayoutComparing();
                    for(Player pl : this.game.getPlayerList().getListOfPlayers()) {
                        cmp.addPlayer(pl);
                    }

                    endOfGame(cmp.getWinner());
                }
            }
            //changing current player
            if(this.game.getPlayerList().getListOfRealPlayers().contains(this.game.getPlayerList().getCurrentPlayer())) {
                this.game.getPlayerList().setCurrentPlayer(this.game.getPlayerList().getListOfNPC().get(0));
            } else this.game.getPlayerList().setCurrentPlayer(this.game.getPlayerList().getListOfRealPlayers().get(0));
            //todo if sprawdzanie hajsu i wrzucenie wielu moetod w srodek
            //setting buttons disable if player has less money than 'betCash'
            //todo wyciagnac tego ifa do osobnej moetody
            if(this.game.getPlayerList().getCurrentPlayer().getPlayerCash() < this.game.getMoneyManager().getBetCash()) {
                this.callButton.setDisable(true);
                this.raiseButton.setDisable(true);
                this.increaseButton.setDisable(true);
                this.decreaseButton.setDisable(true);
            }
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
        setButtons(false, false);
        startTurns();
    }

    public void callButtonAction(ActionEvent actionEvent) throws Exception {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() +
                ": Calling in " + this.game.getMoneyManager().getBetCash() + "$");
        this.game.getMoneyManager().addCashToTable(this.game.getPlayerList().getCurrentPlayer().chipMoneyIn(this.game.getMoneyManager().getBetCash()));
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.CALL);
        nextTurn();
    }

    public void raiseButtonAction(ActionEvent actionEvent) throws Exception {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() + ": raising by "
                + Integer.valueOf(this.raiseLabel.getText()) + "$");
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.RAISE);
        this.game.getMoneyManager().setBetCash(this.game.getMoneyManager().getBetCash() + Integer.parseInt(this.raiseLabel.getText()));
        this.game.getMoneyManager().addCashToTable(this.game.getPlayerList().getCurrentPlayer().chipMoneyIn(Integer.parseInt(this.raiseLabel.getText())));
        nextTurn();
    }

    public void allInButtonAction(ActionEvent actionEvent) throws Exception {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() +
                ": all in with " + this.game.getPlayerList().getCurrentPlayer().getPlayerCash() + "$");
        this.game.getMoneyManager().setBetCash(this.game.getPlayerList().getCurrentPlayer().getPlayerCash());
        this.game.getMoneyManager().addCashToTable(this.game.getPlayerList().getCurrentPlayer().chipMoneyIn(this.game.getMoneyManager().getBetCash()));
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.ALLIN);
        nextTurn();
    }

    public void passButtonAction(ActionEvent actionEvent) throws Exception {
        this.console.appendHistoryConsoleText(this.game.getPlayerList().getCurrentPlayer().getPlayerName() + ": passed.");
        this.game.getPlayerList().getCurrentPlayer().setPlayerStatus(PlayerStatus.PASS);
        //todo poniższa metoda działa wyłącznie dla dwóch graczy! to be changed in later release
        endOfGame(this.game.getPlayerList().getListOfRealPlayers().contains(this.game.getPlayerList().getCurrentPlayer())
                ? this.game.getPlayerList().getListOfNPC().get(0) : this.game.getPlayerList().getListOfRealPlayers().get(0));
    }

    public void increaseButtonAction(ActionEvent actionEvent) {
        if(Integer.parseInt(this.raiseLabel.getText()) < this.game.getPlayerList().getCurrentPlayer().getPlayerCash()) {
            this.raiseLabel.setText(String.valueOf(Integer.parseInt(this.raiseLabel.getText()) + 10));
        }
    }

    public void decreaseButtonAction(ActionEvent actionEvent) {
        if(Integer.parseInt(this.raiseLabel.getText()) > 10) {
            this.raiseLabel.setText(String.valueOf(Integer.parseInt(this.raiseLabel.getText()) - 10));
        }
    }



}
