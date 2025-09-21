package game.lists;
import game.mechanics.Weapon;
import java.util.Set;

public class WeaponList {

    private WeaponList() {}
    // basic weapons
    public static Weapon shortSword() {
        Weapon shortSword = new Weapon(
            "Short Sword", // Name
            "A simple steel sword. Reliable in close combat.", // Description
            8,      // Dice of damage
            0,      // hit bonus
            "STR",  // Scaling stat
            1,      // number of dice
            Set.of("Fighter", "Paladin", "Ranger") // Calss permission
        );
        shortSword.setGoldValues(100, 40); 
        return shortSword;
    }

    public static Weapon swordAndShield() {
        Weapon swordAndShield = new Weapon(
            "Sword and shield", 
            "A standart issue sword and shield.", 
            6,      
            0,      
            "STR",  
            1,      
            Set.of("Fighter", "Paladin", "Ranger") 
        );
        swordAndShield.setGoldValues(100, 40); 
        return swordAndShield;
    }

    public static Weapon dagger() {
        Weapon dagger = new Weapon(
            "Dagger",
            "A lightweight, easily concealed blade.",
            4,
            0,
            "DEX",
            2,
            Set.of("Thief", "Ranger")
        );
        dagger.setGoldValues(100, 40); 
        return dagger;
    }

    public static Weapon greatsword() {
        Weapon greatsword = new Weapon(
            "Greatsword",
            "Massive two-handed sword for crushing foes.",
            12,      
            0,      
            "STR",  
            1,      
            Set.of("Fighter", "Paladin")
        );
        greatsword.setGoldValues(100, 40); 
        return greatsword;
    }

    public static Weapon mace() {
        Weapon mace = new Weapon(
            "Mace",
            "A heavy blunt weapon ideal for priests.",
            6,      
            0,      
            "STR",  
            1,      
            Set.of("Priest", "Paladin")
        );
        mace.setGoldValues(100, 40); 
        return mace;
    }

    public static Weapon staff() {
        Weapon staff = new Weapon(
            "Quarterstaff",
            "A basic wooden staff used by spellcasters.",
            6,      
            0,      
            "DEX",  
            1,      
            Set.of("Priest", "Sorcerer")
            );
            staff.setGoldValues(100, 40); 
            return staff;
        }

    public static Weapon wand() {
        Weapon wand = new Weapon(
            "Wand of Sparks",
            "Casts a small arcane bolt. Better with magic.",
            4,      
            0,      
            "WIS",  
            2,      
            Set.of("Sorcerer")
            );
            wand.setGoldValues(100, 40); 
            return wand;
        }

    public static Weapon bow() {
        Weapon bow = new Weapon(
            "Short Bow",
            "A simple bow. Good for quick ranged attacks.",
            6,      
            0,      
            "DEX",  
            1,      
            Set.of("Ranger", "Thief")
            );
            bow.setGoldValues(100, 40); 
            return bow;
        }
    // +1 weapons -------------------------------------------------------------------------------------------------
    public static Weapon shortSword1() {
        Weapon shortSword1 = new Weapon(
            "Short Sword + 1", // Name
            "A quality steel sword.", // Description
            10,      // Dice of damage
            1,      // hit bonus
            "STR",  // Scaling stat
            1,      // number of dice
            Set.of("Fighter", "Paladin", "Ranger") // Calss permission
            );
            shortSword1.setGoldValues(100, 40); 
            return shortSword1;
        }
    public static Weapon swordAndShield1() {
        Weapon swordAndShield1 = new Weapon(
            "Sword and shield + 1", 
            "Sword and shield of a Paladin.", 
            8,      
            1,      
            "STR",  
            1,      
            Set.of("Fighter", "Paladin", "Ranger") 
            );
            swordAndShield1.setGoldValues(100, 40); 
            return swordAndShield1;
        }

    public static Weapon dagger1() {
        Weapon dagger1 = new Weapon(
            "Dagger + 1",
            "Llightweight, mage from obsidian.",
            6,
            1,
            "DEX",
            2,
            Set.of("Thief", "Ranger")
            );
            dagger1.setGoldValues(100, 40); 
            return dagger1;
        }

    public static Weapon greatsword1() {
        Weapon greatsword1 = new Weapon(
            "Greatsword + 1",
            "Quality two-handed sword.",
            14,      
            1,      
            "STR",  
            1,      
            Set.of("Fighter", "Paladin")
            );
            greatsword1.setGoldValues(100, 40); 
            return greatsword1;
        }
    public static Weapon mace1() {
        Weapon mace1 = new Weapon(
            "Mace + 1",
            "The Holy mace of judgement.",
            8,      
            1,      
            "STR",  
            1,      
            Set.of("Priest", "Paladin")
            );
            mace1.setGoldValues(100, 40); 
            return mace1;
        }
    public static Weapon staff1() {
        Weapon staff1 = new Weapon(
            "Quarterstaff + 1",
            "Masterfully crafted staff.",
            8,      
            1,      
            "DEX",  
            0,      
            Set.of("Priest", "Sorcerer")
            );
            staff1.setGoldValues(100, 40); 
            return staff1;
        }

    public static Weapon wand1() {
        Weapon wand1 = new Weapon(
            "Wand of Sparks + 1",
            "Has lighting trapped inside.",
            8,      
            1,      
            "WIS",  
            2,      
            Set.of("Sorcerer")
            );
            wand1.setGoldValues(100, 40); 
            return wand1;
        }

    public static Weapon bow1() {
        Weapon bow1 = new Weapon(
            "Short Bow + 1",
            "Elven craftmenship bow.",
            8,      
            1,      
            "DEX",  
            1,      
            Set.of("Ranger", "Thief")
            );
            bow1.setGoldValues(100, 40); 
            return bow1;
        }
}