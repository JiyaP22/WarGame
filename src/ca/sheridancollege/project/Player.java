package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * 
 * @author Jiya 06 March 2024
 */
public abstract class Player {

    private String name; // the unique name for this player
    private final List<Card> hand; // the hand of cards for this player

    /**
     * A constructor that allows you to set the player's unique ID
     * 
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     * 
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Add a card to the player's hand.
     * 
     * @param card the card to add
     */
    public void drawCard(Card card) {
        hand.add(card);
    }

    /**
     * Get the player's hand of cards.
     * 
     * @return the player's hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();
}
