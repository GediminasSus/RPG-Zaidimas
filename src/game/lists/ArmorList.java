package game.lists;



import game.mechanics.Armor;


public class ArmorList {
    // basic armor ----------------------------------------------------------------------------------------------------
    public static Armor leatherArmor() {
        return new Armor(
        "Leather Armor",                                
        "Light armor with good mobility.",
        50,       
        1,                                           
        1       
        );
    }

    public static Armor studdedArmor() {
        return new Armor(
        "Studded Armor",
        "Basic studded leather armor.",
        50,
        2,
        1
        );
    }    
    
    public static Armor chainmail() {
        return new Armor(
        "Chainmail",
        "Heavy armor that doesn't benefit from agility.",
        50,
        3,
        1
        );
    }

    public static Armor platemail() {
        return new Armor(
        "Plaitmail",
        "Heavy armor of heavy infantry.",
        50,
        4,
        1
        );
    }

    public static Armor robes() {
        return new Armor(
        "Robes",
        "Robes offering limited protection but full mobility.",
        50,
        0,
        2
        );
    }      

    // +1 armor ----------------------------------------------------------------------------------------------------
    public static Armor leatherArmor1() {
        return new Armor(
        "Leather Armor + 1",                                
        "Hand crafted leather armor.",
        50,       
        2,                                           
        2        
        );
    }

    public static Armor studdedArmor1() {
        return new Armor(
        "Studded Armor + 1",
        "Quality studded leather armor.",
        50,
        3,
        1
        );
    }    
    
    public static Armor chainmail1() {
        return new Armor(
        "Chainmail + 1",
        "Sturdy armor made from light material.",
        50,
        4,
        1
        );
    }

    public static Armor platemail1() {
        return new Armor(
        "Plaitmail + 1",
        "Plate of the field general.",
        50,
        6,
        1
        );
    }

    public static Armor robes1() {
        return new Armor(
        "Robes + 1",
        "Magically enchanted robes.",
        50,
        2,
        1
        );
    }      
    
}
