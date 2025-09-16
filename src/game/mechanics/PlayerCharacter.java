package game.mechanics;

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
    private final List<Spell> knownSpells = new ArrayList<>();

    public PlayerCharacter(String name, String characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        applyClassStats(characterClass);
    }

    public static PlayerCharacter create(String name, String characterClass) {
        return new PlayerCharacter(name, characterClass);
    }

    private void applyClassStats(String cls) {
        switch (cls.toLowerCase()) {
            case "fighter" -> setStats(16, 12, 14, 8, 10, 10, 20, 0);
            case "paladin" -> setStats(14, 10, 14, 10, 12, 12, 18, 4);
            case "ranger"  -> setStats(12, 16, 12, 10, 10, 10, 16, 2);
            case "thief"   -> setStats(10, 18, 12, 10, 10, 12, 14, 0);
            case "sorcerer"-> setStats(8, 12, 10, 18, 10, 10, 12, 12);
            case "priest"  -> setStats(10, 10, 14, 10, 16, 10, 16, 10);
            default         -> setStats(10, 10, 10, 10, 10, 10, 10, 0);
        }
    }

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

    
  
    public String getName() { return name; }
    public String getCharacterClass() { return characterClass; }
    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getConstitution() { return constitution; }
    public int getIntelligence() { return intelligence; }
    public int getWisdom() { return wisdom; }
    public int getCharisma() { return charisma; }
    public int getCurrentHP() { return currentHP; }
    public int getMaxHP() { return maxHP; }
    public int getCurrentMana() { return currentMana; }
    public int getMaxMana() { return maxMana; }

    public List<Item> getInventory() { return inventory; }
    public List<Spell> getKnownSpells() { return knownSpells; }

    public Weapon getEquippedWeapon() { return equippedWeapon; }
    public void setEquippedWeapon(Weapon weapon) { this.equippedWeapon = weapon; }

    public Armor getEquippedArmor() { return equippedArmor; }
    public void setEquippedArmor(Armor armor) { this.equippedArmor = armor; }

   
    public int getModifier(String statName) {
        int stat = switch (statName.toUpperCase()) {
            case "STR" -> strength;
            case "DEX" -> dexterity;
            case "CON" -> constitution;
            case "INT" -> intelligence;
            case "WIS" -> wisdom;
            case "CHA" -> charisma;
            default -> 10;
        };
        return (stat - 10) / 2;
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

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public void heal(int amount) {
        currentHP = Math.min(maxHP, currentHP + amount);
    }

    public void restoreMana(int amount) {
        currentMana = Math.min(maxMana, currentMana + amount);
    }

    public void playerTakeDamage(int amount) {
        currentHP = Math.max(0, currentHP - amount);
    }

    public void setCurrentMana(int mana) {
        this.currentMana = Math.max(0, Math.min(mana, maxMana));
    }
}