package pl.cardtest;

public class MoneyManager {
    public int getOnTableCash() {
        return onTableCash;
    }

    private int onTableCash;
    private int betCash;


    public MoneyManager(int initialSmallBlindCash) {
        this.onTableCash = 0;
        this.betCash = initialSmallBlindCash;
    }


    public void addCashToTable(int cash) {
        this.onTableCash += cash;
    }


    public int getBetCash() {
        return betCash;
    }

    public void setBetCash(int betCash) {
        this.betCash = betCash;
    }
}
