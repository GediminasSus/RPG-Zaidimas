package game.mechanics;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int attackPower;
    protected int spellPower;
    protected int currentHP;
    protected int maxHP;
    protected int currentMana;
    protected int maxMana;

    private Weapon equippedWeapon;
    private Armor equippedArmor;
    protected final List<Item> inventory = new ArrayList<>();
    private final List<Spell> knownSpells = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    // Subclass must implement
    public abstract int getCharacterClass();

    public List<Spell> getKnownSpells() { return knownSpells; }
    public String getName() { return name; }
    public boolean isAlive() { return currentHP > 0; }
    public boolean isDead() { return currentHP <= 0; }

    public int getTotalArmorClass() {
        int base = 13;
        if (equippedArmor != null) {
            base += equippedArmor.getAcBonus();
        }
        return base;
    }

    public void takeDamage(int amount) {
        currentHP = Math.max(0, currentHP - amount);
    }

    public void heal(int amount) {
        currentHP = Math.min(maxHP, currentHP + amount);
    }

    public void restoreMana(int amount) {
        currentMana = Math.min(maxMana, currentMana + amount);
    }

    public void learnSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public void setCurrentMana(int mana) {
        this.currentMana = Math.max(0, Math.min(mana, maxMana));
    }

    public boolean equipWeapon(Weapon weapon) {
        if (weapon.getAllowedClasses() == getCharacterClass()) {
            this.equippedWeapon = weapon;
            return true;
        }
        return false;
    }

    public boolean equipArmor(Armor armor) {
        if (armor.getAllowedClasses() == getCharacterClass()) {
            this.equippedArmor = armor;
            return true;
        }
        return false;
    }

    public void addItem(Item item) { inventory.add(item); }
    public void removeItem(Item item) { inventory.remove(item); }
    public List<Item> getInventory() { return inventory; }
    public Weapon getEquippedWeapon() { return equippedWeapon; }
    public Armor getEquippedArmor() { return equippedArmor; }
    public int getCurrentHP() { return currentHP; }
    public int getCurrentMana() { return currentMana; }
    public int getMaxHP() { return maxHP; }
    public int getMaxMana() { return maxMana; }
    public int getAttackPower() { return attackPower; }
    public int getSpellPower() { return spellPower; }
}
