package game.lists;


import game.mechanics.PlayerCharacter;


public class StartingEquipment {

    private StartingEquipment() {}

    public static void assign(PlayerCharacter pc) {
        String cls = pc.getCharacterClass();

        switch (cls) {
            case "Fighter" -> {
                pc.equipWeapon(WeaponList.greatsword());
                pc.equipArmor(ArmorList.chainmail());
            }
            case "Paladin" -> {
                pc.equipWeapon(WeaponList.mace());
                pc.equipArmor(ArmorList.chainmail());
            }
            case "Ranger" -> {
                pc.equipWeapon(WeaponList.bow());
                pc.equipArmor(ArmorList.leatherArmor());
            }
            case "Thief" -> {
                pc.equipWeapon(WeaponList.dagger());
                pc.equipArmor(ArmorList.leatherArmor());
            }
            case "Sorcerer" -> {
                pc.equipWeapon(WeaponList.staff());
                pc.equipArmor(ArmorList.robes());
                pc.learnSpell(SpellList.makeWounds());
            }
            case "Priest" -> {
                pc.equipWeapon(WeaponList.mace());
                pc.equipArmor(ArmorList.robes());
                pc.learnSpell(SpellList.healWounds());
            }
        }

        // Default potion for all
        pc.getInventory().add(PotionList.lesserHealingPotion());
    }
}
