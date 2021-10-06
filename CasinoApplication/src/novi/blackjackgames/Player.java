package novi.blackjackgames;

public class Player {
    //Attributes
    // Player heeft een hand en kan niet zonder composite relatie
    public Hand hand;
    private boolean staying;

    //Constructor
    //composite relatie dus klasse verantwoordelijk maken voor het bouwen van object
    public Player(){
        this.hand = new Hand();
    }

    //Methods
    public void performMove(Deck deck, String move) {
        if (move.equals("hit")) {
            this.hand.addCard(deck.getNextCard());
            System.out.println("You hit!\n");
        } else if (move.equals("stay")) {
            this.staying = true;
            System.out.println("You stay!\n");
        }
    }

    public void addCardsToHand(Card... cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public boolean isStaying() {
        return staying;
    }

    public boolean isBust() {
        return hand.getTotalValue() > 21;
    }

    public String renderHand() {
        return hand.render();
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }
}
