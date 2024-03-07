package ca.sheridancollege.project;

public class WarGame extends Game {

    public WarGame(String name) {
        super(name);
    }

    @Override
   public void play() {
    while (getPlayers().get(0).getHand().size() < 52 && getPlayers().get(1).getHand().size() < 52) {
        Card card1 = drawCard();
        Card card2 = drawCard();

        // Check if either card is null, indicating that there are no more cards to draw
        if (card1 == null || card2 == null) {
            System.out.println("No more cards to draw. Game over.");
            break;
        }

        System.out.println("Player 1 plays: " + card1);
        System.out.println("Player 2 plays: " + card2);

        if (card1.getValue() > card2.getValue()) {
            getPlayers().get(0).drawCard(card1);
            getPlayers().get(0).drawCard(card2);
            System.out.println("Player 1 wins the round!");
        } else if (card1.getValue() < card2.getValue()) {
            getPlayers().get(1).drawCard(card1);
            getPlayers().get(1).drawCard(card2);
            System.out.println("Player 2 wins the round!");
        } else {
            System.out.println("It's a tie! War!");

            // Additional logic for handling a tie and war goes here
        }

        System.out.println("Player 1 has " + getPlayers().get(0).getHand().size() + " cards.");
        System.out.println("Player 2 has " + getPlayers().get(1).getHand().size() + " cards.");
        System.out.println("--------------");
    }
}


    @Override
    public void declareWinner() {
        if (getPlayers().get(0).getHand().size() == 52) {
            System.out.println("Player 1 is the winner!");
        } else {
            System.out.println("Player 2 is the winner!");
        }
    }
}

