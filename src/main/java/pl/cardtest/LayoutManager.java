package pl.cardtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LayoutManager {
    private final ArrayList<Card> inputCards;
    private final Player player;
    private final ArrayList<Card> layoutCards = new ArrayList<>();

    public LayoutManager(HandAndTableCards handAndTableCards) {
        this.inputCards = handAndTableCards.getAllCardsCombined();
        this.player = handAndTableCards.getPlayer();
        updatePlayersLayout();
    }

    public Player getPlayer() {
        return player;
    }
    //todo need to create all poker layouts to have output about players layouts and also comparers for same layouts

    private void updatePlayersLayout() {
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


    public boolean hasTwoPairs() {
        ArrayList<Card> outputList= new ArrayList<>(showPair(inputCards));
        return outputList.size() == 4;
    }

    public ArrayList<Card> showTwoPairs() {
        return showPair(inputCards);
    }

    public boolean hasPair() {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(2);
    }

    private boolean hasPair(ArrayList<Card> inputCards) {
        return inputCards.stream()
                .collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsValue(2);
    }

    public boolean hasThree() {
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

        Stream<Card> stream = inputCards.stream().sorted(Card::compareRanksByNumber);
         ArrayList<Card> tempList = stream.collect(Collectors.toCollection(ArrayList::new));
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


    private boolean hasStraight(ArrayList<Card> inputCards) {

        if(inputCards.size() == 0 || inputCards.equals(null)) return false;
        else {
            Stream<Card> stream = inputCards.stream().sorted(Card::compareRanksByNumber);
            ArrayList<Card> tempList = stream.collect(Collectors.toCollection(ArrayList::new));
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

    }

     public boolean hasStraightFlush() {
        return (showColor() != null && showColor().size() != 0) && hasStraight(showColor());

     }

     public boolean hasRoyalFlush() {
         return hasStraightFlush() && showStraightFlush().stream().collect(Collectors.toMap(Card::getRank, e -> 1, Integer::sum)).containsKey(CardRank.A);
     }

     public ArrayList<Card> showRoyalFlush() {
        return showStraightFlush();
     }

     public ArrayList<Card> showStraightFlush() {
        ArrayList<Card> tempList = new ArrayList<>(showColor());
         return new ArrayList<>(showStraight(tempList));
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
         Stream<Card> stream = inputCards.stream().sorted(Card::compareRanksByNumber);
         ArrayList<Card> tempList = stream.collect(Collectors.toCollection(ArrayList::new));
         ArrayList<Card> outputList = new ArrayList<>();
         int checker = tempList.get(0).getRank().number;
         for (int i = 1; i < tempList.size() ; i++) {
             if(checker == tempList.get(i).getRank().number - 1) {
                 if(outputList.isEmpty()) outputList.add(tempList.get(0));
                 outputList.add(tempList.get(i));
                 checker++;
             }
         }
         outputList.sort(Collections.reverseOrder());
            //docinanie listy do rozmiaru 5
         if(outputList.size() > 5){
             for (int i = 0 ; i < outputList.size() - 5; i++) outputList.remove(5+i);
         }
         Collections.sort(outputList);
         return outputList;
     }

    private ArrayList<Card> showStraight(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().sorted(Card::compareRanksByNumber);
        ArrayList<Card> tempList = stream.collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Card> outputList = new ArrayList<>();
        int checker = tempList.get(0).getRank().number;
        for (int i = 1; i < tempList.size() ; i++) {
            if(checker == tempList.get(i).getRank().number - 1) {
                if(outputList.isEmpty()) outputList.add(tempList.get(0));
                outputList.add(tempList.get(i));
                checker++;
            }
        }
        outputList.sort(Collections.reverseOrder());
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
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Card> showPair(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 2);
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Card> showThree() {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 3);
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }
    private ArrayList<Card> showThree(ArrayList<Card> inputCards) {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 3);
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Card> showQuads() {
        Stream<Card> stream = inputCards.stream().filter(c1 -> inputCards.stream().filter(c2 -> c2.getRank() == c1.getRank()).count() == 4);
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Card> showFullHouse() {
        ArrayList<Card> tempList = new ArrayList<>(inputCards);
        ArrayList<Card> outputList = showThree(tempList);
        tempList.removeAll(showThree(tempList));
        outputList.addAll(showPair(tempList));
        return outputList;
    }






}
