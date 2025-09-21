package game.mechanics;

public class Monster {
    private final String name;
    private int currentHP;
    private final int maxHP;
    private final int armorClass;
    private final int diceSize;
    private final int numDice;
    private final int bonusDamage;
    private final int hitBonus;
    private final int goldDrop;

    
    

    public Monster(String name, int maxHP, int armorClass,
                   int diceSize, int numDice, int bonusDamage,
                   int hitBonus, int goldDrop) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.armorClass = armorClass;
        this.diceSize = diceSize;
        this.numDice = numDice;
        this.bonusDamage = bonusDamage;
        this.hitBonus = hitBonus;
        this.goldDrop = goldDrop;      
    }

    public int getDiceSize() { return diceSize; }
    public int getNumDice() { return numDice; }
    public int getBonusDamage() {return bonusDamage; }
    public String getName() { return name; }
    public int getHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getArmorClass() { return armorClass; }
    public boolean isAlive() { return currentHP > 0; }
    public int getHitBonus() { return hitBonus; }
    public boolean isDead() { return currentHP <= 0; }

    public void takeDamage(int amount) {
        currentHP = Math.max(0, currentHP - amount);
    }
    
}
