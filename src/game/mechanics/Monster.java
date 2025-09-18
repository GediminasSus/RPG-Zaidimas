package game.mechanics;

import java.util.List;

public class Monster {
    private final String name;
    private int currentHP;
    private final int maxHP;
    private final int armorClass;
    private final int diceSize;
    private final int numDice;
    private final int bonusDamage;
    private final int hitBonus;
    private final int xpReward;
    
    private final int goldDrop;
    private final int packSize;
    private final int numberOfAttacks;
    private final boolean isPack;
    private final int maxPackSize;

    public Monster(String name, int maxHP, int armorClass,
                   int diceSize, int numDice, int bonusDamage,
                   int hitBonus, int xpReward, int goldDrop, boolean isPack, int maxPackSize) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.armorClass = armorClass;
        this.diceSize = diceSize;
        this.numDice = numDice;
        this.bonusDamage = bonusDamage;
        this.hitBonus = hitBonus;
        this.xpReward = xpReward;
        this.isPack = isPack;
        this.maxPackSize = maxPackSize;
        this.goldDrop = goldDrop;      
        this.packSize = isPack ? (int)(Math.random() * maxPackSize) + 1 : 1;
        this.numberOfAttacks = packSize; 
    }

    public int getDiceSize() { return diceSize; }
    public int getNumDice() { return numDice; }
    public int getBonusDamage() {return bonusDamage; }
    public String getName() { return name; }
    public int getHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getArmorClass() { return armorClass; }
    public int getXPReward() { return xpReward * packSize; }
    public int getGoldDrop() { return goldDrop * packSize; }
    public boolean isAlive() { return currentHP > 0; }
    public int getHitBonus() { return hitBonus; }
    public int getPackSize() { return packSize; }
    public boolean isDead() { return currentHP <= 0; }

    public void takeDamage(int amount) {
        currentHP = Math.max(0, currentHP - amount);
    }
     // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public List<Integer> rollAllAttacks() {
        List<Integer> results = new java.util.ArrayList<>();
        for (int j = 0; j < numberOfAttacks; j++) {
            int total = bonusDamage;
            for (int i = 0; i < numDice; i++) {
                total += (int)(Math.random() * diceSize) + 1;
            }
            results.add(total);
        }
        return results;
    }

    public void resetHP() { currentHP = maxHP; }

    @Override
    public String toString() {
    String packInfo = (packSize > 1) ? " x" + packSize : "";
    return name + packInfo + " [HP: " + currentHP + "/" + maxHP + ", AC: " + armorClass + "]";
    }

}
