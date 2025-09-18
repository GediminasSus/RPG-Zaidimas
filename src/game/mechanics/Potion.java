package game.mechanics;

public class Potion extends Item {
    private final int diceSize; 
    private final int numDice; 
    private final int bonus; 
    private final boolean restoreHealth; 
    private final boolean restoreMana; 


    public Potion(String name, String description, int diceSize, int numDice, int bonus, boolean restoreHealth, boolean restoreMana) {
        super(name, description);
        this.diceSize = diceSize;
        this.numDice = numDice;
        this.bonus = bonus;
        this.restoreHealth = restoreHealth;
        this.restoreMana = restoreMana;
    }
   
    public boolean restoresHealth() {
        return restoreHealth;
    }

    public boolean restoresMana() {
        return restoreMana;
    }

    public int getNumDice() { 
        return numDice; }
    public int getDiceSize() { 
        return diceSize; }
    public int getbBonus() {
        return bonus; }
    

    @Override
    public String getType() {
        return "Potion";
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - Restores " +
               (restoreHealth ? "Health " : "") +
               (restoreMana ? "Mana " : "") +
               "[" + numDice + "d" + diceSize + " + " + bonus + "]";
    }
}