package game.mechanics;

import game.entities.Monster;
import game.entities.PlayerCharacter;
import game.entities.itmes.Item;
import game.entities.itmes.Potion;
import game.entities.itmes.Spell;
import game.main.MainWindow;
import java.util.List;
import javax.swing.*;

public class CombatSystem {
    private final CombatEngine engine;
    private final JTextArea combatLog;
    private final MainWindow uiRef;

    public CombatSystem(List<PlayerCharacter> pcs, List<Monster> ms, JTextArea log, MainWindow ui) {
        this.engine = new CombatEngine(pcs, ms);
        this.combatLog = log;
        this.uiRef = ui;
    }

    // Start combat
    public void run() {
        for (CombatActor actor : engine.getTurnOrder()) {
            String name = actor.isPlayer()
                    ? ((PlayerCharacter) actor.actor()).getName()
                    : ((Monster) actor.actor()).getName();
            combatLog.append(name + " rolls initiative: " + actor.initiative() + "\n");
        }
        combatLog.append("=== Combat Begins ===\n");
        nextCombatTurn();
    }

    // Step to next turn
    public void nextCombatTurn() {
        if (engine.combatEnded()) {
            endCombat();
            return;
        }

        CombatActor actor = engine.nextActor();
        if (actor.isPlayer()) {
            handlePlayerTurn((PlayerCharacter) actor.actor());
        } else {
            handleMonsterTurn((Monster) actor.actor());
        }
    }

    private void endCombat() {
        combatLog.append("\n=== Combat Ends ===\n");
        uiRef.updateMenuForExploration();
        uiRef.getDungeonViewer().setMovementEnabled(true);
    }

    private void handlePlayerTurn(PlayerCharacter pc) {
        if (pc.getCurrentHP() <= 0) {
            nextCombatTurn();
            return;
        }
        combatLog.append("\n" + pc.getName() + "'s turn.\n");
        uiRef.updateMenuForCombat(pc, engine.getMonsters(), combatLog, this);
    }

    private void handleMonsterTurn(Monster m) {
        if (m.isDead()) {
            nextCombatTurn();
            return;
        }

        PlayerCharacter target = engine.getPlayers().stream()
                .filter(p -> p.getCurrentHP() > 0)
                .findAny()
                .orElse(null);

        if (target == null) return;

        ActionService.attack(m, target, combatLog);
        uiRef.refreshStats();
        SwingUtilities.invokeLater(this::nextCombatTurn);
    }

    public void playerFinishedTurn() {
        SwingUtilities.invokeLater(this::nextCombatTurn);
    }

    // Potion dialog
    public void showPotionDialog(PlayerCharacter pc) {
        List<Item> potions = uiRef.getParty().getPartyInventory().stream()
                .filter(i -> i instanceof Potion)
                .toList();

        if (potions.isEmpty()) {
            combatLog.append("No potions in party inventory!\n");
            return;
        }

        String[] options = potions.stream().map(Item::getName).toArray(String[]::new);
        String selected = (String) JOptionPane.showInputDialog(
                null, "Choose a potion:", "Use Potion",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]
        );
        if (selected == null) return;

        Potion potion = (Potion) potions.stream()
                .filter(p -> p.getName().equals(selected))
                .findFirst()
                .orElse(null);

        if (potion != null) {
            ActionService.usePotion(pc, potion, combatLog);
            uiRef.getParty().getPartyInventory().remove(potion);
            uiRef.refreshStats();
            uiRef.refreshInventory();
        }
    }

    // Spell dialog
    public void showSpellDialog(PlayerCharacter pc) {
        List<Spell> spells = pc.getKnownSpells();
        if (spells.isEmpty()) {
            combatLog.append("No spells known.\n");
            return;
        }

        String[] options = spells.stream()
                .map(s -> s.getName() + " (Cost: " + s.getManaCost() + " MP)")
                .toArray(String[]::new);

        String selected = (String) JOptionPane.showInputDialog(
                null, "Choose a spell:", "Cast Spell",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]
        );
        if (selected == null) return;

        String spellName = selected.split(" \\(Cost:")[0];
        Spell chosen = spells.stream()
                .filter(s -> s.getName().equals(spellName))
                .findFirst()
                .orElse(null);

        if (chosen == null || pc.getCurrentMana() < chosen.getManaCost()) {
            combatLog.append("Not enough mana!\n");
            return;
        }

        pc.setCurrentMana(pc.getCurrentMana() - chosen.getManaCost());
        uiRef.refreshStats();

        if (chosen.isHeal()) {
            ActionService.castSpell(pc, chosen, null, combatLog);
            uiRef.refreshStats();
        } else {
            Monster target = engine.getMonsters().stream()
                    .filter(m -> !m.isDead())
                    .findFirst()
                    .orElse(null);
            if (target != null) {
                ActionService.castSpell(pc, chosen, target, combatLog);
            }
        }
    }
}
