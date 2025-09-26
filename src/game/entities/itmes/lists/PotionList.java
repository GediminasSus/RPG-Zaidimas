package game.entities.itmes.lists;

import game.entities.itmes.Potion;

public class PotionList {
    private PotionList() {} 

    // potions lesser
    public static Potion lesserHealingPotion() {
        return new Potion("Lesser Health potion","Restores 2d4 + 2 health.",
            50,4,2,true,false);
    }
    public static Potion lesserManaPotion() {
        return new Potion("Lesser Mana potion","Restores 1d4 + 1 mana.",
            50,4,1,false,true);
    }
    // potions normas
    public static Potion healingPotion() {
        return new Potion("Health potion","Restores 3d4 + 3 health.",
            50,4,3,true,false);
    }
    public static Potion manaPotion() {
        return new Potion("Mana potion","Restores 2d4 + 2 mana.",
            50,4,2,false,true);
    }
    // potions greater
    public static Potion greaterHealingPotion() {
        return new Potion("Greater Health potion","Restores 4d4 + 4 health.",
            50,4,4,true,false);
    }
    public static Potion greaterManaPotion() {
        return new Potion("Greater Mana potion","Restores 3d4 + 3 mana.",
            50,4,3,false,true);
    }
    // potions ultimate
    public static Potion ultimatePotion() {
        return new Potion("Ultimate potion","Restores 3d4 + 3 health and mana.",
            50,4,3,true,true);
    }   
}