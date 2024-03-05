/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Jiya 05 March 2023 
 */
public abstract class Card {
     private String suit; //clubs, spades, diamonds, hearts
     private int value;
    //default modifier for child classes
     
     public Card(String suit, int value)
     {
         this.suit = suit;
         this.value = value;
     }
     
     
     public String getSuit() {
        return suit;
    }

   
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

   
      
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public  String toString()
    {
        return value + "of" + suit;
    }

}
