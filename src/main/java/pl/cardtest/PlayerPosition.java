package pl.cardtest;

public enum PlayerPosition {
    BUTTON, SMALL_BLIND, BIG_BLIND, UTG, MIDDLE_POSITION, CUT_OFF;

    private static final PlayerPosition[] vals = values();

    public PlayerPosition next() {
        if(this.equals(CUT_OFF)) return BUTTON;
        else return vals[(this.ordinal()+1) % vals.length];
    }
}
