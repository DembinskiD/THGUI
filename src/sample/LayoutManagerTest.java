package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LayoutManagerTest {

    @Test
    public void checkPair() {
        //public HandAndTableCards(Player player, ArrayList<Card> handsCards, ArrayList<Card> flopCards, Card turnCard, Card riverCard)
        Player player = new Player("D",100);

        Card handCardOne = new Card(CardRank.A, CardColor.Diamond);
        Card handCardTwo = new Card(CardRank.THREE, CardColor.Diamond);
        Card flopCardOne = new Card(CardRank.EIGHT, CardColor.Heart);
        Card flopCardTwo = new Card(CardRank.SEVEN, CardColor.Diamond);
        Card flopCardThree = new Card(CardRank.FOUR, CardColor.Spade);
        Card turnCard = new Card(CardRank.K, CardColor.Club);
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



}