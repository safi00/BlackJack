package nl.hu.bep2.casino.BlackJack.Deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck1f;
    private Deck deck1t;
    private Deck deck2;
    private Deck deck3;

    @BeforeEach
    public void init(){
        deck1f = new Deck(1,false);
        deck1t = new Deck(1,true);
        deck2 = new Deck(2,false);
        deck3 = new Deck(3,false);
    }

    @Test
    public void TestDeck1fvsDeck1t(){
        for (int i = 0; i < deck1t.getGameDeck().size(); i++) {
            if (i>51)
                System.out.print("null" + " ");
            else
                System.out.print(deck1f.getGameDeck().get(i) + " ");

            System.out.println(deck1t.getGameDeck().get(i));

        }
        assertNotSame(deck1f, deck1t);
    }

    @Test
    public void TestDealing2DifferentCards(){
        Card testcard = deck1f.dealCards(deck1f.getGameDeck());
        Card testcard1 = deck1f.dealCards(deck1f.getGameDeck());
        assertNotSame(testcard, testcard1);
    }

}