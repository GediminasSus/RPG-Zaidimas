
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
            25,     // XP
            10, // gold dropped
            false, // is a pack?
            0 // if pack what max size
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
            25,     // XP
            50, // gold dropped
            true, // is a pack?
            5 // if pack what max size
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
            50,
            20,
            false,
            0
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
            35,
            10,
            false,
            0
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
            35,
            10,
            true,
            5
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
            40,
            50,
            false,
            0
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
            100,
            100,
            false,
            0
        );
    }
}
