import Engine.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LayoutManagerTest {

    @Test
    public void shouldHaveHighCard() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldShowHighCard() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        System.out.println(layoutManager.showHighCard());

        Assertions.assertTrue(layoutManager.showHighCard().getRank().equals(CardRank.A));

    }

    @Test
    public void shouldNotHaveHighCard() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldHavePair() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldNotHavePair() {
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
    public void shouldHaveThree() {
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
    public void shouldNotHaveThree() {
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
    public void shouldHaveQuads() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldNotHaveQuads() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldHaveColor() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldNotHaveColor() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldShowPair() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showPair().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.showPair().size() == 2 && layoutManager.showPair().get(0).getRank() == CardRank.K && layoutManager.showPair().get(1).getRank() == CardRank.K);
    }

    @Test
    public void shouldNotShowPair() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showPair().stream().forEach(System.out::println);
        Assertions.assertFalse(layoutManager.showPair().size() == 2 && layoutManager.showPair().get(0).getRank() == CardRank.K && layoutManager.showPair().get(1).getRank() == CardRank.K);
    }

    @Test
    public void shouldShowThree() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showThree().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.showThree().size() == 3 &&
                layoutManager.showThree().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(2).getRank() == CardRank.SEVEN);
    }

    @Test
    public void shouldNotShowThree() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showThree().stream().forEach(System.out::println);
        Assertions.assertFalse(layoutManager.showThree().size() == 3 &&
                layoutManager.showThree().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showThree().get(2).getRank() == CardRank.SEVEN);
    }

    @Test
    public void shouldShowQuads() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showQuads().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.showQuads().size() == 4 &&
                layoutManager.showQuads().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(2).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(3).getRank() == CardRank.SEVEN);
    }

    @Test
    public void shouldNotShowQuads() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showQuads().stream().forEach(System.out::println);
        Assertions.assertFalse(layoutManager.showQuads().size() == 4 &&
                layoutManager.showQuads().get(0).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(1).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(2).getRank() == CardRank.SEVEN &&
                layoutManager.showQuads().get(3).getRank() == CardRank.SEVEN);
    }

    @Test
    public void shouldShowFullHouse() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        layoutManager.showFullHouse().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.hasFullHouse());
    }

    @Test
    public void shouldHaveStraight() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        //layoutManager.showFullHouse().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.hasStraight());
    }

    @Test
    public void shoulNotdHaveStraight() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        //layoutManager.showFullHouse().stream().forEach(System.out::println);
        Assertions.assertFalse(layoutManager.hasStraight());
    }


    @Test
    public void shouldShowStraight() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
        //layoutManager.showFullHouse().stream().forEach(System.out::println);
        Assertions.assertTrue(testList.contains(handCardTwo) &&
                testList.contains(turnCard) &&
                testList.contains(flopCardThree) &&
                testList.contains(flopCardTwo) &&
                testList.contains(flopCardOne));
    }


    @Test
    public void shouldShowColor() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldHaveStraightFlash() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        //layoutManager.showFullHouse().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.hasStraightFlush());
    }


    @Test
    public void shouldShowStraightFlash() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldHaveRoyalFlash() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        //layoutManager.showFullHouse().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.hasRoyalFlush());
    }


    @Test
    public void shouldShowRoyalFlash() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        //layoutManager.showFullHouse().stream().forEach(System.out::println);
        System.out.println(layoutManager.showRoyalFlush());
        Assertions.assertTrue(layoutManager.showRoyalFlush().contains(handCardOne) &&
                layoutManager.showRoyalFlush().contains(handCardTwo) &&
                layoutManager.showRoyalFlush().contains(flopCardOne) &&
                layoutManager.showRoyalFlush().contains(flopCardTwo) &&
                layoutManager.showRoyalFlush().contains(flopCardThree));
    }

    @Test
    public void shouldNotHaveTwoPairs() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldHaveTwoPairs() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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
    public void shouldShowTwoPairs() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        System.out.println(layoutManager.showTwoPairs());

        Assertions.assertTrue(layoutManager.showTwoPairs().contains(handCardOne) &&
                layoutManager.showTwoPairs().contains(riverCard) &&
                layoutManager.showTwoPairs().contains(flopCardTwo) &&
                layoutManager.showTwoPairs().contains(flopCardOne));

    }

    @Test
    void finalLayoutOfPlayer() {
        //public Engine.HandAndTableCards(Engine.Player player, ArrayList<Engine.Card> handsCards, ArrayList<Engine.Card> flopCards, Engine.Card turnCard, Engine.Card riverCard)
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

        System.out.println(layoutManager.showTwoPairs());

        Assertions.assertTrue(layoutManager.finalLayoutOfPlayer().equals(PokerLayout.FULL_HOUSE));
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



        System.out.println(layoutManager.getPlayer());

        Assertions.assertTrue(layoutManager.getPlayer().getPokerLayout().equals(PokerLayout.FULL_HOUSE));
    }
}