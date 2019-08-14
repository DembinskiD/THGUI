package pl.cardtest.GUI;

import javafx.geometry.HPos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import pl.cardtest.Main;

class GameConsole {
    private final ScrollPane historyConsole =  new ScrollPane();
    private final Text historyConsoleText = new Text();

    public GameConsole() {
        historyConsole.setContent(historyConsoleText);
        int sceneHeight = Main.sceneHeight;
        int cardHeight = Main.cardHeight;
        historyConsole.setLayoutY(sceneHeight /2 + cardHeight /2 + 20);
        historyConsole.setMinWidth(180);
        historyConsole.setMaxWidth(180);
        historyConsole.setMinHeight(200);
        historyConsole.setMaxHeight(200);
        GridPane.setHalignment(this.historyConsole, HPos.CENTER);
        historyConsoleText.setText("Start new game.");
    }

    public ScrollPane getHistoryConsole() {
        return historyConsole;
    }

    public void appendHistoryConsoleText(String appendedText) {
        this.historyConsoleText.setText(this.historyConsoleText.getText() + "\n" + appendedText);
        this.historyConsole.setVvalue(1.0);
    }
}
