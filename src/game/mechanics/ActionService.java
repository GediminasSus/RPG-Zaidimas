package game.mechanics;

import game.entities.Character;
import game.entities.Monster;
import game.entities.PlayerCharacter;
import game.entities.itmes.Potion;
import game.entities.itmes.Spell;
import game.entities.itmes.Weapon;
import java.util.Objects;
import javax.swing.*;

public class ActionService {
    private ActionService() {}

    public static void attack(Character attacker, Character defender, JTextArea log) {
        Objects.requireNonNull(attacker, "Attacker cannot be null");
        if (defender == null || !defender.isAlive()) return;

        int hitBonus;
        int diceSize;
        int attackPower;

        if (attacker instanceof PlayerCharacter pc) {
            Weapon weapon = pc.getEquippedWeapon();
            if (weapon == null) {
                log.append(pc.getName() + " has no weapon equipped!\n");
                return;
            }
            hitBonus = weapon.getHitBonus();
            diceSize = weapon.getDiceSize();
            attackPower = pc.getAttackPower();
        } else if (attacker instanceof Monster m) {
            hitBonus = m.getHitBonus();
            diceSize = m.getDamageDice();
            attackPower = m.getAttackPower();
        } else {
            throw new IllegalArgumentException("Unsupported attacker type: " + attacker.getClass());
        }

        int roll = Dice.attackRoll(hitBonus);
        log.append(attacker.getName() + " attacks " + defender.getName() + " → roll " + roll + "\n");

        if (roll >= defender.getTotalArmorClass()) {
            int dmg = Dice.damageRoll(diceSize, attackPower);
            defender.takeDamage(dmg);
            log.append("Hit! Deals " + dmg + " damage.\n");
        } else {
            log.append("Misses!\n");
        }
    }

    public static void usePotion(PlayerCharacter pc, Potion potion, JTextArea log) {
        if (potion.restoresHealth()) {
            int restore = Dice.potionRoll(potion.getDiceSize(), potion.getBonus());
            pc.heal(restore);
            log.append(pc.getName() + " uses " + potion.getName() + " and restores " + restore + " HP.\n");
        }
        if (potion.restoresMana()) {
            int restore = Dice.potionRoll(potion.getDiceSize(), potion.getBonus());
            pc.restoreMana(restore);
            log.append(pc.getName() + " uses " + potion.getName() + " and restores " + restore + " MP.\n");
        }
    }

    public static void castSpell(PlayerCharacter pc, Spell spell, Monster target, JTextArea log) {
        if (spell.isHeal()) {
            int heal = Dice.spellRoll(spell.getDiceSize(), pc.getSpellPower());
            pc.heal(heal);
            log.append(pc.getName() + " casts " + spell.getName() + " and restores " + heal + " HP.\n");
            return;
        }

        if (target == null || target.isDead()) return;

        int toHit = Dice.attackRoll(spell.getHitBonus());
        log.append(pc.getName() + " casts " + spell.getName() + " → roll " + toHit + "\n");

        if (toHit >= target.getTotalArmorClass()) {
            int dmg = Dice.damageRoll(spell.getDiceSize(), pc.getAttackPower());
            target.takeDamage(dmg);
            log.append("Hit! Deals " + dmg + " damage.\n");
        } else {
            log.append("Misses!\n");
        }
    }
}
