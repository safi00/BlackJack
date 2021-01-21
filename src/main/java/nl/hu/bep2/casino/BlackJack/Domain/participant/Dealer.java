package nl.hu.bep2.casino.BlackJack.Domain.participant;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Card;
import nl.hu.bep2.casino.BlackJack.Domain.Rules;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Participant {
    private int showedValue;
    private final String dealername;

    public Dealer(){
        super();
        dealername = "Dealer";
    }

    public List<Card> getDealerHand() {
        return playerHand;
    }

    public int getCurrentHandValue() {
        return currentHandValue;
    }

    public List<Card> showDealercards(Rules rules) {
        List<Card> revealedList = new ArrayList<>();

        int totalcards = getDealerHand().size();

        for (int i = 1; i < totalcards; i++){
            revealedList.add(getDealerHand().get(i));
            calcShownHandValue(rules.isTenPlus());
        }
        return revealedList;
    }

    public String getDealername(){
        return dealername;
    }

    public int getShowedValue() {
        return showedValue;
    }

    public void calcShownHandValue(Boolean tenplus){
        showedValue = 0;
        for (Card card: playerHand){
            if (!tenplus){
                if (card.getValue() == 1) {
                    currentHandValue = currentHandValue + 11;
                }else {
                    if (card.getValue() > 9 && card.getValue() != 1) {
                        currentHandValue = currentHandValue + 10;
                    } else {
                        currentHandValue = currentHandValue + card.getValue();
                    }
                }
            }else{
                if (card.getValue() == 1) {
                        currentHandValue = currentHandValue + 14;
                }else{
                    if (card.getValue() > 1) {
                        currentHandValue = currentHandValue + card.getValue();
                    }
                }
            }
        }
    }
}
