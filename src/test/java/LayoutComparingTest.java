import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.cardtest.*;

import java.util.ArrayList;

class LayoutComparingTest {

    @Test
    void getWinner() {
        Player player1 = new Player("Dawid",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.K, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.Q, CardColor.Diamond);
        Card flopCardTwo = new Card(CardRank.TEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Diamond);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player1, flopCards, turnCard, riverCard);
        LayoutManager layoutManager1 = new LayoutManager(handAndTableCards);


        Player player2 = new Player("Adam",100);

        Card handCardOne2 = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo2 = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne2 = new Card(CardRank.SEVEN, CardColor.Heart);
        Card flopCardTwo2 = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree2 = new Card(CardRank.J, CardColor.Spade);
        Card turnCard2 = new Card(CardRank.Q, CardColor.Club);
        Card riverCard2 = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards2 = new ArrayList<>();
        handsCards2.add(handCardOne2);
        handsCards2.add(handCardTwo2);
        ArrayList<Card> flopCards2 = new ArrayList<>();
        flopCards2.add(flopCardOne2);
        flopCards2.add(flopCardTwo2);
        flopCards2.add(flopCardThree2);


        HandAndTableCards handAndTableCards2 = new HandAndTableCards(player2, flopCards2, turnCard2, riverCard2);
        LayoutManager layoutManager2 = new LayoutManager(handAndTableCards2);

        ArrayList<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);

        LayoutComparing comparando = new LayoutComparing(listOfPlayers);

        Assertions.assertEquals(comparando.getWinner().getPokerLayout(), PokerLayout.ROYAL_FLUSH);
    }

    @Test
    void getWinnerWithSameLayout() {
        Player player1 = new Player("Dawid",100);

        Card handCardOne = new Card(CardRank.TWO, CardColor.Club);
        Card handCardTwo = new Card(CardRank.K, CardColor.Spade);
        Card flopCardOne = new Card(CardRank.Q, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.TWO, CardColor.Heart);
        Card flopCardThree = new Card(CardRank.J, CardColor.Diamond);
        Card turnCard = new Card(CardRank.SEVEN, CardColor.Club);
        Card riverCard = new Card(CardRank.EIGHT, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player1, flopCards, turnCard, riverCard);
        LayoutManager layoutManager1 = new LayoutManager(handAndTableCards);


        Player player2 = new Player("Adam",100);

        Card handCardOne2 = new Card(CardRank.EIGHT, CardColor.Diamond);
        Card handCardTwo2 = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne2 = new Card(CardRank.SEVEN, CardColor.Heart);
        Card flopCardTwo2 = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree2 = new Card(CardRank.J, CardColor.Spade);
        Card turnCard2 = new Card(CardRank.Q, CardColor.Club);
        Card riverCard2 = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards2 = new ArrayList<>();
        handsCards2.add(handCardOne2);
        handsCards2.add(handCardTwo2);
        ArrayList<Card> flopCards2 = new ArrayList<>();
        flopCards2.add(flopCardOne2);
        flopCards2.add(flopCardTwo2);
        flopCards2.add(flopCardThree2);


        HandAndTableCards handAndTableCards2 = new HandAndTableCards(player2, flopCards2, turnCard2, riverCard2);
        LayoutManager layoutManager2 = new LayoutManager(handAndTableCards2);

        ArrayList<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(player1);
        listOfPlayers.add(player2);

        LayoutComparing comparando = new LayoutComparing(listOfPlayers);

        Assertions.assertEquals("Dawid",comparando.getWinner().getPlayerName());
    }
}