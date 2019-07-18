package sample;

import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class GameConsole {
    private ScrollPane historyConsole =  new ScrollPane();
    private Text historyConsoleText = new Text();
    private int sceneHeight = Main.sceneHeight;
    private int cardHeight = Main.cardHeight;

    public GameConsole() {
        historyConsole.setContent(historyConsoleText);
        historyConsole.setLayoutX(10);
        historyConsole.setLayoutY(sceneHeight/2 + cardHeight/2 + 20);
        historyConsole.setMinWidth(180);
        historyConsole.setMaxWidth(180);
        historyConsole.setMinHeight(200);
        historyConsole.setMaxHeight(200);
        historyConsoleText.setText("Start new game.");
    }

    public ScrollPane getHistoryConsole() {
        return historyConsole;
    }

    public Text getHistoryConsoleText() {
        return historyConsoleText;
    }

    public void appendHistoryConsoleText(String appendedText) {
        this.historyConsoleText.setText(this.historyConsoleText.getText() + "\n" + appendedText);
        this.historyConsole.setVvalue(1.0);
    }
}
