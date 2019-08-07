import pl.cardtest.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LayoutManagerTest {

    @Test
    void shouldHaveHighCard() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.J, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.TWO, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasHighCard());

    }

    @Test
    void shouldShowHighCard() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Heart);
        Card handCardTwo = new Card(CardRank.A, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.TWO, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);


        Assertions.assertEquals(layoutManager.showHighCard().getRank(), CardRank.A);

    }

    @Test
    void shouldNotHaveHighCard() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.A, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.TWO, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasHighCard());

    }


    @Test
    void shouldHavePair() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasPair());

    }




    @Test
    void shouldNotHavePair() {
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.FOUR, CardColor.Spade);
        Card turnCard = new Card(CardRank.K, CardColor.Club);
        Card riverCard = new Card(CardRank.Q, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasPair());

    }

    @Test
    void shouldHaveThree() {
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.K, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.FOUR, CardColor.Spade);
        Card turnCard = new Card(CardRank.K, CardColor.Club);
        Card riverCard = new Card(CardRank.Q, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasThree());

    }

    @Test
    void shouldNotHaveThree() {
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.FOUR, CardColor.Spade);
        Card turnCard = new Card(CardRank.K, CardColor.Club);
        Card riverCard = new Card(CardRank.Q, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasThree());

    }

    @Test
    void shouldHaveQuads() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.K, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasQuads());

    }


    @Test
    void shouldNotHaveQuads() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.Q, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasQuads());

    }

    @Test
    void shouldHaveColor() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.K, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Diamond);
        Card riverCard = new Card(CardRank.K, CardColor.Diamond);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasColor());

    }

    @Test
    void shouldNotHaveColor() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Club);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.K, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Diamond);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasColor());

    }

    @Test
    void shouldShowPair() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.J, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.showPair().size() == 2 && layoutManager.showPair().get(0).getRank() == CardRank.K && layoutManager.showPair().get(1).getRank() == CardRank.K);
    }

    @Test
    void shouldNotShowPair() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.K, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.K, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.showPair().size() == 2 && layoutManager.showPair().get(0).getRank() == CardRank.K && layoutManager.showPair().get(1).getRank() == CardRank.K);
    }

    @Test
    void shouldShowThree() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.showThree().size() == 3 &&
                layoutManager.showThree().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(2).getRank() == CardRank.SEVEN);
    }

    @Test
    void shouldNotShowThree() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.K, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.showThree().size() == 3 &&
                layoutManager.showThree().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(2).getRank() == CardRank.SEVEN);
    }

    @Test
    void shouldShowQuads() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.showQuads().size() == 4 &&
                layoutManager.showQuads().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(2).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(3).getRank() == CardRank.SEVEN);
    }

    @Test
    void shouldNotShowQuads() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.showQuads().size() == 4 &&
                layoutManager.showQuads().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(2).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(3).getRank() == CardRank.SEVEN);
    }

    @Test
    void shouldShowFullHouse() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.THREE, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasFullHouse());
    }

    @Test
    void shouldHaveStraight() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.EIGHT, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.TEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.NINE, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasStraight());
    }

    @Test
    void shoulNotdHaveStraight() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.TWO, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.FOUR, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.TEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.NINE, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasStraight());
    }


    @Test
    void shouldShowStraight() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.EIGHT, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.TEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.NINE, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);
        ArrayList<Card> testList;
        testList = layoutManager.showStraight();
        Assertions.assertTrue(testList.contains(handCardTwo) &&
                testList.contains(turnCard) &&
                testList.contains(flopCardThree) &&
                testList.contains(flopCardTwo) &&
                testList.contains(flopCardOne));
    }


    @Test
    void shouldShowColor() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D", 100);

        Card handCardOne = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.EIGHT, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.TEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.NINE, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Diamond);
        Card riverCard = new Card(CardRank.SEVEN, CardColor.Diamond);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);
        Assertions.assertTrue(layoutManager.showColor().contains(handCardOne));
    }

    @Test
    void shouldHaveStraightFlash() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.EIGHT, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.TEN, CardColor.Diamond);
        Card flopCardTwo = new Card(CardRank.NINE, CardColor.Diamond);
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


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasStraightFlush());
    }


    @Test
    void shouldShowStraightFlash() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.EIGHT, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.TEN, CardColor.Diamond);
        Card flopCardTwo = new Card(CardRank.NINE, CardColor.Diamond);
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


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        System.out.println(layoutManager.showStraightFlush());
        Assertions.assertTrue(layoutManager.showStraightFlush().contains(handCardOne) &&
                layoutManager.showStraightFlush().contains(handCardTwo) &&
                layoutManager.showStraightFlush().contains(flopCardOne) &&
                layoutManager.showStraightFlush().contains(flopCardTwo) &&
                layoutManager.showStraightFlush().contains(flopCardThree));
    }


    @Test
    void shouldHaveRoyalFlash() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

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


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasRoyalFlush());
    }


    @Test
    void shouldShowRoyalFlash() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

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


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.showRoyalFlush().contains(handCardOne) &&
                layoutManager.showRoyalFlush().contains(handCardTwo) &&
                layoutManager.showRoyalFlush().contains(flopCardOne) &&
                layoutManager.showRoyalFlush().contains(flopCardTwo) &&
                layoutManager.showRoyalFlush().contains(flopCardThree));
    }

    @Test
    void shouldNotHaveTwoPairs() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Spade);
        Card handCardTwo = new Card(CardRank.K, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.K, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertFalse(layoutManager.hasTwoPairs());

    }

    @Test
    void shouldHaveTwoPairs() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.SEVEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);

        Assertions.assertTrue(layoutManager.hasTwoPairs());

    }


    @Test
    void shouldShowTwoPairs() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.SEVEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.J, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);


        Assertions.assertTrue(layoutManager.showTwoPairs().contains(handCardOne) &&
                layoutManager.showTwoPairs().contains(riverCard) &&
                layoutManager.showTwoPairs().contains(flopCardTwo) &&
                layoutManager.showTwoPairs().contains(flopCardOne));

    }

    @Test
    void finalLayoutOfPlayer() {
        //public pl.cardtest.HandAndTableCards(pl.cardtest.Player player, ArrayList<pl.cardtest.Card> handsCards, ArrayList<pl.cardtest.Card> flopCards, pl.cardtest.Card turnCard, pl.cardtest.Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.SEVEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);


        Assertions.assertEquals(layoutManager.finalLayoutOfPlayer(), PokerLayout.FULL_HOUSE);
    }

    @Test
    void updatePlayersLayout() {
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.K, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        player.addCardToPlayersHand(handCardOne);
        player.addCardToPlayersHand(handCardTwo);
        Card flopCardOne = new Card(CardRank.SEVEN, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.SEVEN, CardColor.Spade);
        Card turnCard = new Card(CardRank.Q, CardColor.Club);
        Card riverCard = new Card(CardRank.K, CardColor.Club);
        ArrayList<Card> handsCards = new ArrayList<>();
        handsCards.add(handCardOne);
        handsCards.add(handCardTwo);
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flopCardOne);
        flopCards.add(flopCardTwo);
        flopCards.add(flopCardThree);


        HandAndTableCards handAndTableCards = new HandAndTableCards(player, handsCards, flopCards, turnCard, riverCard);
        LayoutManager layoutManager = new LayoutManager(handAndTableCards);


        Assertions.assertEquals(layoutManager.getPlayer().getPokerLayout(), PokerLayout.FULL_HOUSE);
    }
}