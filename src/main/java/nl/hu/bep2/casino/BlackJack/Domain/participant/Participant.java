package nl.hu.bep2.casino.BlackJack.Domain.participant;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    protected List<Card> playerHand;
    protected int        currentHandValue;

    public Participant(){
        this.playerHand       = new ArrayList<>();
        this.currentHandValue = 0;
    }

    public void addCard(Card card, Boolean tenplus, int wincon){
        playerHand.add(card);
        calcHandValue(tenplus, wincon);
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public int getHandValue() {
        return currentHandValue;
    }

    public void calcHandValue(Boolean tenplus, int wincon){
        currentHandValue = 0;
        for (Card card: playerHand){
            if (!tenplus){
                if (card.getValue() == 1) {
                    if (currentHandValue + 11 <= wincon) {
                        currentHandValue = currentHandValue + 11;
                    } else {
                        currentHandValue = currentHandValue + 1;
                    }
                }else{
                if (card.getValue() > 9 && card.getValue() != 1) {
                    currentHandValue = currentHandValue + 10;
                } else {
                    currentHandValue = currentHandValue + card.getValue();
                }}
            }else{
                if (card.getValue() == 1) {
                    if (currentHandValue + 14 <= wincon) {
                        currentHandValue = currentHandValue + 14;
                    } else {
                        currentHandValue = currentHandValue + 1;
                    }
                }else{
                if (card.getValue() > 1) {
                    currentHandValue = currentHandValue + card.getValue();
                }}
            }
        }
    }
}
