package game.mechanics;


import game.MainWindow;
import java.util.*;
import javax.swing.*;

public class CombatSystem {
    private static int turnIndex = 0;
    private static List<CombatActor> turnOrder;
    private static List<PlayerCharacter> players;
    private static List<Monster> monsters;
    private static JTextArea combatLog;
    private static MainWindow uiRef; 

    record CombatActor(Object actor, int initiative, boolean isPlayer) {}
    // turn order
    public static void run(List<PlayerCharacter> pcs, List<Monster> ms, JTextArea log, MainWindow ui) {
        players = pcs;
        monsters = ms;
        combatLog = log;
        uiRef = ui;

        
        turnOrder = new ArrayList<>();
        // initiative roll
        for (PlayerCharacter pc : players) {
            int roll = Dice.roll(1, 20, pc.getModifier("DEX"));
            turnOrder.add(new CombatActor(pc, roll, true));
            combatLog.append(pc.getName() + " rolls initiative: " + roll + "\n");
        }

        for (Monster m : monsters) {
            int roll = Dice.roll(1, 20);
            turnOrder.add(new CombatActor(m, roll, false));
            combatLog.append(m.getName() + " rolls initiative: " + roll + "\n");
        }

        turnOrder.sort((a, b) -> Integer.compare(b.initiative(), a.initiative()));
        combatLog.append("=== Combat Begins ===\n");

        turnIndex = 0;
        nextCombatTurn(); // start loop
    }
    
    public static void nextCombatTurn() {
        if (players.stream().noneMatch(p -> p.getCurrentHP() > 0)|| monsters.stream().noneMatch(m -> !m.isDead())) {
    
        combatLog.append("\n=== Combat Ends ===\n");
    
        if (uiRef != null) {
            uiRef.updateMenuForExploration(); // Restore original menu
            uiRef.enableDungeonControls(true); //  re-enable movement
        }

    return;
}

        if (turnIndex >= turnOrder.size()) turnIndex = 0;
        // player or monster turn
        CombatActor actor = turnOrder.get(turnIndex++);
        if (actor.isPlayer()) {
            PlayerCharacter pc = (PlayerCharacter) actor.actor();
            if (pc.getCurrentHP() <= 0) {
                nextCombatTurn();
                return;
            }

            combatLog.append("\n" + pc.getName() + "'s turn.\n");
            uiRef.updateMenuForCombat(pc, monsters, combatLog);
        } else {
            Monster m = (Monster) actor.actor();
            if (m.isDead()) {
                nextCombatTurn();
                return;
            }

            PlayerCharacter target = players.stream()
                .filter(p -> p.getCurrentHP() > 0)
                .findAny().orElse(null);
            if (target == null) return;

            // monsters attack roll
            int roll = Dice.roll(1, 20, m.getHitBonus());

            combatLog.append(m.getName() + " attacks " + target.getName() + " → roll " + roll + "\n");

            if (roll >= target.getTotalArmorClass()) {
                int dmg = Dice.roll(m.getNumDice(), m.getDiceSize(), m.getBonusDamage());
                target.playerTakeDamage(dmg);
                combatLog.append("Hit! Deals " + dmg + " damage.\n");
            } else {
                combatLog.append("Misses!\n");
            }

            SwingUtilities.invokeLater(CombatSystem::nextCombatTurn);
        }
    }

    public static void playerFinishedTurn() {
        SwingUtilities.invokeLater(CombatSystem::nextCombatTurn);
    }


    

    public static void performAttack(PlayerCharacter pc, List<Monster> monsters, JTextArea combatLog) {
        
        Monster target = monsters.stream().filter(m -> !m.isDead()).findFirst().orElse(null);
        if (target == null) return;
    
        Weapon weapon = pc.getEquippedWeapon();
        String stat = weapon.getScalingStat();
        int diceSize = weapon.getDiceSize();
        int numDice = weapon.getNumDice();
        int hitBonus = weapon.getHitBonus() + pc.getModifier(stat);
        int roll = Dice.roll(1, 20, hitBonus);
    
        combatLog.append(pc.getName() + " attacks " + target.getName() + " → roll " + roll + "\n");
    
        if (roll >= target.getArmorClass()) {
            int dmg = Dice.roll(numDice, diceSize, pc.getModifier(stat));
            target.takeDamage(dmg);
            combatLog.append("Hit! Deals " + dmg + " damage.\n");
        } else {
            combatLog.append("Misses!\n");
        }
    }

    public static void showPotionDialog(PlayerCharacter pc, JTextArea combatLog) {
        List<Item> potions = pc.getInventory().stream()
            .filter(i -> i instanceof Potion).toList();
        if (potions.isEmpty()) {
            combatLog.append("No potions!\n");
            return;
        }
    
        String[] options = potions.stream().map(Item::getName).toArray(String[]::new);
        String selected = (String) JOptionPane.showInputDialog(
            null, "Choose a potion:", "Use Potion", JOptionPane.PLAIN_MESSAGE, null, options, options[0]
        );
    
        if (selected == null) return;
    
        Potion potion = (Potion) potions.stream().filter(p -> p.getName().equals(selected)).findFirst().orElse(null);
        if (potion == null) return;
    
        pc.heal(Dice.roll(potion.getNumDice(), potion.getDiceSize(), potion.getbBonus()));
        pc.restoreMana(Dice.roll(potion.getNumDice(), potion.getDiceSize(), potion.getbBonus()));
        pc.getInventory().remove(potion);
    
        combatLog.append(pc.getName() + " uses " + potion.getName() + ".\n");
    }

    public static void showSpellDialog(PlayerCharacter pc, List<Monster> monsters, JTextArea combatLog) {
        List<Spell> spells = pc.getKnownSpells();
        if (spells.isEmpty()) {
            combatLog.append("No spells known.\n");
            return;
        }
    
        String[] options = spells.stream().map(Spell::getName).toArray(String[]::new);
        String selected = (String) JOptionPane.showInputDialog(
            null, "Choose a spell:", "Cast Spell", JOptionPane.PLAIN_MESSAGE, null, options, options[0]
        );
    
        if (selected == null) return;
    
        Spell spell = spells.stream().filter(s -> s.getName().equals(selected)).findFirst().orElse(null);
        if (spell == null || pc.getCurrentMana() < spell.getManaCost()) {
            combatLog.append("Not enough mana!\n");
            return;
        }
    
        pc.setCurrentMana(pc.getCurrentMana() - spell.getManaCost());
    
        if (spell.isHeal()) {
            int heal = Dice.roll(spell.getNumDice(), spell.getDiceSize(), spell.getBonus());
            pc.heal(heal);
            combatLog.append(pc.getName() + " casts " + spell.getName() + " and restores " + heal + " HP.\n");
            return;
        }
    
        Monster target = monsters.stream().filter(m -> !m.isDead()).findFirst().orElse(null);
        if (target == null) return;
    
      
    
        if (spell.isBoundToWeapon()) {
            Weapon weapon = pc.getEquippedWeapon();
            int toHit = Dice.roll(1, 20, weapon.getHitBonus()) + pc.getModifier(weapon.getScalingStat());
            combatLog.append(pc.getName() + " swings weapon with " + spell.getName() + " → roll " + toHit + "\n");
    
            if (toHit >= target.getArmorClass()) {
                int weaponDmg = Dice.roll(weapon.getNumDice(), weapon.getDiceSize(), pc.getModifier(weapon.getScalingStat()));
                int spellDmg = Dice.roll(spell.getNumDice(), spell.getDiceSize(), spell.getBonus());
                int totalDmg = weaponDmg + spellDmg;
                target.takeDamage(totalDmg);
                combatLog.append("Hit! Deals " + totalDmg + " damage (" + weaponDmg + " weapon + " + spellDmg + " spell).\n");
            } else {
                combatLog.append("Misses!\n");
            }
    
        } else {
            int toHit = Dice.roll(1, 20, pc.getModifier(spell.getScalingStat()));
            combatLog.append(pc.getName() + " casts " + spell.getName() + " → roll " + toHit + "\n");
    
            if (toHit >= target.getArmorClass()) {
                int dmg = Dice.roll(spell.getNumDice(), spell.getDiceSize(), spell.getBonus());
                target.takeDamage(dmg);
                combatLog.append("Hit! Deals " + dmg + " damage.\n");
            } else {
                combatLog.append("Misses!\n");
            }
        }
    }
    
    
    

    
}
