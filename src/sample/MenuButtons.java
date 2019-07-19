package sample;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class MenuButtons {
    private Button startGameButton = new Button("Start Game");
    private Text startGameButtonText = new Text("Starting new game.");
    private Button decreaseRaiseButton = new Button("-");
    private Text decreaseButtonText = new Text("Decreased value to ");
    private Button increaseRaiseButton = new Button("+");
    private Text increaseButtonText = new Text("Increased value to ");
    private Label raiseAmountLabel = new Label();
    private Button allInButton = new Button("All in");
    private Text allInButtonText = new Text("Going all in with ");
    private Button passButton = new Button("Pass");
    private Text passButtonText = new Text("Passing the call.");
    private Button callButton = new Button("Call.");
    private Text callButtonText = new Text("Calling in.");
    private Button raiseButton = new Button("Raise");
    private Text raiseButtonText = new Text("Raised by ");
    private VBox menuButtons = new VBox();
    private HBox raiseButtons = new HBox();

    public MenuButtons(GameConsole gameConsole) {
        raiseButtons.setSpacing(3);
        raiseButtons.getChildren().addAll(decreaseRaiseButton, raiseAmountLabel, increaseRaiseButton, raiseButton);
        raiseButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(2);
        menuButtons.getChildren().addAll(startGameButton, callButton, raiseButtons, allInButton, passButton);
        menuButtons.setAlignment(Pos.CENTER);
        GridPane.setHalignment(this.menuButtons, HPos.CENTER);

        raiseAmountLabel.setText("10");
        onClickActions(gameConsole);
    }

    private void onClickActions(GameConsole gameConsole){

        //TODO starting new game should start tossing cards, putting them on proper fields and start game loop
        startGameButton.setOnAction(event -> {
            System.out.println(startGameButtonText.getText());
            gameConsole.appendHistoryConsoleText(startGameButtonText.getText());
        });

        decreaseRaiseButton.setOnAction(event -> {
            int oldVal = Integer.valueOf(raiseAmountLabel.getText());
            if(oldVal > 0) {
                oldVal -= 10;
                raiseAmountLabel.setText(String.valueOf(oldVal));
                System.out.println(decreaseButtonText.getText() + oldVal);
                gameConsole.appendHistoryConsoleText(decreaseButtonText.getText() + oldVal);
            }

        });

        increaseRaiseButton.setOnAction(event -> {
            int oldVal = Integer.valueOf(raiseAmountLabel.getText());
            if(oldVal < 100) {
                oldVal += 10;
                raiseAmountLabel.setText(String.valueOf(oldVal));
                System.out.println(increaseButtonText.getText() + oldVal);
                gameConsole.appendHistoryConsoleText(increaseButtonText.getText() + oldVal);
            }

        });

        allInButton.setOnAction(event -> {
            raiseAmountLabel.setText(String.valueOf(100));
            System.out.println(allInButtonText.getText() + raiseAmountLabel.getText());
            gameConsole.appendHistoryConsoleText(allInButtonText.getText() + raiseAmountLabel.getText());

        });

        passButton.setOnAction(event -> {
            System.out.println(passButtonText.getText());
            gameConsole.appendHistoryConsoleText(passButtonText.getText());
        });

        callButton.setOnAction(event -> {
            System.out.println(callButtonText.getText());
            gameConsole.appendHistoryConsoleText(callButtonText.getText());
        });

        raiseButton.setOnAction(event -> {
            System.out.println(raiseButtonText.getText() + raiseAmountLabel.getText());
            gameConsole.appendHistoryConsoleText(raiseButtonText.getText() + raiseAmountLabel.getText());
        });





    }


























    public VBox getMenuButtons() {
        return menuButtons;
    }

    public Button getStartGameButton() {
        return startGameButton;
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
}
