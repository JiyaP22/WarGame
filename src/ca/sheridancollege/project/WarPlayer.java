package ca.sheridancollege.project;

public class WarPlayer extends Player {

    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        // The play method for a WarPlayer can be further customized if needed
        // For the War card game, the specific game logic is implemented in WarGame
    }

    // Add any additional methods or attributes specific to WarPlayer
    // For example:
    
    // Additional attribute to track player's score
    private int score = 0;

    // Method to increase player's score
    public void increaseScore() {
        score++;
    }

    // Method to get the player's score
    public int getScore() {
        return score;
    }

    // You can add more methods as needed based on your game requirements
}
