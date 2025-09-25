package game.mechanics;

import game.enums.ItemType;

public class Armor extends Item {
    private final int acBonus;
    private final int allowedClasses;

    public Armor(String name, String description, int goldValue, int acBonus, int allowedClasses) {
        super(name, description, goldValue); // ✅ pass goldValue to Item
        this.acBonus = acBonus;
        this.allowedClasses = allowedClasses;
    }

    public int getAcBonus() {
        return acBonus;
    }

    public int getAllowedClasses() {
        return allowedClasses;
    }

    @Override
    public ItemType getType() {
        return ItemType.ARMOR; // ✅ enum instead of string
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - +" + acBonus + " AC, " +
               getGoldValue() + "g";
    }
}
