package Engine;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PokerLayouts {

    //todo sprawdzanie poker layoutu niech bedzie interfejsem, zostanie zaimplementowany przez player(rowniez oponentAI, do sprawdzania co w danej chwili mamy, jaki layout
    //todo ma rowniez zwracac Engine.PokerLayout Enum.

    default boolean hasHighCard(ArrayList<Card> inputCards) {
        return !hasPair(inputCards) &&
                !hasThree(inputCards) && !hasQuads(inputCards) &&
                !hasColor(inputCards) && !hasFullHouse(inputCards) && !hasStraight(inputCards) &&
                !hasStraightFlush(inputCards) && !hasTwoPairs(inputCards);
    }

    default Card showHighCard(ArrayList<Card> inputCards) {
        return inputCards.stream().max(Comparator.comparing(Card::getRank)).orElse(null);
    }

    default boolean hasPair(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(2);
    }

    default ArrayList<Card> showPair(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 2);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        //Set<Engine.Card> duplicated = inputCards.stream().filter(n -> inputCards.stream().filter(x -> x.getRank() == n.getRank()).count() == 2).collect(Collectors.toSet());
        //duplicated.forEach(a -> System.out.println(a));
        return outputCards;
    }

    default boolean hasThree(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(3);
    }

    default ArrayList<Card> showThree(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 3);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        return outputCards;
    }

    default public boolean hasTwoPairs(ArrayList<Card> inputCards) {
        ArrayList<Card> outputList= new ArrayList<>(showPair(inputCards));
        System.out.println(outputList);
        return outputList.size() == 4;
    }

    default ArrayList<Card> showTwoPairs(ArrayList<Card> inputCards) {
        return showPair(inputCards);
    }

    default boolean hasQuads(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(4);
    }

    default ArrayList<Card> showQuads(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 4);
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> outputCards = new ArrayList<>(list);
        return outputCards;
    }

    default boolean hasColor(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum)).containsValue(5);
    }

    default ArrayList<Card> showColor(ArrayList<Card> inputCards) {
        ArrayList<Card> outputList;
        CardColor color = inputCards.stream().collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(cardColorIntegerEntry -> cardColorIntegerEntry.getValue().equals(5))
                .map(Map.Entry::getKey).findFirst().orElse(null);
        if(color == null) return null;
        else {
            outputList = new ArrayList<>();
            for(Card card : inputCards){
                if (card.getColor().equals(color)) outputList.add(card);
            }

            return outputList;
        }

    }

    default boolean hasFullHouse(ArrayList<Card> inputCards) {
        ArrayList<Card> outputList = new ArrayList<>(inputCards);
        if(!hasThree(inputCards)) return false;
        if(hasThree(inputCards)){
            outputList.removeAll(showThree(inputCards));
        }
        return hasPair(outputList);
    }

    default ArrayList<Card> showFullHouse(ArrayList<Card> inputCards) {
        ArrayList<Card> tempList = new ArrayList<>(inputCards);
        ArrayList<Card> outputList = showThree(tempList);
        tempList.removeAll(showThree(tempList));
        outputList.addAll(showPair(tempList));
        return outputList;
    }

    default boolean hasStraight(ArrayList<Card> inputCards) {

        Stream<Card> stream = inputCards.stream().sorted((c1, c2) -> c1.compareRanksByNumber(c2));
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> tempList = new ArrayList<>(list);
        ArrayList<Card> outputList = new ArrayList<>();
        int checker = tempList.get(0).getRank().number;
        for (int i = 1; i < tempList.size() ; i++) {
            if(checker == tempList.get(i).getRank().number - 1) {
                if(outputList.isEmpty()) outputList.add(tempList.get(0));
                outputList.add(tempList.get(i));
                checker++;
            }
        }
        return outputList.size() >= 5;
    }

    default ArrayList<Card> showStraight(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().sorted((c1, c2) -> c1.compareRanksByNumber(c2));
        List<Card> list = stream.collect(Collectors.toList());
        ArrayList<Card> tempList = new ArrayList<>(list);
        ArrayList<Card> outputList = new ArrayList<>();
        int checker = tempList.get(0).getRank().number;
        for (int i = 1; i < tempList.size() ; i++) {
            if(checker == tempList.get(i).getRank().number - 1) {
                if(outputList.isEmpty()) outputList.add(tempList.get(0));
                outputList.add(tempList.get(i));
                checker++;
            }
        }
        Collections.sort(outputList, Collections.reverseOrder());
        if(outputList.size() > 5){
            for (int i = 0 ; i < outputList.size() - 5; i++) outputList.remove(5+i);
        }
        Collections.sort(outputList);
        return outputList;
    }

    default boolean hasStraightFlush(ArrayList<Card> inputCards) {
        return (showColor(inputCards) != null && showColor(inputCards).size() != 0) && hasStraight(showColor(inputCards));

    }

    default ArrayList<Card> showStraightFlush(ArrayList<Card> inputCards) {
        ArrayList<Card> tempList = new ArrayList<>(showColor(inputCards));
        ArrayList<Card> outputList = new ArrayList<>();
        outputList.addAll(showStraight(tempList));
        return outputList;
    }

    default boolean hasRoyalFlush(ArrayList<Card> inputCards) {
        return hasStraightFlush(inputCards) &&
                showStraightFlush(inputCards).stream().collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsKey(CardRank.A);
    }

    default ArrayList<Card> showRoyalFlush(ArrayList<Card> inputCards) {
        return showStraightFlush(inputCards);
    }


    default PokerLayout finalLayoutOfPlayer(ArrayList<Card> inputCards) {
        if(hasRoyalFlush(inputCards)){
            return PokerLayout.ROYAL_FLUSH;
        }
        if(hasStraightFlush(inputCards)){
            return PokerLayout.STRAIGHT_FLUSH;
        }
        if(hasQuads(inputCards)) {
            return PokerLayout.QUADS;
        }
        if(hasFullHouse(inputCards)) {
            return PokerLayout.FULL_HOUSE;
        }
        if(hasColor(inputCards)) {
            return PokerLayout.FLUSH;
        }
        if(hasStraight(inputCards)) {
            return PokerLayout.STREIGH;
        }
        if(hasThree(inputCards)) {
            return PokerLayout.THREE;
        }
        if(hasTwoPairs(inputCards)) {
            return PokerLayout.TWO_PAIRS;
        }
        if(hasPair(inputCards)) {
            return PokerLayout.PAIR;
        }
        else {
            return PokerLayout.HIGH_CARD;
        }
    }


    default ArrayList<Card> finalLayoutCardsOfPlayer(ArrayList<Card> inputCards) {
        if(hasRoyalFlush(inputCards)){
            return showRoyalFlush(inputCards);
        }
        if(hasStraightFlush(inputCards)){
            return showStraightFlush(inputCards);
        }
        if(hasQuads(inputCards)) {
            return showQuads(inputCards);
        }
        if(hasFullHouse(inputCards)) {
            return showFullHouse(inputCards);
        }
        if(hasColor(inputCards)) {
            return showColor(inputCards);
        }
        if(hasStraight(inputCards)) {
            return showStraight(inputCards);
        }
        if(hasThree(inputCards)) {
            return showThree(inputCards);
        }
        if(hasTwoPairs(inputCards)) {
            return showTwoPairs(inputCards);
        }
        if(hasPair(inputCards)) {
            return showPair(inputCards);
        }
        else {
            ArrayList<Card> tempList = new ArrayList<>();
            tempList.add(showHighCard(inputCards));
            return tempList;
        }
    }





}
