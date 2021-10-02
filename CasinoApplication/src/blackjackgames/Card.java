package blackjackgames;

public class Card {

    //Attributes
        //Kardinale relatie card met value en suit, dus als instance gebruiken
    private CardSuit suit;
    private CardValue value;

    //Constructor
        //je wilt een card een suit en value geven dus mee als parameter en instantieren
    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    //Methods
        //

    public String toString() {
        return suit.getName() + " " + this.value.getName();
    }

    public String render() {
        return String.format("| %s %s |", suit.getSymbol(), value.getName());
    }

    public int getValue() {
        return value.getValue();
    }
}
