import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.cardtest.*;

class OponentAITest {
    private static final Player player = new Player("Dawid", 100, PlayerPosition.SMALL_BLIND);

    @BeforeAll
    static void primarySetup() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)

        Card handCardOne = new Card(CardRank.TWO, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.A, CardColor.Club);
        player.addCardToPlayersHand(handCardOne);
        player.addCardToPlayersHand(handCardTwo);
        player.updateHandsLayout();
    }

    @Test
    void makeDecisions() {
        Assertions.assertEquals(PokerLayout.HIGH_CARD, player.getPokerLayout());
    }
}