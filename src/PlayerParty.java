import java.util.ArrayList;
import java.util.List;

public class PlayerParty {
    private final List<PlayerCharacter> members = new ArrayList<>();
    private final List<Item> partyInventory = new ArrayList<>();
    private int gold = 0;
    public int getGold() { return gold; }
    public void addGold(int amount) { gold += amount; }
    public void spendGold(int amount) { gold -= amount; }

    public void createCharacters() {
        members.add(new PlayerCharacter("Aldric", "Fighter"));
        members.get(0).setStats(16, 12, 14, 8, 10, 10, 20, 0 ); // STR-focused

        members.add(new PlayerCharacter("Serena", "Sorcerer"));
        members.get(1).setStats(8, 14, 10, 16, 10, 10, 10, 20); // INT-focused

        members.add(new PlayerCharacter("Thorne", "Thief"));
        members.get(2).setStats(10, 16, 12, 10, 10, 10, 15, 0); // DEX-focused

        members.add(new PlayerCharacter("Liora", "Priest"));
        members.get(3).setStats(10, 10, 12, 10, 16, 12, 10 ,20); // WIS-focused

        for (PlayerCharacter character : members) {
            assignStartingItems(character);
        }
        gold = 100;
    }

    public List<Item> getPartyInventory() {
        return partyInventory;
    }
    
    public void addToInventory(Item item) {
        partyInventory.add(item);
    }

    public List<PlayerCharacter> getMembers() {
        return members;
    }

    public void displayPartyStats() {
        for (PlayerCharacter pc : members) {
            System.out.println(pc.getName() + " the " + pc.getCharacterClass());
            System.out.println("  AC: " + pc.getTotalArmorClass());
            System.out.println("  Weapon: " + (pc.getEquippedWeapon() != null ? pc.getEquippedWeapon().getName() : "None"));
            System.out.println("  Armor: " + (pc.getEquippedArmor() != null ? pc.getEquippedArmor().getName() : "None"));
            System.out.println("  Inventory:");
            for (Item item : pc.getInventory()) {
                System.out.println("    - " + item.getName());
            }
        }
    }

    public void assignStartingItems(PlayerCharacter character) {
        switch (character.getCharacterClass()) {
            case "Fighter" -> {
                character.getInventory().add(WeaponList.greatsword());
                character.getInventory().add(ArmorList.chainmail());
                character.getInventory().add(PotionList.lesserHealingPotion());
            }
            case "Paladin" -> {
                character.getInventory().add(WeaponList.swordAndShield());
                character.getInventory().add(ArmorList.chainmail());
                character.getInventory().add(PotionList.lesserHealingPotion());
                character.learnSpell(SpellList.healingHands());
                
            }
            case "Ranger" -> {
                character.getInventory().add(WeaponList.bow());
                character.getInventory().add(ArmorList.leatherArmor());
                character.getInventory().add(PotionList.lesserHealingPotion());
                character.learnSpell(SpellList.huntersMark());
                
                
            }
            case "Thief" -> {
                character.getInventory().add(WeaponList.dagger());
                character.getInventory().add(ArmorList.leatherArmor());
                character.getInventory().add(PotionList.lesserHealingPotion());
            }
            case "Sorcerer" -> {
                character.getInventory().add(WeaponList.wand());
                character.getInventory().add(ArmorList.robes());
                character.getInventory().add(PotionList.lesserManaPotion());
                character.learnSpell(SpellList.sqorchingRay());
                
            }
            case "Priest" -> {
                character.getInventory().add(WeaponList.mace());
                character.getInventory().add(ArmorList.robes());
                character.getInventory().add(PotionList.lesserManaPotion());
                character.learnSpell(SpellList.healWounds());
                
            }
        }

        for (Item item : character.getInventory()) {
            partyInventory.add(item);
        }

        // Auto-equip 
        /*for (Item item : character.getInventory()) {
            if (item instanceof Weapon && character.getEquippedWeapon() == null) {
                character.equipWeapon((Weapon) item);
            }
            if (item instanceof Armor && character.getEquippedArmor() == null) {
                character.equipArmor((Armor) item);
            }
        }*/
    }
}
