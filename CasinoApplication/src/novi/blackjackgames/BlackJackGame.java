package novi.blackjackgames;

import novi.Game;

import java.util.Scanner;

//BlackjackGame wordt de superklasse, simpleblackjack en lowdeck nemen de methoden/instances over
public abstract class BlackJackGame implements Game {
    protected Scanner inputScanner;

    protected boolean gameIsRunning;
    protected boolean gameIsWon;

    protected Deck deck;
    protected Player player;
    protected Dealer dealer;

    //wat hebben we nodig, scanner voor input en een deck van het type deck om te spelen
    public BlackJackGame(Scanner inputScanner, Deck deck) {
        this.inputScanner = inputScanner;
        this.deck = deck;
    }

    @Override
    public void playGame(int coins) {
        gameIsRunning = true;

        player = new Player();
        dealer = new Dealer();

        deck.shuffle();
        dealer.addCardsToHand(deck.getNextCard());
        player.addCardsToHand(deck.getNextCard(), deck.getNextCard());

        renderRules();

        while (gameIsRunning) {
            runGameLoop();
        }
    }

    public void renderRules() {
        System.out.println("Welcome to Blackjack!\n\n");
        System.out.println("  RULES: ");
        System.out.println("	- Each game costs 10 tokens, when you win you get 50");
        System.out.println(
                "	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
        System.out.println("	-Cards are equal to their value with face cards being 10.");
        System.out.println("	-The players cards are added up for their total.");
        System.out.println(
                "	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
        System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
        System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
        System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends.");
        System.out.println("	-Players win if they beat the dealer\n\n");
    }
    //komt uit de interface
    @Override
    public int getMinimalRequiredCoins() {
        return 10;
    }

    //komt uit de interface
    @Override
    public int getWinnings() {
        return gameIsWon ? 50 : -10;
    }

       // we maken een abstracte rungameloop omdat de types zelf de invulling kunnen geven.
    abstract void runGameLoop();
}
