package nl.hu.bep2.casino.BlackJack.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> gameDeck = new ArrayList<>();

    public Deck(int amountOfDecks, boolean addJokers){
        deckMaker(amountOfDecks);
           if (addJokers){
               int amountOfjokers;
               int totaljokers = 2 * amountOfDecks;
               for (amountOfjokers = 0; amountOfjokers < totaljokers; amountOfjokers++) {
                   gameDeck.add(new Card(14, Card.Suit.Joker));
               }
           }
    }

    public List<Card> getGameDeck() {
        return gameDeck;
    }

    public List<Card> deckMaker(int numberOfDecks){
        int gameDeckNum   = 0;
        int amountOfCards;
        int cardValue;

        if (numberOfDecks > 0){
            while (gameDeckNum < numberOfDecks){
                for (amountOfCards = 1;amountOfCards < 14; amountOfCards++){
                    cardValue = amountOfCards;
                    gameDeck.add(new Card(cardValue, Card.Suit.Clubs));
                    gameDeck.add(new Card(cardValue, Card.Suit.Diamonds));
                    gameDeck.add(new Card(cardValue, Card.Suit.Hearts));
                    gameDeck.add(new Card(cardValue, Card.Suit.Spades));
                }
                gameDeckNum = gameDeckNum + 1;
            }
            Collections.shuffle(gameDeck);
        }
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
