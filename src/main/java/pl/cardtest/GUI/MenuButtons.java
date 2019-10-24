package pl.cardtest.GUI;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


class MenuButtons {
    protected final Button startGameButton = new Button("Start Game");
    private final Text startGameButtonText = new Text("Starting new game.");
    protected final Button decreaseRaiseButton = new Button("-");
    private final Text decreaseButtonText = new Text("Decreased value to ");
    protected final Button increaseRaiseButton = new Button("+");
    private final Text increaseButtonText = new Text("Increased value to ");
    protected final Label raiseAmountLabel = new Label();
    protected final Button allInButton = new Button("All in");
    private final Text allInButtonText = new Text("Going all in with ");
    protected final Button passButton = new Button("Pass");
    private final Text passButtonText = new Text("Passing the call.");
    protected final Button callButton = new Button("Call");
    private final Text callButtonText = new Text("Calling in.");
    protected final Button raiseButton = new Button("Raise");
    private final Text raiseButtonText = new Text("Raised by ");
    private final VBox menuButtons = new VBox();
    private final NewGameGridPane newGameGridPane;




    public MenuButtons(NewGameGridPane newGameGridPane, GameConsole gameConsole) {
        this.startGameButton.setDisable(false);
        this.callButton.setDisable(false);
        this.newGameGridPane = newGameGridPane;
        HBox raiseButtons = new HBox();
        raiseButtons.setSpacing(3);
        raiseButtons.getChildren().addAll(decreaseRaiseButton, raiseAmountLabel, increaseRaiseButton);
        raiseButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(2);
        menuButtons.getChildren().addAll(startGameButton, callButton, raiseButtons, raiseButton, allInButton, passButton);
        menuButtons.setAlignment(Pos.CENTER);
        GridPane.setHalignment(this.menuButtons, HPos.CENTER);

        raiseAmountLabel.setText("10");

        startGameButton.setMinWidth(100);
        callButton.setMinWidth(100);
        allInButton.setMinWidth(100);
        passButton.setMinWidth(100);
        raiseButtons.setMaxWidth(100);
        raiseButtons.setMinWidth(100);

        decreaseRaiseButton.setMinWidth(30);
        increaseRaiseButton.setMinWidth(30);
        raiseAmountLabel.setMinWidth(34);
        raiseAmountLabel.setAlignment(Pos.CENTER);
        raiseButton.setMinWidth(100);
    }


    public Label getRaiseAmountLabel() {
        return raiseAmountLabel;
    }


    public Button getDecreaseRaiseButton() {
        return decreaseRaiseButton;
    }

    public Button getIncreaseRaiseButton() {
        return increaseRaiseButton;
    }

    public Button getAllInButton() {
        return allInButton;
    }

    public Button getPassButton() {
        return passButton;
    }

    public Button getCallButton() {
        return callButton;
    }

    public Button getRaiseButton() {
        return raiseButton;
    }




























    public VBox getMenuButtons() {
        return menuButtons;
    }

}
