package pl.cardtest;

public enum CardRank {
    TWO(1, "2"),
    THREE(2, "3"),
    FOUR(3, "4"),
    FIVE(4, "5"),
    SIX(5, "6"),
    SEVEN(6, "7"),
    EIGHT(7, "8"),
    NINE(8, "9"),
    TEN(9, "10"),
    J(10, "J"),
    Q(11, "Q"),
    K(12, "K"),
    A(13, "A");

    final int number;
    String link;

    CardRank(int number, String link) {
        this.number = number;
        this.link = link;
    }

    public boolean isBiggerThan(CardRank test) {
        return this.number > test.number;
    }

    public boolean areTheSame(CardRank test) {
        return this.number == test.number;
    }

    public String getLink() {
        return link;
    }
}