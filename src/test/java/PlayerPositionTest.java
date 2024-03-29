import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.cardtest.PlayerPosition;

class PlayerPositionTest {

    @Test
    void next() {
        PlayerPosition playerPosition = PlayerPosition.CUT_OFF;
        playerPosition = playerPosition.next();
        Assertions.assertEquals(PlayerPosition.BUTTON, playerPosition);
    }
}