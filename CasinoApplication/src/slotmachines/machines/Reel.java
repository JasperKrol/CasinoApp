package slotmachines.machines;

import slotmachines.Symbol;

import java.util.Random;

public class Reel {

    //Attributes
    private Symbol currentValue;
    private Symbol[] possibleValues;

    //Constructor
    public Reel() {
        //.values iterates over de symbolen[]
        this.possibleValues = Symbol.values();
    }

    //Methods
    public void roll() {
        Random random = new Random();
        int index = random.nextInt(possibleValues.length);
        this.currentValue = possibleValues[index];
    }

    public String render() {
        return String.format("[ %s ]", currentValue.icon);
    }

    public Symbol getSymbol(){
        return this.currentValue;
    }

}
