package game.lists;

import game.mechanics.Monster;

public class MonsterList {

    public static Monster goblin() {
        return new Monster(
            "Goblin",
            10,     // HP
            12,     // AC
            4,      // Dice
            1,      // Number of dice
            0,      // bonus
            2,      // hit bonus
            10 // gold dropped

        );
    }

    public static Monster packGoblin() {
        return new Monster(
            "Pack of goblins",
            10,     // HP
            12,     // AC
            4,      // Dice
            1,      // Number of dice
            0,      // bonus
            2,      // hit bonus
            50 // gold dropped

        );
    }

    public static Monster orc() {
        return new Monster(
            "Orc",
            18,
            13,
            6, 
            1, 
            2, 
            4,
            20

        );
    }

    public static Monster skeleton() {
        return new Monster(
            "Skeleton",
            12,
            11,
            6, 
            1, 
            1,
            3,
            10

        );
    }

    public static Monster packOfSkeleton() {
        return new Monster(
            "Pack of skeletons",
            12,
            11,
            6, 
            1, 
            1,
            3,
            10

        );
    }

    public static Monster slime() {
        return new Monster(
            "Slime",
            14,
            10,
            4, 
            2, 
            0, 
            1,
            50

        );
    }

    public static Monster orcChief() {
        return new Monster(
            "Orc chief",
            60,
            14,
            8, 
            1, 
            2, 
            4,
            100

        );
    }
}
