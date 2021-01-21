package nl.hu.bep2.casino.BlackJack.Domain;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Card;
import nl.hu.bep2.casino.BlackJack.Domain.Deck.Deck;
import nl.hu.bep2.casino.BlackJack.Domain.participant.Dealer;
import nl.hu.bep2.casino.BlackJack.Domain.participant.Player;
import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {
    private Long bet;
    private final String user;
    private final Player player;
    private final Dealer dealer;
    private final Deck deck;
    private final Rules rules;
    private GameState status = GameState.START;

    public Game(Long bet, String user, Player player, Rules rules) {
        this.bet = bet;
        this.user = user;
        this.player = player;
        this.dealer = new Dealer();
        this.deck = rules.getBJdeck();
        this.rules = rules;
    }

    public GameProgress start() {
        status = GameState.PLAYING;
        deck.shuffle();
        player.addCard(deck.dealCard(), rules.tenPlus, rules.wincondition);
        player.addCard(deck.dealCard(), rules.tenPlus, rules.wincondition);
        dealer.addCard(deck.dealCard(), rules.tenPlus, rules.wincondition);
        dealer.addCard(deck.dealCard(), rules.tenPlus, rules.wincondition);

        List<Card> dealerHand = dealer.showDealercards(rules);

        gameCheck();

        bet = calculateBet();
        return new GameProgress(status, bet, player.getPlayerHand(), dealerHand);
    }

    public GameProgress hit(){
        player.addCard(deck.dealCard(), rules.tenPlus, rules.wincondition);

        List<Card> dealerHand = dealer.showDealercards(rules);

        gameCheck();
        bet = calculateBet();
        return new GameProgress(status, bet, player.getPlayerHand(), dealerHand);
    }

    public GameProgress stand(){
        gameCheck();
        if (dealer.getHandValue() < (rules.getWincondition() - 4) ){
            while (dealer.getHandValue() < (rules.getWincondition() - 4)){
                dealer.addCard(deck.dealCard(), rules.tenPlus, rules.wincondition);
            }
        }
        bet = calculateBet();
        return new GameProgress(status, bet, player.getPlayerHand(), dealer.getDealerHand());
    }
    //strategy
    private Long calculateBet() {
        switch (status) {
            case WON:
                return bet * 2;
            case BUST:
            case LOST:
                return 0L;
            case BLACKJACK:
                return bet * 4;
        }
        return bet;
    }

    public void gameCheck(){
        if        (player.getHandValue() == dealer.getHandValue()) {
            status = GameState.PUSH;
        } else if (player.getHandValue() == rules.getWincondition()) {
            status = GameState.BLACKJACK;
        } else if (player.getHandValue() >  rules.getWincondition()) {
            status = GameState.BUST;
        } else if (player.getHandValue() <  dealer.getHandValue()) {
            status = GameState.LOST;
        }
    }
}