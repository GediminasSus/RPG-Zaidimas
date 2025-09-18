package game.mechanics;

import java.util.Random;

public class Dice {
    private Dice() {}
    private static final Random rand = new Random();

    public static int roll(int numberOfDice, int diceSides) {
        return roll(numberOfDice, diceSides, 0, false, false);
    }

    public static int roll(int numberOfDice, int diceSides, int bonus) {
        return roll(numberOfDice, diceSides, bonus, false, false);
    }

    public static int roll(int numberOfDice, int diceSides, int bonus, boolean advantage, boolean disadvantage) {
        if (advantage && disadvantage) {
            advantage = false;
            disadvantage = false;
        }

        int result = singleRoll(numberOfDice, diceSides, bonus);

        if (advantage || disadvantage) {
            int second = singleRoll(numberOfDice, diceSides, bonus);
            return advantage ? Math.max(result, second) : Math.min(result, second);
        }

        return result;
    }

    private static int singleRoll(int numberOfDice, int diceSides, int bonus) {
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            total += rand.nextInt(diceSides) + 1 + bonus;
        }
        return total;
    }
}
