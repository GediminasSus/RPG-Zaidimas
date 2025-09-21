package game.lists;


import game.PlayerParty;
import game.mechanics.PlayerCharacter;


public class StartingEquipment {

    private StartingEquipment() {}

    public static void assign(PlayerCharacter pc, PlayerParty party) {
        String cls = pc.getCharacterClass();

        switch (cls) {
            case "Fighter" -> {
                pc.equipWeapon(WeaponList.greatsword());
                pc.equipArmor(ArmorList.chainmail());
            }
            case "Paladin" -> {
                pc.equipWeapon(WeaponList.greatsword());
                pc.equipArmor(ArmorList.platemail());
                pc.learnSpell(SpellList.healingHands());
            }
            case "Ranger" -> {
                pc.equipWeapon(WeaponList.bow());
                pc.equipArmor(ArmorList.leatherArmor());
                pc.learnSpell(SpellList.huntersMark());
            }
            case "Sorcerer" -> {
                pc.equipWeapon(WeaponList.staff());
                pc.equipArmor(ArmorList.robes());
                pc.learnSpell(SpellList.sqorchingRay());
            }
            case "Priest" -> {
                pc.equipWeapon(WeaponList.mace());
                pc.equipArmor(ArmorList.robes());
                pc.learnSpell(SpellList.healWounds());
                pc.learnSpell(SpellList.makeWounds());
            }
        }

        // Default potion for all
        party.getPartyInventory().add(PotionList.lesserHealingPotion());
        
    }
}
