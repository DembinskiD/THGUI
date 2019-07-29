package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LayoutManagerTest {


    @Test
    public void shouldHavePair() {
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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

        layoutManager.showPair().stream().forEach(System.out::println);
        Assertions.assertTrue(layoutManager.showPair().size() == 2 && layoutManager.showPair().get(0).getRank() == CardRank.K && layoutManager.showPair().get(1).getRank() == CardRank.K);
    }

    @Test
    public void shouldNotShowPair() {
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
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

}