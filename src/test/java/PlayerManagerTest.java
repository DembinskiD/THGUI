import pl.cardtest.OponentAI;
import pl.cardtest.PlayerManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerManagerTest {

    @Test
    void getListOfPlayers() {
        PlayerManager pm = new PlayerManager(3,3);
        Assertions.assertEquals(3, pm.getListOfPlayers().stream().filter(a -> a.getClass().equals(OponentAI.class)).count());
    }
}