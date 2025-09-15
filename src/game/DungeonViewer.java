package game;
import game.lists.MonsterList;
import game.mechanics.CombatSystem;
import game.mechanics.Monster;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class DungeonViewer extends JPanel {
    private final char[][] map;
    private final int[] playerPos = new int[2];
    private final Map<Point, Monster> monsters = new HashMap<>();
    private final int tileSize = 16;
    private JTextArea combatLog;
    private final PlayerParty party;
    private final MainWindow mainWindow;
    private boolean movementEnabled = true;

    public DungeonViewer(Dungeon dungeon, JTextArea combatLog, PlayerParty party, MainWindow mainWindow) {
        this.map = dungeon.getMap();
        this.combatLog = combatLog;
        this.playerPos[0] = dungeon.getPlayerX();
        this.playerPos[1] = dungeon.getPlayerY();
        this.party = party;
        this.mainWindow = mainWindow;

        setFocusable(true);
        requestFocusInWindow();

        // Load monsters 
        for (int[] pos : dungeon.getMonsterPositions()) {
            Point p = new Point(pos[0], pos[1]);
            monsters.put(p, MonsterList.goblin());
        }

        //  movement 
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!movementEnabled) return;
                int dx = 0, dy = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> dy = -1;
                    case KeyEvent.VK_S -> dy = 1;
                    case KeyEvent.VK_A -> dx = -1;
                    case KeyEvent.VK_D -> dx = 1;
                }

                int newX = playerPos[0] + dx;
                int newY = playerPos[1] + dy;
                Point dest = new Point(newX, newY);

                if (monsters.containsKey(dest)) {
                    Monster monster = monsters.get(dest);
                    List<Monster> monstersInRoom = List.of(monster); 
                    CombatSystem.run(party.getMembers(), monstersInRoom, combatLog, mainWindow);
                    monsters.remove(dest);
                    map[newY][newX] = '.';
                    repaint();
                    return;
                }

                if (newY >= 0 && newY < map.length && newX >= 0 && newX < map[0].length && map[newY][newX] == '.') {
                    playerPos[0] = newX;
                    playerPos[1] = newY;
                    repaint();
                }
            }
        });
    }

    
    public void setKeyListenerEnabled(boolean enabled) {
    this.movementEnabled = enabled;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                char tile = map[y][x];
                if (x == playerPos[0] && y == playerPos[1]) {
                    g.setColor(Color.RED);
                } else if (tile == '#') {
                    g.setColor(Color.DARK_GRAY);
                } else if (tile == 'M') {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }

    

    
}
