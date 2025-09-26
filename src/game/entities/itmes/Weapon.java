package game.entities.itmes;

import game.enums.ItemType;

public class Weapon extends Item {
    private final int diceSize;       // damage dice (e.g., d8)
    private final int hitBonus;       // hit chance bonus
    private final int allowedClasses; // class permissions

    public Weapon(String name, String description, int goldValue, int diceSize, int hitBonus, int allowedClasses) {
        super(name, description, goldValue); // ✅ goldValue added
        this.diceSize = diceSize;
        this.hitBonus = hitBonus;
        this.allowedClasses = allowedClasses;
    }

    public int getDiceSize() {
        return diceSize;
    }

    public int getHitBonus() {
        return hitBonus;
    }

    public int getAllowedClasses() {
        return allowedClasses;
    }

    @Override
    public ItemType getType() {
        return ItemType.WEAPON; // ✅ enum instead of string
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - d" + diceSize +
               ", +" + hitBonus + " hit, " +
               getGoldValue() + "g";
    }
}
