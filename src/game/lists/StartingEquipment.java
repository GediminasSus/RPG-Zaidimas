package game.lists;



import game.PlayerParty;
import game.mechanics.PlayerCharacter;


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
            
        }

        // Default potion for all
        party.getPartyInventory().add(PotionList.lesserHealingPotion());
        
    }
}
