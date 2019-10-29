package pl.cardtest;

import java.net.PasswordAuthentication;
import java.util.*;
import java.util.stream.Collectors;

public class OpponentAI extends Player {

    public OpponentAI(String playerName, int initialPlayerCash, PlayerPosition playerPosition) {
        super(playerName, initialPlayerCash, playerPosition);
    }

    public PlayerStatus decideAfterFlop(ArrayList<Card> cards, int raiseCash, int smallBlind) {
        assert cards.size() == 5 || cards.size() == 6 || cards.size() == 7: "cards[] length different than 5!";
        Collections.sort(cards);
        if(new Random().nextInt(10) == 0) {
            switch (new Random().nextInt(4))
            {
                case 0:
                    return PlayerStatus.PASS;
                case 1:
                    return PlayerStatus.CALL;
                case 2:
                    return PlayerStatus.RAISE;
                case 3:
                    return PlayerStatus.ALLIN;
                default:
                    return PlayerStatus.CALL;
            }
        } else {
            //here algorithm for 'not lying' with all 5 cards
            if(hasQuads(cards)) return PlayerStatus.ALLIN; // 4 takie same
            else if(cards.stream().distinct().count() == cards.size()) { // każda inna
                if(super.hasColor(cards)) { //5 kart w kolorze
                    return cards.get(0).getRank().number > 8 ? PlayerStatus.ALLIN : PlayerStatus.CALL;
                } else if(cards.stream().collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum)).containsValue(4)) { //4 karty w kolorze
                    return cards.get(0).getRank().number > 8 ? PlayerStatus.RAISE : PlayerStatus.CALL;
                } else if(cards.stream().collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum)).containsValue(3)) { //3 karty w kolorze
                    return cards.get(0).getRank().number > 8 ? PlayerStatus.RAISE : PlayerStatus.CALL;
                } else { //max 2 karty w kolorze
                    return cards.get(4).getRank().number - cards.get(0).getRank().number == 4 ? PlayerStatus.RAISE :
                            cards.get(0).getRank().number > 8 ? PlayerStatus.RAISE : PlayerStatus.CALL;//ma straighta
                }
            } else if(hasTwoPairs(cards)) { //2 pary
                ArrayList<Card> c1 = super.showTwoPairs(cards);
                c1.sort(Card::compareTo);
                return c1.get(0).getRank().number < 4  || c1.get(3).getRank().number < 4 ? PlayerStatus.PASS : PlayerStatus.CALL;
            } else if(hasFullHouse(cards)) { //full
                return showThree(showFullHouse(cards)).get(0).getRank().number < showPair(showPair(showFullHouse(cards))).get(0).getRank().number ?
                        cards.get(0).getRank().number > 10 ? PlayerStatus.RAISE : PlayerStatus.CALL : PlayerStatus.RAISE;

            } else if(hasThree(cards)) {//trojka
                return showThree(cards).get(0).getRank().number > 8 ? PlayerStatus.RAISE : raiseCash > 2*smallBlind ? PlayerStatus.PASS : PlayerStatus.CALL;
            } else if(hasPair(cards)) { //hasPair
                return raiseCash > 4*smallBlind ? showPair(cards).get(0).getRank().number > 10 ? PlayerStatus.CALL : PlayerStatus.PASS : PlayerStatus.CALL;
            } else if(hasColor(cards)) return PlayerStatus.ALLIN;
            else if(cards.stream().collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum)).containsValue(4)) { //4 karty w kolorze
                return cards.size() < 7 ? cards.size() == 6 ? PlayerStatus.CALL : PlayerStatus.RAISE : PlayerStatus.PASS;
            } else if(cards.stream().collect(Collectors.toMap(Card::getColor, e -> 1, Integer::sum)).containsValue(3)) { //3 karty w kolorze
                return cards.size() < 6 ? PlayerStatus.CALL : PlayerStatus.PASS;
            } else return PlayerStatus.PASS;
        }
    }

    public PlayerStatus decideBeforeFlop(Card c1, Card c2, int raiseCash, int smallBlind) {
        if(new Random().nextInt(10) == 0) { //w tym miejscu dodane jest kłamanie przeciwnika
            switch (new Random().nextInt(4))
            {
                case 0:
                    return PlayerStatus.PASS;
                case 1:
                    return PlayerStatus.CALL;
                case 2:
                    return PlayerStatus.RAISE;
                case 3:
                    return PlayerStatus.ALLIN;
                default:
                    return PlayerStatus.CALL;
            }
        }else {
            if(c1.getRank().equals(c2.getRank())) {
                if (c1.getColor().equals(c2.getColor())){
                    if(raiseCash >= 4*smallBlind) {
                        return c1.getRank().number <= 8 ? PlayerStatus.CALL : c1.getRank().number <= 13 ? PlayerStatus.RAISE : PlayerStatus.ALLIN;
                    } else {
                        return raiseCash <= 2*smallBlind ? PlayerStatus.CALL : c1.getRank().number > 8 ? PlayerStatus.CALL : PlayerStatus.RAISE;
                    }
                }else {
                    if(raiseCash >= 4*smallBlind) {
                        return c1.getRank().number <= 8 ? PlayerStatus.PASS : c1.getRank().number <= 13 ? PlayerStatus.CALL : PlayerStatus.ALLIN;
                    } else {
                        return c1.getRank().number > 8 ? PlayerStatus.CALL : raiseCash < 2*smallBlind ? PlayerStatus.CALL : PlayerStatus.PASS;
                    }
                }
            } else {
                assert c1.getRank() != c2.getRank(): "Something went wrong, c1 rank is the same as c2 rank.";
                assert c1.getRank().isBiggerThan(c2.getRank()) : "c1' rank isn't higher than rank of c2";
                if(c1.getColor().equals(c2.getColor())) {
                    if(c1.getRank().number - c2.getRank().number >= 5) {
                        return c1.getRank().number > 8 || c2.getRank().number > 8 ?
                                raiseCash >= 4*smallBlind ? PlayerStatus.RAISE : PlayerStatus.CALL : PlayerStatus.CALL;
                    } else {
                        return c1.getRank().number > 8 || c2.getRank().number > 8 ? PlayerStatus.RAISE : PlayerStatus.CALL;
                    }
                }else {
                    if (c1.getRank().number - c2.getRank().number >= 5) {
                        return c1.getRank().number > 12 || c2.getRank().number > 12 ? raiseCash > 4 * smallBlind ? PlayerStatus.PASS : PlayerStatus.CALL : PlayerStatus.PASS;
                    } else {
                        return c1.getRank().number > 8 || c2.getRank().number > 8 ? PlayerStatus.CALL : PlayerStatus.PASS;
                    }
                }
            }
        }
    }

}
