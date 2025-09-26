package game.entities.itmes.lists;



import game.entities.PlayerCharacter;
import game.main.PlayerParty;


public class StartingEquipment {

    private StartingEquipment() {}

    public static void assign(PlayerCharacter pc, PlayerParty party) {
        int cls = pc.getCharacterClass();

        switch (cls) {
            case 1 -> {
                pc.equipWeapon(WeaponList.greatsword());
                pc.equipArmor(ArmorList.chainmail());
            }
            case 2 -> {
                pc.equipWeapon(WeaponList.wand());
                pc.equipArmor(ArmorList.robes());
                pc.learnSpell(SpellList.healingHands());
                pc.learnSpell(SpellList.scorchingRay());
            }
            default -> throw new IllegalArgumentException("Unknown class id: " + cls);
            }

        party.getPartyInventory().add(PotionList.lesserHealingPotion());       
    }
}
