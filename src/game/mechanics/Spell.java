package game.mechanics;

import java.util.Set;

public class Spell {
    private final String name;
    private final String description;
    private final int numDice;
    private final int diceSize;
    private final int bonus;
    private final int manaCost;
    private final boolean heal;
    private final boolean boundToWeapon;
    private final String scalingStat;
    private final Set<String> allowedClass;
    private final int spellLevel;

    public Spell(String name, String description, int manaCost, int diceSize, int numDice, int bonus,
                 boolean heal, boolean boundToWeapon, String scalingStat, Set<String> allowedClass, int spellLevel) {
        
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.diceSize = diceSize;
        this.numDice = numDice;
        this.bonus = bonus;
        this.heal = heal;
        this.boundToWeapon = boundToWeapon;
        this.scalingStat = scalingStat.toUpperCase();
        this.allowedClass = allowedClass;
        this.spellLevel = spellLevel;


    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getNumDice() { return numDice; }
    public int getDiceSize() { return diceSize; }
    public int getBonus() { return bonus; }
    public int getManaCost() { return manaCost; }
    public boolean isHeal() { return heal; }
    public boolean isBoundToWeapon() { return boundToWeapon; }
    public String getScalingStat() { return scalingStat; }
    public Set<String> getAllowedClass() { return allowedClass; }
    public int getSpellLevel() { return spellLevel;}
}
