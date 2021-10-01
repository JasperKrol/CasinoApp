package novi.blackjack;

public class LowDeck extends Deck {

    public LowDeck() {
        //met super extend je dus alles uit de super klasse
        // geven alleen waardes mee in de super die de Deck klasse accepteert
        // daarna instantieren we het simple deck met de suite en value
        super(new CardSuit[] { new CardSuit("diamonds", '\u2666', "red"), new CardSuit("spades", '\u2660', "black"),
                        new CardSuit("hearts", '\u2665', "red"), new CardSuit("clubs", '\u2663', "black") },
                new CardValue[] { new CardValue("two", 2), new CardValue("three", 3), new CardValue("four", 4),
                        new CardValue("five", 5), new CardValue("six", 6) },
                3);
    }
}
