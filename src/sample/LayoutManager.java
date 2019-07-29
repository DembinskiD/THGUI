package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LayoutManager {
    private ArrayList<Card> inputCards;
    private Player player;

    public LayoutManager(HandAndTableCards handAndTableCards) {
        this.inputCards = handAndTableCards.getAllCardsCombined();
        this.player = handAndTableCards.getPlayer();
    }

    //todo need to create all poker layouts to have output about players layouts and also comparers for same layouts
    //todo HIGH_CARD,STRAIGHT,STRAIGHT_FLUSH,ROYAL_FLUSH


    public boolean hasPair() {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(2);
    }

    public boolean hasPair(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(2);
    }

    public boolean hasThree() {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(3);
    }

    public boolean hasThree(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(3);
    }


    public boolean hasQuads() {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(4);
    }

    public boolean hasColor() {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum)).containsValue(5);
    }

     public boolean hasFullHouse() {
        ArrayList<Card> outputList = new ArrayList<>(inputCards);
        if(!hasThree()) return false;
        if(hasThree()){
            outputList.removeAll(showThree());
        }
        return hasPair(outputList);
     }

     public boolean hasStraight() {

        Stream<Card> stream = inputCards.stream().sorted((c1, c2) -> c1.compareRanksByNumber(c2));
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputList = new ArrayList<>(list);
//todo stworzyc tutaj sprawdzanie czy istnieje straight
        return outputList.size() == 5;
     }



    public ArrayList<Card> showPair() {

        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 2);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        //Set<Card> duplicated = inputCards.stream().filter(n -> inputCards.stream().filter(x -> x.getRank() == n.getRank()).count() == 2).collect(Collectors.toSet());
        //duplicated.forEach(a -> System.out.println(a));
        return outputCards;
    }

    public ArrayList<Card> showPair(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 2);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        //Set<Card> duplicated = inputCards.stream().filter(n -> inputCards.stream().filter(x -> x.getRank() == n.getRank()).count() == 2).collect(Collectors.toSet());
        //duplicated.forEach(a -> System.out.println(a));
        return outputCards;
    }


    public ArrayList<Card> showThree() {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 3);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        return outputCards;
    }
    public ArrayList<Card> showThree(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 3);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        return outputCards;
    }


    public ArrayList<Card> showQuads() {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 4);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        return outputCards;
    }

    public ArrayList<Card> showQuads(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 4);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        return outputCards;
    }

    public ArrayList<Card> showFullHouse() {
        ArrayList<Card> tempList = new ArrayList<>(inputCards);
        ArrayList<Card> outputList = showThree(tempList);
        tempList.removeAll(showThree(tempList));
        outputList.addAll(showPair(tempList));
        return outputList;
    }






}
