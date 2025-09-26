package game.entities.itmes.lists;
import game.entities.itmes.Weapon;

public class WeaponList {

    private WeaponList() {}
    // basic weapons
    public static Weapon shortSword() {
        return new Weapon("Short Sword","A simple steel sword. Reliable in close combat.",
            50,8,0,1);
    }
    public static Weapon greatsword() {
        return new Weapon("Greatsword","Massive two-handed sword for crushing foes.",
            50,12,0,1);
    }
    public static Weapon staff() {
        return new Weapon(
            "Quarterstaff","A basic wooden staff used by spellcasters.",
            50,6,0,2);
        }
    public static Weapon wand() {
        return new Weapon(
            "Wand of Sparks","Casts a small arcane bolt. Better with magic.",
            50,4,0,2);
        }
    // +1 weapons 
    public static Weapon shortSword1() {
        return new Weapon(
            "Short Sword + 1","A quality steel sword.",
            50,10,1,1);
        }
    public static Weapon greatsword1() {
        return new Weapon(
            "Greatsword + 1","Quality two-handed sword.",
            50,14,1,1);
        }
    public static Weapon staff1() {
        return new Weapon(
            "Quarterstaff + 1","Masterfully crafted staff.",
            50,8,1,2);
        }
    public static Weapon wand1() {
        return new Weapon(
            "Wand of Sparks + 1","Has lighting trapped inside.",
            50,8,1,2);
        } 
}