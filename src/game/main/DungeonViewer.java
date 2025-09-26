package game.main;

import game.entities.Monster;
import game.entities.itmes.lists.MonsterList;
import game.mechanics.CombatSystem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class DungeonViewer extends JPanel {
    private final char[][] map;
    private final int[] playerPos = new int[2];
    private final Map<Point, Monster> monsters = new HashMap<>();
    private static final int TILE_SIZE = 16; 
    private final JTextArea combatLog;
    private final PlayerParty party;
    private final MainWindow mainWindow;
    private boolean movementEnabled = true;
    private CombatSystem currentCombat; 

    public DungeonViewer(Dungeon dungeon, JTextArea combatLog, PlayerParty party, MainWindow mainWindow) {
        this.map = dungeon.getMap();
        this.combatLog = combatLog;
        this.playerPos[0] = dungeon.getPlayerX();
        this.playerPos[1] = dungeon.getPlayerY();
        this.party = party;
        this.mainWindow = mainWindow;

        setFocusable(true);
        requestFocusInWindow();
        setupKeyBindings();

        for (Position pos : dungeon.getMonsterPositions()) {
            Point p = new Point(pos.x(), pos.y());
            monsters.put(p, MonsterList.randomMonster());
        }
    }

    private void setupKeyBindings() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("W"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("S"), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke("A"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("D"), "moveRight");

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { movePlayer(0, -1); }
        });
        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { movePlayer(0, 1); }
        });
        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { movePlayer(-1, 0); }
        });
        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { movePlayer(1, 0); }
        });
    }

    private void movePlayer(int dx, int dy) {
        if (!movementEnabled) return;

        int newX = playerPos[0] + dx;
        int newY = playerPos[1] + dy;

        if (newY >= 0 && newY < map.length && newX >= 0 && newX < map[0].length && map[newY][newX] == '.') {
            playerPos[0] = newX;
            playerPos[1] = newY;
            repaint();

            // Check for monsters
            Point pos = new Point(newX, newY);
            if (monsters.containsKey(pos)) {
                List<Monster> monstersInRoom = List.of(monsters.get(pos));
                monsters.remove(pos);
                setMovementEnabled(false);
                currentCombat = new CombatSystem(party.getMembers(), monstersInRoom, combatLog, mainWindow);
                currentCombat.run();
            }
        }
    }

    public void setMovementEnabled(boolean enabled) {
        this.movementEnabled = enabled;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int offsetX = (getWidth() - map[0].length * TILE_SIZE) / 2;
        int offsetY = (getHeight() - map.length * TILE_SIZE) / 2;

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                Point current = new Point(x, y);
                char tile = map[y][x];

                if (x == playerPos[0] && y == playerPos[1]) {
                    g.setColor(Color.RED); // player
                } else if (monsters.containsKey(current)) {
                    g.setColor(Color.GREEN); // monster
                } else if (tile == '#') {
                    g.setColor(Color.DARK_GRAY); // wall
                } else {
                    g.setColor(Color.LIGHT_GRAY); // floor
                }

                g.fillRect(offsetX + x * TILE_SIZE, offsetY + y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
