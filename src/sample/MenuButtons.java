package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MenuButtons {
    private Button startGameButton = new Button("Start Game");
    private Button decreaseRaiseButton = new Button("-");
    private Button increaseRaiseButton = new Button("+");
    private Label raiseAmountLabel = new Label();
    private Button allInButton = new Button("All in");
    private Button passButton = new Button("Pass");
    private Button callButton = new Button("Call");
    private Button raiseButton = new Button("Raise");
    private VBox menuButtons = new VBox();
    private HBox raiseButtons = new HBox();

    public MenuButtons(GameConsole gameConsole) {
        raiseButtons.setSpacing(3);
        raiseButtons.getChildren().addAll(decreaseRaiseButton, raiseAmountLabel, increaseRaiseButton, raiseButton);
        raiseButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(2);
        menuButtons.setLayoutX(20);
        menuButtons.setLayoutY(10);
        menuButtons.getChildren().addAll(startGameButton, callButton, raiseButtons, allInButton, passButton);
        menuButtons.setAlignment(Pos.CENTER);

        raiseAmountLabel.setText("10");
        onClickActions(gameConsole);
    }

    private void onClickActions(GameConsole gameConsole){

        //TODO starting new game should start tossing cards, putting them on proper fields and start game loop
        startGameButton.setOnAction(event -> {
            System.out.println("Starting new Game");
            gameConsole.appendHistoryConsoleText("Starting new Game");
        });

        decreaseRaiseButton.setOnAction(event -> {
            int oldVal = Integer.valueOf(raiseAmountLabel.getText());
            if(oldVal > 0) {
                oldVal -= 10;
                raiseAmountLabel.setText(String.valueOf(oldVal));
                System.out.println("New raise value equals " + oldVal);
                gameConsole.appendHistoryConsoleText("Decreased bet value to " + oldVal);
            }

        });

        increaseRaiseButton.setOnAction(event -> {
            int oldVal = Integer.valueOf(raiseAmountLabel.getText());
            if(oldVal < 100) {
                oldVal += 10;
                raiseAmountLabel.setText(String.valueOf(oldVal));
                System.out.println("New raise value equals " + oldVal);
                gameConsole.appendHistoryConsoleText("Increased bet value to " + oldVal);
            }

        });

        allInButton.setOnAction(event -> {
            raiseAmountLabel.setText(String.valueOf(200));
            System.out.println("Going all in with " + raiseAmountLabel.getText());
            gameConsole.appendHistoryConsoleText("Going all in with: " + raiseAmountLabel.getText());

        });

        passButton.setOnAction(event -> {
            System.out.println("Passing.");
            gameConsole.appendHistoryConsoleText("Passing.");
        });

        callButton.setOnAction(event -> {
            System.out.println("Calling in same amount.");
            gameConsole.appendHistoryConsoleText("Calling in same amount.");
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
