package Engine;

public enum CardColor {
    Spade(1, "S"),
    Club(2, "C"),
    Diamond(3, "D"),
    Heart(4, "H");

    int color;
    String link;

    private CardColor(int color) { this.color = color; }

    private CardColor(int color, String link){
        this.color = color;
        this.link = link;
    }

    public int getVal() {
        return color;
    }

    public String getLink() {
        return link;
    }

    public boolean compareCardColors(CardColor test) {
        return this.color == test.color;
    }
}
