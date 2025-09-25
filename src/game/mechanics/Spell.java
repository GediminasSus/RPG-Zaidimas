package game.mechanics;

import game.enums.SpellType;

public class Spell {
    private final String name;
    private final int diceSize;
    private final int hitBonus;
    private final int manaCost;
    private final SpellType type; // ✅ enum instead of boolean

    public Spell(String name, int manaCost, int diceSize, int hitBonus, SpellType type) {
        this.name = name;
        this.manaCost = manaCost;
        this.diceSize = diceSize;
        this.hitBonus = hitBonus;
        this.type = type;
    }

    public String getName() { return name; }
    public int getDiceSize() { return diceSize; }
    public int getHitBonus() { return hitBonus; }
    public int getManaCost() { return manaCost; }
    public SpellType getType() { return type; }

    public boolean isHeal() { return type == SpellType.HEAL; }
    public boolean isDamage() { return type == SpellType.DAMAGE; }
}
