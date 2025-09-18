/*package game;

import java.util.Random;

public class Test {
    private static final Random rand = new Random();

    // Core roll method
    public static int troll(int numberOfDice, int diceSides, int bonus, boolean advantage, boolean disadvantage) {
        if (advantage && disadvantage) {
            // Cancel out if both are true
            advantage = false;
            disadvantage = false;
        }

        int firstRoll = singletRoll(numberOfDice, diceSides, bonus);

        if (advantage || disadvantage) {
            int secondRoll = singletRoll(numberOfDice, diceSides, bonus);
            return advantage ? Math.max(firstRoll, secondRoll) : Math.min(firstRoll, secondRoll);
        }

        return firstRoll;
    }

    // Convenience overloads
    public static int troll(int numberOfDice, int diceSides) {
        return troll(numberOfDice, diceSides, 0, false, false);
    }

    public static int troll(int numberOfDice, int diceSides, int bonus) {
        return troll(numberOfDice, diceSides, bonus, false, false);
    }

    private static int singletRoll(int numberOfDice, int diceSides, int bonus) {
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            System.out.println("first total " + total);
            total += rand.nextInt(diceSides) + 1 + bonus;
            System.out.println(total);
        }
        //System.out.println(total);
        return total ;
    }

    // ───── Test Main Method ─────
    public static void main(String[] args) {
        //System.out.println("Rolling 1d20: " + troll(1, 20));
        System.out.println("Rolling 2d6 + 3: " + troll(2, 6, 3));
       // System.out.println("Rolling 1d20 with advantage: " + troll(1, 20, 0, true, false));
        //System.out.println("Rolling 1d20 with disadvantage: " + troll(1, 20, 0, false, true));
        //System.out.println("Rolling 3d4 + 2: " + troll(3, 4, 2));
    }
}*/