import blackjackgames.BlackJackGame;
import blackjackgames.LowDeckBlackJack;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
//        HigherLowerGame game = new HigherLowerGame(inputScanner);
        BlackJackGame game = new LowDeckBlackJack(inputScanner);

        game.playGame();


    }
}
