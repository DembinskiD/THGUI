package sample;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LayoutManager {
    private ArrayList<Card> inputCards;
    private Player player;
    private ArrayList<Card> layoutCards = new ArrayList<>();

    public LayoutManager(HandAndTableCards handAndTableCards) {
        this.inputCards = handAndTableCards.getAllCardsCombined();
        this.player = handAndTableCards.getPlayer();
        updatePlayersLayout();
    }

    public ArrayList<Card> getLayoutCards() {
        return layoutCards;
    }

    public Player getPlayer() {
        return player;
    }
    //todo need to create all poker layouts to have output about players layouts and also comparers for same layouts

    public void updatePlayersLayout() {
        this.player.setPokerLayout(finalLayoutOfPlayer());
        this.player.setCardsContainedInLayout(this.layoutCards);
    }

    public PokerLayout finalLayoutOfPlayer() {
        if(hasRoyalFlush()){
            layoutCards.addAll(showRoyalFlush());
            return PokerLayout.ROYAL_FLUSH;
        }
        if(hasStraightFlush()){
            layoutCards.addAll(showStraightFlush());
            return PokerLayout.STRAIGHT_FLUSH;
        }
        if(hasQuads()) {
            layoutCards.addAll(showQuads());
            return PokerLayout.QUADS;
        }
        if(hasFullHouse()) {
            layoutCards.addAll(showFullHouse());
            return PokerLayout.FULL_HOUSE;
        }
        if(hasColor()) {
            layoutCards.addAll(showColor());
            return PokerLayout.FLUSH;
        }
        if(hasStraight()) {
            layoutCards.addAll(showStraight());
            return PokerLayout.STREIGH;
        }
        if(hasThree()) {
            layoutCards.addAll(showThree());
            return PokerLayout.THREE;
        }
        if(hasTwoPairs()) {
            layoutCards.addAll(showTwoPairs());
            return PokerLayout.TWO_PAIRS;
        }
        if(hasPair()) {
            layoutCards.addAll(showPair());
            return PokerLayout.PAIR;
        }
        else {
            layoutCards.add(showHighCard());
            return PokerLayout.HIGH_CARD;
        }
    }

    public boolean hasHighCard() {
        return !hasPair() && !hasThree() && !hasQuads() && !hasColor() && !hasFullHouse() && !hasStraight() && !hasStraightFlush() && !hasTwoPairs();
    }

    public Card showHighCard() {
        return inputCards.stream().max(Comparator.comparing(Card::getRank)).orElse(null);
    }

    //todo showpair

    public boolean hasTwoPairs() {
        ArrayList<Card> outputList= new ArrayList<>(showPair(inputCards));
        System.out.println(outputList);
        return outputList.size() == 4;
    }

    public ArrayList<Card> showTwoPairs() {
        return showPair(inputCards);
    }

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
        ArrayList<Card> tempList = new ArrayList<>(list);
        ArrayList<Card> outputList = new ArrayList<>();
         int checker = tempList.get(0).getRank().number;
         for (int i = 1; i < tempList.size() ; i++) {
             if(checker == tempList.get(i).getRank().number - 1) {
                 if(outputList.isEmpty()) outputList.add(tempList.get(0));
                 System.out.println(tempList.get(i));
                 outputList.add(tempList.get(i));
                 checker++;
             }
         }
         System.out.println("here");
         outputList.forEach(System.out::println);
        return outputList.size() >= 5;
     }


    public boolean hasStraight(ArrayList<Card> inputCards) {

        if(inputCards.size() == 0 || inputCards.equals(null)) return false;
        else {
            Stream<Card> stream = inputCards.stream().sorted((c1, c2) -> c1.compareRanksByNumber(c2));
            List<Card> list = stream.collect(Collectors.toList());
            ArrayList<Card> tempList = new ArrayList<>(list);
            ArrayList<Card> outputList = new ArrayList<>();
            int checker = tempList.get(0).getRank().number;
            for (int i = 1; i < tempList.size() ; i++) {
                if(checker == tempList.get(i).getRank().number - 1) {
                    if(outputList.isEmpty()) outputList.add(tempList.get(0));
                    System.out.println(tempList.get(i));
                    outputList.add(tempList.get(i));
                    checker++;
                }
            }
            System.out.println("here");
            outputList.forEach(System.out::println);
            return outputList.size() >= 5;
        }

    }

     public boolean hasStraightFlush() {
        return (showColor() != null && showColor().size() != 0) ? hasStraight(showColor()) : false;

     }

     public boolean hasRoyalFlush() {
         return hasStraightFlush() && showStraightFlush().stream().collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsKey(CardRank.A);
     }

     public ArrayList<Card> showRoyalFlush() {
        return showStraightFlush();
     }

     public ArrayList<Card> showStraightFlush() {
        ArrayList<Card> tempList = new ArrayList<>(showColor());
        ArrayList<Card> outputList = new ArrayList<>();
        outputList.addAll(showStraight(tempList));
        return outputList;
     }


     public ArrayList<Card> showColor() {
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



     public ArrayList<Card> showStraight() {
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
            //docinanie listy do rozmiaru 5
         if(outputList.size() > 5){
             for (int i = 0 ; i < outputList.size() - 5; i++) outputList.remove(5+i);
         }
         Collections.sort(outputList);
         return outputList;
     }

    public ArrayList<Card> showStraight(ArrayList<Card> inputCards) {
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
        //docinanie listy do rozmiaru 5
        if(outputList.size() > 5){
            for (int i = 0 ; i < outputList.size() - 5; i++) outputList.remove(5+i);
        }
        Collections.sort(outputList);
        return outputList;
    }



    public ArrayList<Card> showPair() {
//changes here must be checked against HasTwoPairs method
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
