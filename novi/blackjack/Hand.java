package novi.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    //Attributes
        //cardinale relatie met Card -> 0-meer want hand krijgt 1 of meer kaarten
    public List<Card> cards;

    //Constructor
    public Hand() {
        this.cards = new ArrayList<>();
    }

    //Methods
    public void addCard(Card card){
        this.cards.add(card);
    }

    public int getTotalValue() {
        int value = 0;

        for (Card card : cards) {
            value += card.getValue();
        }

        return value;
    }

    public String render() {
        String renderedHand = "";
        for (Card card : cards) {
            renderedHand = renderedHand + " " + card.render();
        }
        return renderedHand;
    }
}
