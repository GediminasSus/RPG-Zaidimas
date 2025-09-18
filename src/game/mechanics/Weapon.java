package game.mechanics;
import java.util.Set;

public class Weapon extends Item {
    private final int diceSize;           // Damage dice from 1-12
    private final int hitBonus;             // bonus hit chance 0-10
    private final String scalingStat;       
    private int acBonus = 0;                
    private int numDice = 1;                // standart numeber of dice for damage. 1-2
    private final Set<String> allowedClasses; // class permissions
    
    public Weapon(String name, String description, int diceSize, int hitBonus,
                  String scalingStat, int acBonus, int numDice, Set<String> allowedClasses) {
        super(name, description);
        this.diceSize = diceSize;
        this.hitBonus = hitBonus;
        this.scalingStat = scalingStat.toUpperCase(); 
        this.allowedClasses = allowedClasses;
        this.acBonus = acBonus;
        this.numDice = numDice;
    }

    
   

    public int getDiceSize() {
        return diceSize;
    }

    public int getNumDice() {
        return numDice;
    }

    public int getHitBonus() {
        return hitBonus;
    }

    public String getScalingStat() {
        return scalingStat;
    }

    public int getAcBonus() {
        return acBonus;
    }

    public Set<String> getAllowedClasses() {
        return allowedClasses;
    }

    @Override
    public String getType() {
        return "Weapon";
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - " + numDice + "d" + diceSize +
               ", +" + hitBonus + " hit, scales with " + scalingStat;
    }
}
