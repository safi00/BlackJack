package nl.hu.bep2.casino.BlackJack.Deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck1;
    private Deck deck2;
    private Deck deck3;

    @BeforeEach
    public void init(){
        deck1 = new Deck(1);
        deck2 = new Deck(2);
        deck3 = new Deck(3);
    }

//    @Test
//    public void Test1Deck(){
//        assertEquals(deck1,"");
//    }
//
//    @Test
//    public void Test2Deck(){
//        assertEquals(deck2,"");
//    }
//
//    @Test
//    public void Test3Deck(){
//        Collections.shuffle(deck3.getGameDeck());
//        assertFalse(deck3,);
//    }
//    @Test
//    public void TestDealingCards(){
//
//        assertEquals(deck1.dealCards(deck1.getGameDeck()),"");
//    }

}