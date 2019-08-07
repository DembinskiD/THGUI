package pl.cardtest;

public enum CardColor {
    Spade(1, "S"),
    Club(2, "C"),
    Diamond(3, "D"),
    Heart(4, "H");

    final int color;
    String link;

    CardColor(int color, String link){
        this.color = color;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public boolean compareCardColors(CardColor test) {
        return this.color == test.color;
    }
}
