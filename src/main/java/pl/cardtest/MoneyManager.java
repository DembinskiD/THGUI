package pl.cardtest;

public class MoneyManager {
    private int onTableCash;
    private int betCash;

    public MoneyManager(int startingBetCash) {
        this.onTableCash = 0;
        this.betCash = startingBetCash;
    }


    public int getBetCash() {
        return betCash;
    }

    public void setBetCash(int betCash) {
        this.betCash = betCash;
    }
}
