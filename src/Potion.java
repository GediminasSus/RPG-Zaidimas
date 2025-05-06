import java.util.Random;

public class Potion extends Item {
    private final int dice; 
    private final int numberOfDice; 
    private final int bonus; 
    private final boolean restoreHealth; 
    private final boolean restoreMana; 


    public Potion(String name, String description, int dice, int numberOfDice, int bonus, boolean restoreHealth, boolean restoreMana) {
        super(name, description);
        this.dice = dice;
        this.numberOfDice = numberOfDice;
        this.bonus = bonus;
        this.restoreHealth = restoreHealth;
        this.restoreMana = restoreMana;
    }
   
    public int getTotalRestore() {
        int total = bonus;
        for (int i = 0; i < numberOfDice; i++) {
            total += (int)(Math.random() * dice) + 1;
        }
        return total;
    }

    public boolean restoresHealth() {
        return restoreHealth;
    }

    public boolean restoresMana() {
        return restoreMana;
    }

    public int getHealAmount() {
    if (!restoreHealth) return 0;
    int total = 0;
    for (int i = 0; i < numberOfDice; i++) {
        total += new Random().nextInt(dice) + 1;
    }
    return total + bonus;
    }

    public int getManaAmount() {
    if (!restoreMana) return 0;
    int total = 0;
    for (int i = 0; i < numberOfDice; i++) {
        total += new Random().nextInt(dice) + 1;
    }
    return total + bonus;
}


    @Override
    public String getType() {
        return "Potion";
    }

    @Override
    public String toString() {
        return name + " (" + getType() + ") - Restores " +
               (restoreHealth ? "Health " : "") +
               (restoreMana ? "Mana " : "") +
               "[" + numberOfDice + "d" + dice + " + " + bonus + "]";
    }
}