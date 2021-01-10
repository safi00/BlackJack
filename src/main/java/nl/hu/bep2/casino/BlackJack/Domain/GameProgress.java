package nl.hu.bep2.casino.BlackJack.Domain;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Card;

import java.util.List;

public class GameProgress {
    private final GameState status;
    private final Long bet;
    private final List<Card> playerHand;
    private final List<Card> dealerHand;

    public GameProgress(GameState status, Long bet, List<Card> playerHand, List<Card> dealerHand) {
        this.status = status;
        this.bet = bet;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }

    public GameState getStatus() {
        return status;
    }

    public Long getBet() {
        return bet;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }
}