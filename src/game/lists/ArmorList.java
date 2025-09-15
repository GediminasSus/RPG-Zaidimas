package game.lists;

import java.util.Set;

import game.mechanics.Armor;


public class ArmorList {
    // basic armor ----------------------------------------------------------------------------------------------------
    public static Armor leatherArmor() {
        Armor leatherArmor = new Armor(
        "Leather Armor",                                // Name
        "Light armor with good mobility.",       // Description
        1,                                           // base AC
        2,                                       // max DEX bonus
        Set.of("Fighter", "Paladin", "Ranger", "Thief")        // Class permissions
        );
        leatherArmor.setGoldValues(150, 60);
        return leatherArmor;
    }

    public static Armor studdedArmor() {
         Armor studdedArmor = new Armor(
        "Studded Armor",
        "Basic studded leather armor.",
        2,
        2,
        Set.of("Fighter", "Paladin", "Ranger")
        );
        studdedArmor.setGoldValues(150, 60);
        return studdedArmor;
    }    
    
    public static Armor chainmail() {
         Armor chainmail = new Armor(
        "Chainmail",
        "Heavy armor that doesn't benefit from agility.",
        3,
        0, 
        Set.of("Fighter", "Paladin")
        );
        chainmail.setGoldValues(150, 60);
        return chainmail;
    }

    public static Armor platemail() {
         Armor platemail = new Armor(
        "Plaitmail",
        "Heavy armor of heavy infantry.",
        4,
        0, 
        Set.of("Fighter", "Paladin")
        );
        platemail.setGoldValues(150, 60);
        return platemail;
    }

    public static Armor robes() {
         Armor robes = new Armor(
        "Robes",
        "Robes offering limited protection but full mobility.",
        0,
        3,
        Set.of("Priest", "Sorcerer")
        );
        robes.setGoldValues(150, 60);
        return robes;
    }      

    // +1 armor ----------------------------------------------------------------------------------------------------
    public static Armor leatherArmor1() {
         Armor leatherArmor1 = new Armor(
        "Leather Armor + 1",                                // Name
        "Hand crafted leather armor.",       // Description
        2,                                           // base AC
        3,                                       // max DEX bonus
        Set.of("Fighter", "Paladin", "Ranger", "Thief")        // Class permissions
        );
        leatherArmor1.setGoldValues(150, 60);
        return leatherArmor1;
    }

    public static Armor studdedArmor1() {
         Armor studdedArmor1 = new Armor(
        "Studded Armor + 1",
        "Quality studded leather armor.",
        3,
        3,
        Set.of("Fighter", "Paladin", "Ranger")
        );
        studdedArmor1.setGoldValues(150, 60);
        return studdedArmor1;
    }    
    
    public static Armor chainmail1() {
         Armor chainmail1 = new Armor(
        "Chainmail + 1",
        "Sturdy armor made from light material.",
        4,
        1, 
        Set.of("Fighter", "Paladin")
        );
        chainmail1.setGoldValues(150, 60);
        return chainmail1;
    }

    public static Armor platemail1() {
         Armor platemail1 = new Armor(
        "Plaitmail + 1",
        "Plate of the field general.",
        6,
        0, 
        Set.of("Fighter", "Paladin")
        );
        platemail1.setGoldValues(150, 60);
        return platemail1;
    }

    public static Armor robes1() {
         Armor robes1 = new Armor(
        "Robes + 1",
        "Magically enchanted robes.",
        2,
        4,
        Set.of("Priest", "Sorcerer")
        );
        robes1.setGoldValues(150, 60);
        return robes1;
    }      
    
}
