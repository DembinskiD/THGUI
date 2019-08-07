package Engine;

public enum PlayerPosition {
    SMALL_BLIND, BIG_BLIND, UTG, MIDDLE_POSITION, CUT_OFF, BUTTON;

    private static PlayerPosition[] vals = values();

    public PlayerPosition next() {
        if(this.equals(BUTTON)) return SMALL_BLIND;
        else return vals[(this.ordinal()+1) % vals.length];
    }
}
