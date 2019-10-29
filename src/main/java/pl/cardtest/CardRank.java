package pl.cardtest;

public enum CardRank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    J(11, "J"),
    Q(12, "Q"),
    K(13, "K"),
    A(14, "A");

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