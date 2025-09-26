package game.entities.itmes.lists;

import game.entities.itmes.Spell;
import game.enums.SpellType;

public class SpellList {

    private SpellList() {}

    public static Spell healingHands() {
        return new Spell("Healing Hands",1,4,0,SpellType.HEAL);
    }
    public static Spell healWounds() {
        return new Spell("Heal Wounds",1,4,0,SpellType.HEAL);
    }

    public static Spell makeWounds() {
        return new Spell("Make Wounds",1,4,2,SpellType.DAMAGE);
    }
    public static Spell scorchingRay() {
        return new Spell("Scorching Ray",1,12,1,SpellType.DAMAGE);
    }
    public static Spell shatter() {
        return new Spell("Shatter",2,12,2,SpellType.DAMAGE);
    }
    public static Spell fireBall() {
        return new Spell("Fireball",3,6,6,SpellType.DAMAGE);
    }
}
