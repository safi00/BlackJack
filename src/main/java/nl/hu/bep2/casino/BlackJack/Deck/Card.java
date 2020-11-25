package nl.hu.bep2.casino.BlackJack.Deck;

public class Card {
    private final int    value;
    private final Suit   suit;

    public enum Suit {
        Clubs,
        Diamonds,
        Hearts,
        Spades,
        Joker
    }

    public Card (int num, Suit shape){
        value  = num;
        suit   = shape;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String returnValue;
        if (suit == Suit.Joker)
            returnValue = "" + suit;
        else
            if (value == 1){
                returnValue = "Ace of " + suit;
            } else {
                returnValue = value + " of " + suit;

                if (value == 11){
                    returnValue = "Jack of " + suit;
                }
                if (value == 12){
                    returnValue = "Queen of " + suit;
                }
                if (value == 13){
                    returnValue = "King of " + suit;
                }
            }
        return returnValue;
    }
}
