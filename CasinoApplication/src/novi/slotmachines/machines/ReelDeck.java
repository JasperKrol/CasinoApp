package novi.slotmachines.machines;

import novi.slotmachines.Symbol;

import java.util.List;

public class ReelDeck {
    //Attributes
    private List<Reel> reels;

    //Constructor
    public ReelDeck(List<Reel> reels) {
        //compist relatie dus in de constructor van ReelDeck instantieren
        this.reels = reels;
    }

    //Methodes
    public void roll() {
        for (Reel reel : reels) {
            reel.roll();
        }
    }

    public String render() {
        var renderedReels = "";

        for (Reel reel : reels) {
            renderedReels = renderedReels + " " + reel.render();
        }
        return renderedReels;
    }

    public boolean allReelsHaveSymbol(Symbol symbol) {
        for (Reel reel : reels) {
            if (reel.getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
