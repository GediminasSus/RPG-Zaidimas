package game.mechanics;

import java.util.Set;

public class Spell extends Item {
    private final int manaCost;
    private final int damageDice;
    private final int numDice;
    private final int bonus;
    private final boolean isHeal;
    private final boolean isBoundToWeapon;
    private final Set<String> allowedClasses;
    private final String scalingStat; 
    private final int spellLevel;

    public Spell(String name, String description, int manaCost, int damageDice, int numDice, int bonus, boolean isHeal,
                 boolean isBoundToWeapon,String scalingStat, Set<String> allowedClasses, int spellLevel) {
        super(name, description);
        this.manaCost = manaCost;
        this.damageDice = damageDice;
        this.numDice = numDice;
        this.bonus = bonus;
        this.isHeal = isHeal;
        this.isBoundToWeapon = isBoundToWeapon;
        this.scalingStat = scalingStat.toUpperCase();
        this.allowedClasses = allowedClasses;
        this.spellLevel = spellLevel;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int rollDamage() {
        int total = bonus;
        for (int i = 0; i < numDice; i++) {
            total += (int)(Math.random() * damageDice) + 1;
        }
        return total;
    }

    public boolean isHeal() {
        return isHeal;
    }

    public boolean isBoundToWeapon() {
        return isBoundToWeapon;
    }

    public String getScalingStat() {
        return scalingStat;
    }

    public Set<String> getAllowedClasses() {
        return allowedClasses;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public boolean isAllowedFor(String className) {
        return allowedClasses.contains(className);
    }

    public int getEffectiveDamage(PlayerCharacter caster) {
        if (isHeal) return 0;
    
        int modifier = caster.getModifier(scalingStat);
        int total = bonus + modifier;
    
        for (int i = 0; i < numDice; i++) {
            total += (int)(Math.random() * damageDice) + 1;
        }
    
        return total;
    }

    public int getEffectiveHealing(PlayerCharacter caster) {
        if (!isHeal) return 0;
    
        int modifier = caster.getModifier(scalingStat);
        int total = bonus + modifier;
    
        for (int i = 0; i < numDice; i++) {
            total += (int)(Math.random() * damageDice) + 1;
        }
    
        return total;
    }

    @Override
    public String getType() {
        return "Spell";
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - Cost: " + manaCost + " MP, " +
               numDice + "d" + damageDice + " + " + bonus +
               ", scales with " + scalingStat;
    }
}
