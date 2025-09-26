package game.mechanics;

import game.entities.Monster;
import game.entities.PlayerCharacter;
import java.util.*;

public class CombatEngine {
    private int turnIndex = 0;
    private final List<CombatActor> turnOrder = new ArrayList<>();
    private final List<PlayerCharacter> players;
    private final List<Monster> monsters;

    public CombatEngine(List<PlayerCharacter> players, List<Monster> monsters) {
        this.players = players;
        this.monsters = monsters;
        rollInitiative();
    }

    private void rollInitiative() {
        for (PlayerCharacter pc : players) {
            turnOrder.add(new CombatActor(pc, Dice.initiativeRoll(), true));
        }
        for (Monster m : monsters) {
            turnOrder.add(new CombatActor(m, Dice.initiativeRoll(), false));
        }
        turnOrder.sort((a, b) -> Integer.compare(b.initiative(), a.initiative()));
    }

    public CombatActor nextActor() {
        if (turnIndex >= turnOrder.size()) {
            turnIndex = 0;
        }
        return turnOrder.get(turnIndex++);
    }

    public boolean combatEnded() {
        return players.stream().noneMatch(p -> p.getCurrentHP() > 0) ||
               monsters.stream().noneMatch(m -> !m.isDead());
    }

    public List<PlayerCharacter> getPlayers() { return players; }
    public List<Monster> getMonsters() { return monsters; }
    public List<CombatActor> getTurnOrder() { return turnOrder; }
}
