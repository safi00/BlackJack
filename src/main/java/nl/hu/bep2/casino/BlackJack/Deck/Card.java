package nl.hu.bep2.casino.BlackJack.Deck;

public class Card {
    private int    number;
    private String suit;

    public Card (int num, String shape){
        number = num;
        suit   = shape;
    }

    public int getNumber() {
        return number;
    }
    public String getSuit() {
        return suit;
    }

    public String toString() {
        String returnValue;
        if (number == 1){
            returnValue = "Ace of ";
        } else {
            returnValue = number + " of ";

            if (number == 11){
                returnValue = "Jack of ";
            }
            if (number == 12){
                returnValue = "Queen of ";
            }
            if (number == 13){
                returnValue = "King of ";
            }
        }
        return returnValue + suit;
    }
}
