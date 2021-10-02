package blackjackgames;

public class Dealer {

    //Attributes
        // Dealer heeft een hand en kan niet zonder composite relatie
    public Hand hand;
    private boolean staying;

    //Constructor
        //composite relatie dus klasse verantwoordelijk maken voor het bouwen van object
    public Dealer(){
        this.hand = new Hand();
    }

    //Methods
    public void performMove(Deck deck) {
        if (hand.getTotalValue() < 17) {
            hand.addCard(deck.getNextCard());
            System.out.println("The dealer hits!\n");
        } else {
            System.out.println("The dealer stays!\n");
            this.staying = true;
        }
    }

    public void addCardsToHand(Card... cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public String renderHand() {
        return hand.render();
    }

    public boolean isBust() {
        return hand.getTotalValue() > 21;
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }

    public boolean isStaying() {
        return staying;
    }
}
