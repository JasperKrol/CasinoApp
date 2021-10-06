package novi.blackjackgames;

import java.util.Scanner;

public class SimpleBlackJack extends BlackJackGame {
    //extenden van de blackjack game en we nemen de constructor over, dus alles wat in de super staat,
    // moet in de constructor van blackjack staan om te accepteren
    public SimpleBlackJack (Scanner inputScanner) {
        super(inputScanner, new SimpleDeck());
    }

    //abstract methode uit blackjack game gebruiken en ombouwen
    public void runGameLoop() {
        renderTableState();

        if (player.isBust() || player.isStaying() && player.getHandValue() <= dealer.getHandValue()) {
            System.out.println("You lost!");
            gameIsRunning = false;
            return;
        }

        if (dealer.isBust() || dealer.isStaying() && player.getHandValue() > dealer.getHandValue()) {
            System.out.println("You won!");
            gameIsRunning = false;
            return;
        }

        if (!player.isStaying()) {
            String move = getNextUserMove();
            player.performMove(deck, move);
        }

        if (!dealer.isStaying() && !player.isBust()) {
            dealer.performMove(deck);
        }
    }

    private String getNextUserMove() {
        while (true) {
            System.out.println("What do you want to do? (hit or stay)");
            String input = inputScanner.nextLine();

            if (input.equals("hit") || input.equals("stay")) {
                return input;
            }
        }
    }

    private void renderTableState() {
        System.out.println("");
        System.out.println("Dealers hand:");
        System.out.println(dealer.renderHand());
        System.out.println("");

        System.out.println("your hand:");
        System.out.println(player.renderHand());
        System.out.println("");
    }

    @Override
    public String getName() {
        return "BlackJack";
    }
}
