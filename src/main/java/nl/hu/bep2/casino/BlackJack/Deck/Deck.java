package nl.hu.bep2.casino.BlackJack.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> gameDeck = new ArrayList<>();

    public Deck(int numberOfDeck){
        int gameDeckNum   = 0;
        int amountOfCards;

        if (numberOfDeck > 0){
            while (gameDeckNum < numberOfDeck){
                for (amountOfCards = 1;amountOfCards < 14; amountOfCards++){
                    gameDeck.add(new Card(amountOfCards,"Clubs"));
                    gameDeck.add(new Card(amountOfCards,"Diamonds"));
                    gameDeck.add(new Card(amountOfCards,"Hearts"));
                    gameDeck.add(new Card(amountOfCards,"Spades"));
                }
                gameDeckNum = gameDeckNum + 1;
            }
            Collections.shuffle(gameDeck);
        }
    }

    public List<Card> getGameDeck() {
        return gameDeck;
    }

    public void shuffleCards() {
        Collections.shuffle(gameDeck);
    }

    public Card dealCards(List<Card> gameDeck){
        Card returnValue = gameDeck.get(0);
        gameDeck.remove(0);
        return returnValue;
    }

    public String toString() {
        return gameDeck.toString();
    }
}
