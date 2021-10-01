package novi.blackjack;

import java.util.Scanner;

public class BlackJackGame {
    //Attributes
    private Scanner inputScanner;
    private boolean gameIsRunning;

    //relaties ook als instances
    private Deck deck;
    private Player player;
    private Dealer dealer;

    //Constructor
    public BlackJackGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.deck = new Deck();
    }

    //Methods
    public void playGame(){
        gameIsRunning = true;

        //create player en dealer object
        gameIsRunning = true;
        player = new Player();
        dealer = new Dealer();

        deck.shuffle();
        dealer.addCardsToHand(deck.getNextCard());
        player.addCardsToHand(deck.getNextCard(), deck.getNextCard());

        while (gameIsRunning) {
            runGameLoop();
        }
    }

    public void runGameLoop() {
        //laat de handen zien van dealer en de player
        renderTableState();

        //Voeg wincondities toe aan het spel
        if (dealer.isBust() || dealer.isStaying() && player.getHandValue() > dealer.getHandValue()) {
            System.out.println("You won!");
            gameIsRunning = false;
            return;
        }

        //Voeg verliest condities toe aan het spel
        if (player.isBust() || player.isStaying() && player.getHandValue() <= dealer.getHandValue()) {
            System.out.println("You lost!");
            gameIsRunning = false;
            return;
        }

        //Voeg methode toe die zorgt dat de speler kaart krijgt
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

}
