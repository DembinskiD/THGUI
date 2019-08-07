import Engine.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OponentAITest {
    static Player player = new Player("Dawid", 100, PlayerPosition.SMALL_BLIND);

    @BeforeAll
    public static void primarySetup() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)

        Card handCardOne = new Card(CardRank.TWO, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.A, CardColor.Club);
        player.addCardToPlayersHand(handCardOne);
        player.addCardToPlayersHand(handCardTwo);
        player.updateHandsLayout();
    }

    @Test
    void makeDecisions() {
        System.out.println(player);
        Assertions.assertEquals(PokerLayout.HIGH_CARD, player.getPokerLayout());
    }
}