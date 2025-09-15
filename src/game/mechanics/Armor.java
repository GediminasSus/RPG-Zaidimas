
package game.mechanics;
import java.util.Set;

public class Armor extends Item {
    private final int acBonus;
    private final int dexBonusCap; 
    private final Set<String> allowedClasses;

    public Armor(String name, String description, int acBonus, int dexBonusCap, Set<String> allowedClasses) {
        super(name, description);
        this.acBonus = acBonus;
        this.dexBonusCap = dexBonusCap;
        this.allowedClasses = allowedClasses;
    }

    public int getAcBonus() {
        return acBonus;
    }

    public int getDexBonusCap() {
        return dexBonusCap;
    }

    public Set<String> getAllowedClasses() {
        return allowedClasses;
    }

    @Override
    public String getType() {
        return "Armor";
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - +" + acBonus + " AC, DEX cap +" + dexBonusCap;
    }
}
