import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {
    private String name;
    private String characterClass;
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int currentHP, maxHP, currentMana, maxMana;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private final List<Item> inventory = new ArrayList<>();

    public PlayerCharacter(String name, String characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        this.strength = 10;
        this.dexterity = 10;
        this.constitution = 10;
        this.intelligence = 10;
        this.wisdom = 10;
        this.charisma = 10;
        this.maxHP = 10;
        this.currentHP = 10;
    }

    public String getName() { return name; }
    public String getCharacterClass() { return characterClass; }
    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getConstitution() { return constitution; }
    public int getIntelligence() { return intelligence; }
    public int getWisdom() { return wisdom; }
    public int getCharisma() { return charisma; }

    public void setStats(int str, int dex, int con, int intel, int wis, int cha, int maxHP, int maxMana) {
        this.strength = str;
        this.dexterity = dex;
        this.constitution = con;
        this.intelligence = intel;
        this.wisdom = wis;
        this.charisma = cha;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    public int getModifier(String statName) {
        int stat = switch (statName.toUpperCase()) {
            case "STR" -> getStrength();
            case "DEX" -> getDexterity();
            case "CON" -> getConstitution();
            case "INT" -> getIntelligence();
            case "WIS" -> getWisdom();
            case "CHA" -> getCharisma();
            default -> 10;
        };
        return (stat - 10) / 2;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor armor) {
        this.equippedArmor = armor;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getTotalArmorClass() {
        int base = 10;
        if (equippedArmor != null) {
            int dexMod = getModifier("DEX");
            int cap = equippedArmor.getDexBonusCap();
            base += equippedArmor.getAcBonus() + Math.min(dexMod, cap);
        }
        return base;
    }

    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getAllowedClasses().contains(characterClass)) {
            this.equippedWeapon = weapon;
            return true;
        }
        return false;
    }

    public boolean equipArmor(Armor armor) {
        if (armor.getAllowedClasses().contains(characterClass)) {
            this.equippedArmor = armor;
            return true;
        }
        return false;
    }

    public void heal(int amount) {
        currentHP = Math.min(maxHP, currentHP + amount);
    }
    
    public void restoreMana(int amount) {
        currentMana = Math.min(maxMana, currentMana + amount);
    }

    public int getCurrentMana() {
        return currentMana;
    }
    
    public void setCurrentMana(int mana) {
        this.currentMana = Math.max(0, Math.min(mana, maxMana));
    }
    
    public int getMaxMana() {
        return maxMana;
    }

    private List<Spell> knownSpells = new ArrayList<>();

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public void playerTakeDamage(int amount) {
        currentHP = Math.max(0, currentHP - amount);
    }
    

    
}
