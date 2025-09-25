package game.mechanics;

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
        // Monsters don't use classes, return -1 or special constant
        return -1;
    }

    public int getHitBonus() { return hitBonus; }
    public int getDamageDice() { return damageDice; }
    public int getAttackPower() { return attackPower; }
}
