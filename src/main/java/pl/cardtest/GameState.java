package pl.cardtest;

public enum GameState {
    INITIAL, FLOP, TURN, RIVER, END;

    private static final GameState[] vals = values() ;

    public GameState next() {
        if(this.equals(END)) return INITIAL;
        else return vals[(this.ordinal()+1) % vals.length];
    }
}
