package nl.hu.bep2.casino.BlackJack.participant;

import nl.hu.bep2.casino.BlackJack.Deck.Card;

import java.util.List;

public class Dealer extends Participant {
    private String dealername;

    public Dealer(){
        super();
        dealername = "Dealer";
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public int getHandValue(){
        for (Card card: playerHand){
            if (card.getValue()==1){
                if(currentHandValue + 11 <= 21){
                    currentHandValue = currentHandValue + 11;
                }else {
                    currentHandValue = currentHandValue + 1;
                }
            }
            if (card.getValue()>9){
                currentHandValue = currentHandValue + 10;
            }else {
                currentHandValue = currentHandValue + card.getValue();
            }
        }
        return currentHandValue;
    }
}
