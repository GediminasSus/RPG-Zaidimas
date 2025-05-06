import java.util.Set;

public class Weapon extends Item {
    private final int damageDice;           // Damage dice from 1-12
    private final int hitBonus;             // bonus hit chance 0-10
    private final String scalingStat;       
    private int acBonus = 0;                
    private int numDice = 1;                // standart numeber of dice for damage. 1-2
    private int bonusDamage = 0;             // bonus damage to weapon. 0-6
    private final Set<String> allowedClasses; // class permissions
    
    public Weapon(String name, String description, int damageDice, int bonusDamage, int hitBonus,
                  String scalingStat, int acBonus, int numDice, Set<String> allowedClasses) {
        super(name, description);
        this.damageDice = damageDice;
        this.hitBonus = hitBonus;
        this.scalingStat = scalingStat.toUpperCase(); 
        this.allowedClasses = allowedClasses;
        this.acBonus = acBonus;
        this.bonusDamage = bonusDamage;
        this.numDice = numDice;
    }

    public int rollDamage() {
        int total = 0;
        for (int i = 0; i < numDice; i++) {
        total += (int)(Math.random() * damageDice) + 1 + bonusDamage;
        }
    return total;
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
        return name + " (" + getType() + ") - " + numDice + "d" + damageDice +
               ", +" + hitBonus + " hit, scales with " + scalingStat;
    }
}
