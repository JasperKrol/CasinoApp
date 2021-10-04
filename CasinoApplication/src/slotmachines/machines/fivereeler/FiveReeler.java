package slotmachines.machines.fivereeler;

import slotmachines.Symbol;
import slotmachines.machines.SlotMachine;

public class FiveReeler extends SlotMachine {

    // constructor is zelfde als die van slotmachines
    public FiveReeler() {
        super("Five reeler machine", 5);
    }

    //Methoden
    // haalt de methode uit de super klasse en geef er een invulling aan vandaar de @override
    // prijs om te spelen is 5
    @Override
    public int getRollPrice() {
        return 5;
    }

    @Override
    // haalt de methode uit de super klasse en geef er een invulling aan vandaar de @override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 50;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 100;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 150;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 200;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 250;
        }

        return 0;
    }

    @Override
    // haalt de methode uit de super klasse en geef er een invulling aan vandaar de @override

    protected String renderWinningConditions() {
        return "3x star    | 50 tokens\n" + "3x yinyang | 100 tokens\n" + "3x spade   | 150 tokens\n"
                + "3x heart   | 200 tokens\n" + "3x club    | 250 tokens\n";
    }
}
