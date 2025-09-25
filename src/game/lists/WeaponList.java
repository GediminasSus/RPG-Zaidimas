package game.lists;
import game.mechanics.Weapon;

public class WeaponList {

    private WeaponList() {}
    // basic weapons
    public static Weapon shortSword() {
        return new Weapon(
            "Short Sword", // Name
            "A simple steel sword. Reliable in close combat.", // Description
            50,
            8,      // Dice of damage
            0,      // hit bonus
            1
        );
    }

    public static Weapon swordAndShield() {
        return new Weapon(
            "Sword and shield", 
            "A standart issue sword and shield.", 
            50,
            6,      
            0,      
            1
        );
    }

    public static Weapon dagger() {
        return new Weapon(
            "Dagger",
            "A lightweight, easily concealed blade.",
            50,
            4,
            0,
            1
        );
    }

    public static Weapon greatsword() {
        return new Weapon(
            "Greatsword",
            "Massive two-handed sword for crushing foes.",
            50,
            12,      
            0,      
            1
        );
    }

    public static Weapon mace() {
        return new Weapon(
            "Mace",
            "A heavy blunt weapon ideal for priests.",
            50,
            6,      
            0,      
            1
        );
    }

    public static Weapon staff() {
        return new Weapon(
            "Quarterstaff",
            "A basic wooden staff used by spellcasters.",
            50,
            6,      
            0,      
            2
            );
        }

    public static Weapon wand() {
        return new Weapon(
            "Wand of Sparks",
            "Casts a small arcane bolt. Better with magic.",
            50,
            4,      
            0,      
            2
            );
        }

    public static Weapon bow() {
        return new Weapon(
            "Short Bow",
            "A simple bow. Good for quick ranged attacks.",
            50,
            6,      
            0,      
            1
            );
        }
    // +1 weapons -------------------------------------------------------------------------------------------------
    public static Weapon shortSword1() {
        return new Weapon(
            "Short Sword + 1", // Name
            "A quality steel sword.", // Description
            50,
            10,      // Dice of damage
            1,      // hit bonus
            1
            );
        }
    public static Weapon swordAndShield1() {
        return new Weapon(
            "Sword and shield + 1", 
            "Sword and shield of a Paladin.", 
            50,
            8,      
            1,      
            1
            );
        }

    public static Weapon dagger1() {
        return new Weapon(
            "Dagger + 1",
            "Llightweight, mage from obsidian.",
            50,
            6,
            1,
            1
            );
        }

    public static Weapon greatsword1() {
        return new Weapon(
            "Greatsword + 1",
            "Quality two-handed sword.",
            50,
            14,      
            1,      
            1
            );
        }
    public static Weapon mace1() {
        return new Weapon(
            "Mace + 1",
            "The Holy mace of judgement.",
            50,
            8,      
            1,      
            1
            );
        }
    public static Weapon staff1() {
        return new Weapon(
            "Quarterstaff + 1",
            "Masterfully crafted staff.",
            50,
            8,      
            1,      
            2
            );
        }

    public static Weapon wand1() {
        return new Weapon(
            "Wand of Sparks + 1",
            "Has lighting trapped inside.",
            50,
            8,      
            1,      
            2
            );
        }

    public static Weapon bow1() {
        return new Weapon(
            "Short Bow + 1",
            "Elven craftmenship bow.",
            50,
            8,      
            1,      
            2
            );
        }
}