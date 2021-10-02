package blackjackgames;

import java.util.Scanner;

//BlackjackGame wordt de superklasse, simpleblackjack en lowdeck nemen de methoden/instances over
public abstract class BlackJackGame {
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

    public void playGame() {
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

    // we maken een abstracte rungameloop omdat de types zelf de invulling kunnen geven.
    abstract void runGameLoop();
}
