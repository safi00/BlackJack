package nl.hu.bep2.casino.BlackJack.Domain.participant;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Card;

import java.util.List;

public class Player extends Participant{
    private final String username;
    private final String playername;

    public Player(String user, String name){
        super();
        username = user;
        playername = name;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public String getPlayerUsername() {
        return username;
    }

    public String getPlayername() {
        return playername;
    }

    public int getCurrentHandValue() {
        return currentHandValue;
    }
}
