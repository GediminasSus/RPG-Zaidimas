package game.lists;

import game.mechanics.Potion;

public class PotionList {
    private PotionList() {} 

    // potions lesser
    public static Potion lesserHealingPotion() {
        Potion lesserHealingPotion = new Potion(
        "Lesser Health potion",                 // name               
        "Restores 2d4 + 2 health.",      // description 
        4,                                      // dice     
        2,                              // number of dice         
        2,                                     // flat bonus
        true,                          // restore health
        false                            // restore mana
        );
        lesserHealingPotion.setGoldValues(50, 20);
        return lesserHealingPotion;
    }

    public static Potion lesserManaPotion() {
        Potion lesserManaPotion = new Potion(
        "Lesser Mana potion",                          
        "Restores 1d4 + 1 mana.",      
        4,                                      
        1,                                     
        1,                                     
        false,                          
        true                            
        );
        lesserManaPotion.setGoldValues(50, 20);
        return lesserManaPotion;
    }

    // potions normas
    public static Potion healingPotion() {
        Potion healingPotion = new Potion(
        "Health potion",                 // name               
        "Restores 3d4 + 3 health.",      // description 
        4,                                      // dice     
        3,                              // number of dice         
        3,                                     // flat bonus
        true,                          // restore health
        false                            // restore mana
        );
        healingPotion.setGoldValues(50, 20);
        return healingPotion;
    }

    public static Potion manaPotion() {
        Potion manaPotion = new Potion(
        "Mana potion",                          
        "Restores 2d4 + 2 mana.",      
        4,                                      
        2,                                     
        2,                                     
        false,                          
        true                            
        );
        manaPotion.setGoldValues(50, 20);
        return manaPotion;
    }

    // potions greater
    public static Potion greaterHealingPotion() {
        Potion greaterHealingPotion = new Potion(
        "Greater Health potion",                 // name               
        "Restores 4d4 + 4 health.",      // description 
        4,                                      // dice     
        4,                              // number of dice         
        4,                                     // flat bonus
        true,                          // restore health
        false                            // restore mana
        );
        greaterHealingPotion.setGoldValues(50, 20);
        return greaterHealingPotion;
    }

    public static Potion greaterManaPotion() {
        Potion greaterManaPotion = new Potion(
        "Greater Mana potion",                          
        "Restores 3d4 + 3 mana.",      
        4,                                      
        3,                                     
        3,                                     
        false,                          
        true                            
        );
        greaterManaPotion.setGoldValues(50, 20);
        return greaterManaPotion;
    }

    // potions ultimate
    public static Potion ultimatePotion() {
        Potion ultimatePotion = new Potion(
        "Ultimate potion",                 // name               
        "Restores 3d4 + 3 health and mana.",      // description 
        4,                                      // dice     
        3,                              // number of dice         
        3,                                     // flat bonus
        true,                          // restore health
        true                            // restore mana
        );
        ultimatePotion.setGoldValues(50, 20);
        return ultimatePotion;
    }

   
}