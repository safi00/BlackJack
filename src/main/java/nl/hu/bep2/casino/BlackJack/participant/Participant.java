package nl.hu.bep2.casino.BlackJack.participant;

import nl.hu.bep2.casino.BlackJack.Deck.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    protected List<Card> playerHand;
    protected int        currentHandValue;

    public Participant(){
        this.playerHand       = new ArrayList<>();
        this.currentHandValue = 0;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public int getHandValue(){
        for (Card card: playerHand){
            if (card.getNumber()==1){
                if(currentHandValue + 11 <= 21){
                    currentHandValue = currentHandValue + 11;
                }else {
                    currentHandValue = currentHandValue + 1;
                }
            }
            if (card.getNumber()>9){
                currentHandValue = currentHandValue + 10;
            }else {
                currentHandValue = currentHandValue + card.getNumber();
            }
        }
        return currentHandValue;
    }
}
