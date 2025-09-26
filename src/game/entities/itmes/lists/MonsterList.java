package game.entities.itmes.lists;

import game.entities.Monster;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class MonsterList {
    private MonsterList() {}
    private static final Random rand = new Random();

    public static Monster goblin() {
        return new Monster("Goblin",15,2,0,2,6);
    }
    public static Monster packGoblin() {
        return new Monster("Pack of goblins",40,2,0,6,6);
    }
    public static Monster orc() {
        return new Monster("Orc",18,4,0,4,8);
    }
    public static Monster skeleton() {
        return new Monster("Skeleton",12,2,0,2,6);
    }
    public static Monster packOfSkeleton() {
        return new Monster("Pack of skeletons",24,4,0,6,6);
    }
    public static Monster slime() {
        return new Monster("Slime",14,2,0,2,6);
    }
    public static Monster orcChief() {
        return new Monster("Orc chief",60,8,0,6,12);
    }

    private static final List<Supplier<Monster>> monsters = List.of(
        MonsterList::goblin,
        MonsterList::packGoblin,
        MonsterList::orc,
        MonsterList::skeleton,
        MonsterList::packOfSkeleton,
        MonsterList::slime,
        MonsterList::orcChief
    );

    public static Monster randomMonster() {
        return monsters.get(rand.nextInt(monsters.size())).get();
    }
}
