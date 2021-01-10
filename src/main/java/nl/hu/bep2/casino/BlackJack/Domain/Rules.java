package nl.hu.bep2.casino.BlackJack.Domain;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Deck;

public class Rules {
    boolean tenPlus;
    int     wincondition;
    Deck    BJdeck;

    public Rules(int numberOfDecks, boolean tenPlus, boolean withJoker, int wincondition){
        BJdeck = new Deck(numberOfDecks,withJoker);
        this.tenPlus = tenPlus;
        if (wincondition==0){
            this.wincondition = 21;
        }else{
            if (wincondition > 14 && wincondition < 32){
                this.wincondition = wincondition;
            } else {
                if (wincondition > 22){
                    this.wincondition = 31;
                } else{
                    this.wincondition = 15;
                }
            }
        }
    }

    public boolean isTenPlus() {
        return tenPlus;
    }

    public boolean areJokersAvailable(){
        return BJdeck.areJokersAvailable();
    }

    public int getWincondition() {
        return wincondition;
    }

    public int getAmount(){
        return BJdeck.getAmountOfDecks();
    }

    public Deck getBJdeck() {
        return BJdeck;
    }

}
//{}