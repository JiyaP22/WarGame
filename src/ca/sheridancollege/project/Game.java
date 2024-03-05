
import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck deck;
    private Player player1;
    private Player player2;

    public Game(String player1Name, String player2Name) {
        deck = new Deck();
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void start() {
        deck.shuffle();
        dealCards();
        play();
    }

    private void dealCards() {
        while (deck.size() > 0) {
            player1.drawCard(deck.removeTopCard());
            player2.drawCard(deck.removeTopCard());
        }
    }

    private void play() {
        while (player1.hasCards() && player2.hasCards()) {
            Card card1 = player1.getHand().removeTopCard();
            Card card2 = player2.getHand().removeTopCard();

            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            if (card1.getValue() > card2.getValue()) {
                player1.getHand().addCard(card1);
                player1.getHand().addCard(card2);
                System.out.println(player1.getName() + " wins the round!");
            } else if (card1.getValue() < card2.getValue()) {
                player2.getHand().addCard(card1);
                player2.getHand().addCard(card2);
                System.out.println(player2.getName() + " wins the round!");
            } else {
                System.out.println("It's a tie! Both players play one more card.");
                List<Card> tieCards = new ArrayList<>();
                tieCards.add(card1);
                tieCards.add(card2);
                playTieBreaker(tieCards);
            }

            System.out.println(player1);
            System.out.println(player2);
            System.out.println("-----------------------");
        }

        if (!player1.hasCards()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println(player1.getName() + " wins the game!");
        }
    }

    private void playTieBreaker(List<Card> tieCards) {
        if (!player1.hasCards() || !player2.hasCards()) {
            return;
        }

        Card card1 = player1.getHand().removeTopCard();
        Card card2 = player2.getHand().removeTopCard();
        tieCards.add(card1);
        tieCards.add(card2);

        System.out.println(player1.getName() + " plays " + card1);
        System.out.println(player2.getName() + " plays " + card2);

        if (card1.getValue() > card2.getValue()) {
            player1.getHand().addAllCards(tieCards);
            System.out.println(player1.getName() + " wins the tiebreaker!");
        } else if (card1.getValue() < card2.getValue()) {
            player2.getHand().addAllCards(tieCards);
            System.out.println(player2.getName() + " wins the tiebreaker!");
        } else {
            System.out.println("Tiebreaker continues...");
            playTieBreaker(tieCards);
        }
    }

    public static void main(String[] args) {
        Game game = new Game("Player 1", "Player 2");
        game.start();
    }
}
