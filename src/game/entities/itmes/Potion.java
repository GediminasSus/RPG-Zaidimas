package game.entities.itmes;

import game.enums.ItemType;

public class Potion extends Item {
    private final int diceSize; 
    private final int bonus; 
    private final boolean restoreHealth; 
    private final boolean restoreMana;  

    public Potion(String name, String description, int goldValue, int diceSize, int bonus, boolean restoreHealth, boolean restoreMana) {
        super(name, description, goldValue); // ✅ goldValue added
        this.diceSize = diceSize;
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

    public int getDiceSize() { 
        return diceSize;
    }

    public int getBonus() { // ✅ renamed from getbBonus
        return bonus;
    }

    @Override
    public ItemType getType() {
        return ItemType.POTION; // ✅ enum instead of string
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - Restores " +
               (restoreHealth ? "Health " : "") +
               (restoreMana ? "Mana " : "") +
               "[1D" + diceSize + " + " + bonus + "], " +
               getGoldValue() + "g";
    }
}
