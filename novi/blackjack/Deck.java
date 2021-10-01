package novi.blackjack;

import java.util.Random;
import java.util.Stack;

public class Deck {
    //Attributes
    //Kardinale relatie met Card dus als instance, in het deck zitten kaarten - dus stack
    protected Stack<Card> cards;

    //Constructor
    // je weet welke kaarten in de stack komen dus instantieert het in de constructor
    public Deck() {

        // instantieer een cardsuit object met instances name, symbol en color
        CardSuit[] suits = new CardSuit[]{
                new CardSuit("diamonds", '\u2666', "red"),
                new CardSuit("spades", '\u2660', "black"),
                new CardSuit("hearts", '\u2665', "red"),
                new CardSuit("clubs", '\u2663', "black")
        };

        // instantieer een cardvalue object met instances name en value
        CardValue[] values = new CardValue[]{
                new CardValue("two", 2), new CardValue("three", 3),
                new CardValue("four", 4), new CardValue("five", 5),
                new CardValue("six", 6), new CardValue("seven", 7),
                new CardValue("eight", 8), new CardValue("nine", 9),
                new CardValue("ten", 10), new CardValue("jack", 10),
                new CardValue("queen", 10), new CardValue("king", 10)};

        //Instantieer de stack Cards en de kaarten uit de arrays values en suits en
        // instantieer ze als Card met suite en value
        cards = new Stack<>();
        for (CardSuit suite : suits){
            for (CardValue value : values){
                cards.add(new Card(suite, value));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int j = 0; j < cards.size(); j++) {
            int shuffleIndex = random.nextInt(cards.size());
            Card hold = cards.get(j);
            cards.set(j, cards.get(shuffleIndex));
            cards.set(shuffleIndex, hold);
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getNextCard() {
        return cards.pop();
    }
}
