package Engine;

public class OponentAI extends Player {

    public OponentAI(String playerName, int initialPlayerCash, PlayerPosition playerPosition) {
        super(playerName, initialPlayerCash, playerPosition);
        super.isComputer = true;
    }


    public void decide() {
        if(this.getPokerLayout().equals(PokerLayout.PAIR)) this.setPlayerStatus(PlayerStatus.BET);
        if(this.getPokerLayout().equals(PokerLayout.HIGH_CARD) && this.getHighestCardFromLayout().getRank().number >= 9) this.setPlayerStatus(PlayerStatus.CALL);
    }

}
