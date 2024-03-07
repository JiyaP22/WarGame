package ca.sheridancollege.project;

import java.util.ArrayList;

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
    private Deck deck;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
        deck = new Deck();
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

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void initializeDeck() {
        deck.initializeDeck();
        deck.shuffle();
    }

    public Card drawCard() {
        return deck.removeTopCard();
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
    public static class Deck extends GroupOfCards {

        public Deck() {
            super(52);
        }

        public void initializeDeck() {
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
            for (String suit : suits) {
                for (int value = 2; value <= 14; value++) {
                    addCard(new Card(suit, value) {});
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a new game instance
        WarGame warGame = new WarGame("War Card Game");

        // Add players to the game
        Player player1 = new WarPlayer("Player 1");
        Player player2 = new WarPlayer("Player 2");
        warGame.addPlayer(player1);
        warGame.addPlayer(player2);

        // Initialize the deck
        warGame.initializeDeck();

        // Play the game
        warGame.play();

        // Declare the winner
        warGame.declareWinner();
    }
}
