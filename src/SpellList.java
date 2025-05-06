import java.util.Set;

public class SpellList {

    public static Spell healingHands() {
        return new Spell(
            "Healing hands",                                  // name
            "You lay hands on someone to heal them.",  // descrption
            5,                                            // mana cost
            4,                                          // dice
            2,                                             // number of dice
            0,                                         // bonus
            true,                                           // is heal?
            false,                                 // is bound to weapon attack
            "WIS",                                     // casting modifier
            Set.of("Paladin"),                     // calsses that can use
            1                                           // spell level
        );
    }

    public static Spell dvineSmite() {
        return new Spell(
            "Divine smite",                                  
            "You smite your enemies with holy damage.",  
            10,                                            
            6,                                          
            2,                                             
            0,                                         
            false,                                           
            true,                                 
            "WIS",                                     
            Set.of("Paladin"),
            3                     
        );
    }

    public static Spell LesserRestoration() {
        return new Spell(
            "Lesser restoration",                                  
            "Restore 1hp to someone who was knocked down and is with 0 hp.",  
            15,                                            
            0,                                          
            0,                                             
            1,                                         
            true,                                           
            false,                                 
            "WIS",                                     
            Set.of("Paladin"),
            5                     
        );
    }


    public static Spell huntersMark() {
        return new Spell(
            "Hunter's mark",                                  
            "Concentrated attack.",  
            5,                                            
            4,                                          
            3,                                             
            1,                                         
            false,                                           
            true,                                 
            "DEX",                                     
            Set.of("Ranger"),
            1                     
        );
    }

    public static Spell naturesBlessing() {
        return new Spell(
            "Nature's blessing",                                  
            "You use the power of nature to heal.",  
            10,                                            
            4,                                          
            2,                                             
            2,                                         
            false,                                           
            true,                                 
            "DEX",                                     
            Set.of("Ranger"),
            2                     
        );
    }

    public static Spell deadlyAttack() {
        return new Spell(
            "Deadly attack",                                  
            "Attack infused with nature's wrath.",  
            15,                                            
            6,                                          
            2,                                             
            3,                                         
            false,                                           
            true,                                 
            "DEX",                                     
            Set.of("Ranger"),
            3                     
        );
    }

    public static Spell healWounds() {
        return new Spell(
            "Heal wounds",                                  
            "Heal wounds.",  
            5,                                            
            4,                                          
            2,                                             
            2,                                         
            true,                                           
            false,                                 
            "WIS",                                     
            Set.of("Priest"),
            1                    
        );
    }

    public static Spell makeWounds() {
        return new Spell(
            "Make wounds",                                  
            "Make wounds.",  
            5,                                            
            4,                                          
            2,                                             
            2,                                         
            false,                                           
            false,                                 
            "WIS",                                     
            Set.of("Priest"),
            1                    
        );
    }

    public static Spell judgement() {
        return new Spell(
            "Judgement",                                  
            "Strike enemies with holy radiance.",  
            10,                                            
            8,                                          
            2,                                             
            2,                                         
            false,                                           
            false,                                 
            "WIS",                                     
            Set.of("Priest"),
            2                    
        );
    }

    public static Spell ressurection() {
        return new Spell(
            "Ressurection",                                  
            "Ressurect the dead companion from the dead.",  
            15,                                            
            12,                                          
            12,                                             
            50,                                         
            true,                                           
            false,                                 
            "WIS",                                     
            Set.of("Priest"),
            3                    
        );
    }

    public static Spell sqorchingRay() {
        return new Spell(
            "Sqorching ray",                                  
            "A ray of fire.",  
            5,                                            
            12,                                          
            1,                                             
            0,                                         
            false,                                           
            false,                                 
            "INT",                                     
            Set.of("Sorcerer"),
            1                    
        );
    }

    public static Spell shatter() {
        return new Spell(
            "Shatter",                                  
            "A powerful thunger errupts.",  
            10,                                            
            12,                                          
            2,                                             
            2,                                         
            false,                                           
            false,                                 
            "WIS",                                     
            Set.of("Sorcerer"),
            2                    
        );
    }

    public static Spell fireBall() {
        return new Spell(
            "Fire ball",                                  
            "When you really want something dead.",  
            15,                                            
            6,                                          
            6,                                             
            6,                                         
            false,                                           
            false,                                 
            "WIS",                                     
            Set.of("Sorcerer"),
            3                    
        );
    }

}