package nl.hu.bep2.casino.BlackJack.Domain;

import nl.hu.bep2.casino.BlackJack.Domain.Deck.Card;
import nl.hu.bep2.casino.BlackJack.Domain.Deck.Deck;
import nl.hu.bep2.casino.BlackJack.Domain.participant.Dealer;
import nl.hu.bep2.casino.BlackJack.Domain.participant.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class DomainTest {
    private Rules rulesA;
    private Deck deckA;
    private Deck deckY;
    private Deck deckZ;
    private Player player1;
    private Player player2;
    private Dealer dealer;

    @BeforeEach
    public void init(){
        rulesA = new Rules(1,false, false, 50);
        deckA  = rulesA.getBJdeck();
        deckZ  = new Deck(1,false);
        deckY  = new Deck(1,true);
        player1 = new Player("puppet","pup");
        player2 = new Player("dummy", "dummy");
        dealer = new Dealer();
    }

    @Test
    public void testDeckZvsDeckY(){
        for (int i = 0; i < deckY.getGameDeck().size(); i++) {
            if (i>51)
                System.out.print("null" + " ");
            else
                System.out.print(deckZ.getGameDeck().get(i) + " ");

            System.out.println(deckY.getGameDeck().get(i));

        }
        assertNotSame(deckZ, deckY);
    }

    @Test
    public void TestDealing2DifferentCards(){
        Card testcard = deckZ.dealCard();
        Card testcard1 = deckZ.dealCard();
        assertNotSame(testcard, testcard1);
    }

    @Test
    public void TestDealing2DifferentCardsWithParticipants(){
        player1.addCard(deckA.dealCard(), rulesA.tenPlus, rulesA.wincondition);
        player1.addCard(deckA.dealCard(), rulesA.tenPlus, rulesA.wincondition);
        dealer.addCard(deckA.dealCard(), rulesA.tenPlus, rulesA.wincondition);
        dealer.addCard(deckA.dealCard(), rulesA.tenPlus, rulesA.wincondition);

        System.out.println(deckA);
        System.out.println(deckA.getGameDeck().size());
        System.out.println(player1.getCurrentHandValue());
        System.out.println(dealer.getCurrentHandValue());

        System.out.println(player1.getPlayerHand());
        System.out.println(dealer.getPlayerHand());

        assertNotSame(player1.getPlayerHand() , dealer.getPlayerHand() );
    }
    @Test
    public void TestHandValue(){
        System.out.println(player1.getHandValue());
        player1.addCard(deckA.dealCard(), rulesA.tenPlus, rulesA.wincondition);
        System.out.println(player1.getHandValue());
        player1.addCard(deckA.dealCard(), rulesA.tenPlus, rulesA.wincondition);

        System.out.println(player1.getPlayerHand());
        System.out.println(player1.getHandValue());
        System.out.println("Deck size : " + deckA.getGameDeck().size());

        assertNotSame(player1.getPlayerHand() , player2.getPlayerHand() );
    }

    @Test
    public void TestHandValueWithAces(){
        Card ace = new Card(1, Card.Suit.Hearts);
        System.out.println(player1.getHandValue());
        player1.addCard(ace, rulesA.tenPlus, rulesA.wincondition);
        System.out.println(player1.getHandValue());
        player1.addCard(ace, rulesA.tenPlus, rulesA.wincondition);

        System.out.println(player1.getPlayerHand());
        System.out.println(player1.getHandValue());
        System.out.println("Deck size : " + deckA.getGameDeck().size() + " and Wincon : " + rulesA.getWincondition());

        assertNotSame(player1.getPlayerHand() , player2.getPlayerHand() );
    }

    @Test
    public void TestHandValueWithTens(){
        Card king  = new Card(13, Card.Suit.Diamonds);
        Card queen = new Card(12, Card.Suit.Clubs);

        System.out.println(player1.getHandValue());
        player1.addCard(king, rulesA.tenPlus, rulesA.wincondition);
        System.out.println(player1.getHandValue());
        player1.addCard(queen, rulesA.tenPlus, rulesA.wincondition);

        System.out.println(player1.getPlayerHand());
        System.out.println(player1.getHandValue());
        System.out.println("Deck size : " + deckA.getGameDeck().size() + " and Wincon : " + rulesA.getWincondition());

        assertNotSame(player1.getPlayerHand() , player2.getPlayerHand() );
    }

    @Test
    public void TestHandValueWithJokers(){
        Card joker  = new Card(14, Card.Suit.Joker);

        System.out.println(player1.getHandValue());
        player1.addCard(joker, rulesA.tenPlus, rulesA.wincondition);
        System.out.println(player1.getHandValue());
        player1.addCard(joker, rulesA.tenPlus, rulesA.wincondition);

        System.out.println(player1.getPlayerHand());
        System.out.println(player1.getHandValue());
        System.out.println("Deck size : " + deckA.getGameDeck().size() + " and Wincon : " + rulesA.getWincondition());

        assertNotSame(player1.getPlayerHand() , player2.getPlayerHand() );
    }

    @Test
    public void TestHandValueWithNoneStandardRules(){
        rulesA = new Rules(1, true,true,24);
        System.out.println("Deck size : " + rulesA.getBJdeck().getGameDeck().size() + " and Wincon : " + rulesA.getWincondition());
        System.out.println();

        System.out.println(player1.getHandValue());
        player1.addCard(rulesA.getBJdeck().dealCard(), rulesA.tenPlus, rulesA.wincondition);
        System.out.println(player1.getHandValue());
        player1.addCard(rulesA.getBJdeck().dealCard(), rulesA.tenPlus, rulesA.wincondition);

        System.out.println(player1.getPlayerHand());
        System.out.println(player1.getHandValue());
        System.out.println();
        System.out.println("Deck prop | size : " + rulesA.getBJdeck().getGameDeck().size() +
                ", deck amount : " + rulesA.getBJdeck().getAmountOfDecks() + ", are there jokers : " + rulesA.getBJdeck().areJokersAvailable());

        System.out.println("Player name & user : " + player1.getPlayername() + " " + player1.getPlayerUsername());

        assertNotSame(player1.getPlayerHand() , player2.getPlayerHand() );
    }

    @Test
    public void TestDealerHandValue(){
        System.out.println("Deck size : " + rulesA.getBJdeck().getGameDeck().size() + " and Wincon : " + rulesA.getWincondition());
        System.out.println();

        System.out.println(dealer.getHandValue());
        dealer.addCard(rulesA.getBJdeck().dealCard(), rulesA.tenPlus, rulesA.wincondition);
        System.out.println(dealer.getHandValue());
        System.out.println();
        dealer.addCard(rulesA.getBJdeck().dealCard(), rulesA.tenPlus, rulesA.wincondition);

        System.out.println(dealer.getPlayerHand());
        System.out.println(dealer.showDealercards(rulesA));
        System.out.println(dealer.getHandValue());
        System.out.println(dealer.getShowedValue());
        System.out.println();
        System.out.println("Deck prop | size : " + rulesA.getBJdeck().getGameDeck().size() +
                ", deck amount : " + rulesA.getBJdeck().getAmountOfDecks() + ", are there jokers : " + rulesA.getBJdeck().areJokersAvailable());

        System.out.println("Dealer name : " + dealer.getDealername());
        assertNotSame(dealer.getPlayerHand() , dealer.showDealercards(rulesA));
    }
}