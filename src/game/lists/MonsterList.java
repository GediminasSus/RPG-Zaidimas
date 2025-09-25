package game.lists;

import game.mechanics.Monster;

public class MonsterList {

    public static Monster goblin() {
        return new Monster(
            "Goblin", // name
            15,     // hp
            2,     // ap
            0,      // sp
            2,      // ab
            6      // dd     
        );
    }

    public static Monster packGoblin() {
        return new Monster(
            "Pack of goblins",
            40,     
            2,     
            0,      
            6, 
            6     
        );
    }

    public static Monster orc() {
        return new Monster(
            "Orc",
            18,
            4,
            0, 
            4, 
            8
        );
    }

    public static Monster skeleton() {
        return new Monster(
            "Skeleton",
            12,
            2,
            0, 
            2, 
            6
        );
    }

    public static Monster packOfSkeleton() {
        return new Monster(
            "Pack of skeletons",
            24,
            4,
            0, 
            6, 
            6
        );
    }

    public static Monster slime() {
        return new Monster(
            "Slime",
            14,
            2,
            0, 
            2, 
            6
        );
    }

    public static Monster orcChief() {
        return new Monster(
            "Orc chief",
            60,
            8,
            0, 
            6, 
            12
        );
    }
}
