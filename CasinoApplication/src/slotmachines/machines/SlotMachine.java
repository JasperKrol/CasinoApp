package slotmachines.machines;

import slotmachines.machines.fivereeler.FiveReeler;
import slotmachines.machines.highroller.HighRoller;
import slotmachines.machines.pennymachine.PennyMachine;

import java.util.ArrayList;

public abstract class SlotMachine {
    private String name;
    protected ReelDeck reelDeck;

    public SlotMachine(String name, int numberOfReels) {
        // je wilt de naam van het spel vastleggen en het aantal bijbehorende reels / schijven
        this.name = name;

        //reels meervoud van schijven in lijst stoppen arraylist van het type Reel
        var reels = new ArrayList<Reel>();

        //omdat je de indexen wilt benaderen simpele forloop
        // instantieer per rol een reel
        for (int i = 0; i < numberOfReels; i++) {
            reels.add(new Reel());
        }
        this.reelDeck = new ReelDeck(reels);
    }

    public void renderIntro() {
        System.out.println("$--$--$__| LET'S PLAY |__$--$--$");
        System.out.println(name);
        System.out.println("$--$--$__|____________|__$--$--$\n\n");

        System.out.println("WINNING CONDITIONS\n");
        System.out.println(renderWinningConditions());
    }

    public int roll() {
        // Draai aan de hendel en calculeer de payout van de draai
            // functie zit in klasse Reeldeck die je in de constructor geïnstantieerd hebt
        reelDeck.roll();
        return calculatePayout();
    }

    public String render() {
        return reelDeck.render();
    }

    //De spellen zullen de methoden ook erven en anders invullen String name en int reels

    public abstract int getRollPrice();

    protected abstract int calculatePayout();

    protected abstract String renderWinningConditions();
}
