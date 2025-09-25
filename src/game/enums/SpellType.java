package game.enums;

public enum SpellType {
    DAMAGE, HEAL, BUFF, DEBUFF;

    public boolean targetsEnemy() {
        return this == DAMAGE || this == DEBUFF;
    }

    public boolean targetsAlly() {
        return this == HEAL || this == BUFF;
    }
}
