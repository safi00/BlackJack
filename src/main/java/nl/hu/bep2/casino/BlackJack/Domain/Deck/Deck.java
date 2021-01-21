package nl.hu.bep2.casino.BlackJack.Domain.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> gameDeck = new ArrayList<>();
    private final int amountOfDecks;
    private final boolean Jokers;

    public Deck(int amountOfDecks, boolean addJokers){
        this.amountOfDecks = amountOfDecks;
        this.Jokers        = addJokers;
        deckMaker(amountOfDecks,addJokers);
        Collections.shuffle(gameDeck);
    }

    public List<Card> getGameDeck() {
        return gameDeck;
    }

    public int getAmountOfDecks() {
        return amountOfDecks;
    }

    public boolean areJokersAvailable() {
        return Jokers;
    }

    public void deckMaker(int numberOfDecks, boolean addJokers){
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
        if (addJokers){
            int amountOfJokers;
            int totalJokers = 2 * amountOfDecks;
            for (amountOfJokers = 0; amountOfJokers < totalJokers; amountOfJokers++) {
                gameDeck.add(new Card(14, Card.Suit.Joker));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(gameDeck);
    }

    public Card dealCard(){
        if (gameDeck.size() == 0) {
            refillGameDeck();
        }
        Card returnValue = gameDeck.get(0);
        gameDeck.remove(0);
        return returnValue;
    }

    public String toString() {
        return gameDeck.toString();
    }

    public void refillGameDeck(){
        deckMaker(amountOfDecks, Jokers);
    }
}
