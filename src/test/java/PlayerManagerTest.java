import Engine.OponentAI;
import Engine.PlayerManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerManagerTest {

    @Test
    void getListOfPlayers() {
        PlayerManager pm = new PlayerManager(3,3);
        pm.getListOfPlayers().forEach(System.out::println);
        Assertions.assertEquals(3, pm.getListOfPlayers().stream().filter(a -> a.getClass().equals(OponentAI.class)).count());
    }
}