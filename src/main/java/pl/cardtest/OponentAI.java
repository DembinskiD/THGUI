package pl.cardtest;

public class OponentAI extends Player {

    public OponentAI(String playerName, int initialPlayerCash, PlayerPosition playerPosition) {
        super(playerName, initialPlayerCash, playerPosition);
    }


    public void decide() {
        if(this.getPokerLayout().equals(PokerLayout.PAIR)) this.setPlayerStatus(PlayerStatus.BET);
        if(this.getPokerLayout().equals(PokerLayout.HIGH_CARD) && this.getHighestCardFromLayout().getRank().number >= 9) this.setPlayerStatus(PlayerStatus.CALL);
    }

}
