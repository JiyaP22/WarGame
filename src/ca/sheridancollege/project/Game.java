package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 * 
 * 
 * @author Jiya 06 March 2024
 */
public abstract class Game {

    private final String name; // the title of the game
    private ArrayList<Player> players; // the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

    /**
     * Represents a deck of playing cards.
     */
    public static class Deck {
        private List<Card> cards;

        public Deck() {
            cards = new ArrayList<>();
            initializeDeck();
        }

        private void initializeDeck() {
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
            for (String suit : suits) {
                for (int value = 2; value <= 14; value++) {
                    cards.add(new Card(suit, value) {});
                }
            }
        }

        public void shuffle() {
            Collections.shuffle(cards);
        }

        public Card removeTopCard() {
            if (!cards.isEmpty()) {
                return cards.remove(0);
            } else {
                return null; // Return null if deck is empty
            }
        }

        public int size() {
            return cards.size();
        }
    }
}
