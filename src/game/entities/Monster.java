package game.entities;

public class Monster extends Character {
    private final int damageDice;
    private final int hitBonus;

    public Monster(String name, int hp, int attackPower, int spellPower, int hitBonus, int damageDice) {
        super(name);
        this.maxHP = hp;
        this.currentHP = hp;
        this.attackPower = attackPower;
        this.spellPower = spellPower;
        this.hitBonus = hitBonus;
        this.damageDice = damageDice;
    }

    @Override
    public int getCharacterClass() {
        // Monsters don't have class yet, for future updates
        return -1;
    }

    public int getHitBonus() { return hitBonus; }
    public int getDamageDice() { return damageDice; }
}
