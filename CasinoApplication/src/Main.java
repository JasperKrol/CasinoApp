import blackjackgames.BlackJackGame;
import blackjackgames.LowDeckBlackJack;
import hangman.HangmanGame;
import slotmachines.SlotMachinesGame;
import slotmachines.machines.SlotMachine;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
//        HigherLowerGame game = new HigherLowerGame(inputScanner);
//        BlackJackGame game = new LowDeckBlackJack(inputScanner);
//        SlotMachinesGame game = new SlotMachinesGame(inputScanner);
        HangmanGame game = new HangmanGame(inputScanner);

        game.playGame();


    }
}
