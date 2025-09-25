package game.mechanics;

import java.util.Random;

public class Dice {
    private Dice() {}
    private static final Random rand = new Random();

    // Core roller
    private static int roll(int sides) {
        return rand.nextInt(sides) + 1;
    }

    // Specific rolls for clarity
    public static int initiativeRoll() {
        return roll(20);
    }

    public static int attackRoll(int hitBonus) {
        return roll(20) + hitBonus;
    }

    public static int damageRoll(int diceSize, int bonus) {
        return roll(diceSize) + bonus;
    }

    public static int potionRoll(int diceSize, int bonus) {
        return roll(diceSize) + bonus;
    }

    public static int spellRoll(int diceSize, int bonus) {
        return roll(diceSize) + bonus;
    }
}
