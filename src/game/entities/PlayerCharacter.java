package game.entities;

public class PlayerCharacter extends Character {
    private final int characterClass;

    public PlayerCharacter(String name, int characterClass) {
        super(name);
        this.characterClass = characterClass;
        applyClassStats();
    }

    public static PlayerCharacter create(String name, int characterClass) {
        return new PlayerCharacter(name, characterClass);
    }

    private void applyClassStats() {
        switch (characterClass) {
            case 1 -> {
                maxHP = 30;
                currentHP = 30;
                attackPower = 8;
                spellPower = 2;
                maxMana = 5;
                currentMana = 5;
            }
            case 2 -> {
                maxHP = 20;
                currentHP = 20;
                attackPower = 3;
                spellPower = 10;
                maxMana = 20;
                currentMana = 20;
            }
            default -> throw new IllegalArgumentException("Unknown class: " + characterClass);
        }
    }
    @Override
    public int getCharacterClass() { return characterClass; }

    public String getClassName() {
        return switch (characterClass) {
            case 1 -> "Fighter";
            case 2 -> "Mage";
            default -> "Unknown";
    };
}

}