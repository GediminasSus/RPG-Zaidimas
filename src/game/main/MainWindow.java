package game.main;

import game.entities.Monster;
import game.entities.PlayerCharacter;
import game.mechanics.*;
import game.panels.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;


public class MainWindow extends JFrame {
    private final JPanel menuPanel;
    private final DungeonViewer dungeonViewerPanel;
    private final StatsContainerPanel statsPanel;
    private PlayerParty party;
    private final InventoryPanel inventoryPanel;
    private final JTextArea combatLog;
    
    public MainWindow(List<PlayerCharacter> partyMembers) {
        setTitle("Dungeon Game");
        setLayout(new BorderLayout());
        
        
    
        party = new PlayerParty(partyMembers); 

        Dungeon dungeon = new Dungeon(50, 30);
        combatLog = new JTextArea();
        dungeonViewerPanel = new DungeonViewer(dungeon, combatLog, party, this); 
    
        //  Map 
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBorder(BorderFactory.createTitledBorder("Map"));
        mapPanel.add(dungeonViewerPanel, BorderLayout.CENTER);
    
        //  Stats 
        statsPanel = new StatsContainerPanel(party.getMembers());
    
        //  Inventory 
        inventoryPanel = new InventoryPanel();
        inventoryPanel.displayInventory(party.getPartyInventory());
        inventoryPanel.setGold(party.getGold());
    
        //  Combat 
        combatLog.setEditable(false);
        combatLog.setLineWrap(true);
        combatLog.setWrapStyleWord(true);
        JScrollPane combatScroll = new JScrollPane(combatLog);
        combatScroll.setBorder(BorderFactory.createTitledBorder("Combat / Dialog"));
    
        //  Split Panes 
        JSplitPane topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mapPanel, statsPanel);
        topSplit.setResizeWeight(0.7); // 70%  map, 30%  stats
    
        JSplitPane bottomSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, combatScroll, inventoryPanel);
        bottomSplit.setResizeWeight(0.7); // 70% combat, 30% inventory
    
        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topSplit, bottomSplit);
        verticalSplit.setResizeWeight(0.5); // 50% top, 50% bottom
    
        add(verticalSplit, BorderLayout.CENTER);
    
        //  Menu 
        menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        updateMenuForExploration(); 
        add(menuPanel, BorderLayout.PAGE_END);
        

        // ratio map to stats
        dungeonViewerPanel.setPreferredSize(new Dimension(800, 400)); 
        statsPanel.setPreferredSize(new Dimension(400, 400));        
    
        //  Final window 
        setPreferredSize(new Dimension(1280, 1024));
        pack();                         
        setLocationRelativeTo(null);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    
        dungeonViewerPanel.setFocusable(true);
        dungeonViewerPanel.requestFocusInWindow();

        revalidate();
        repaint();
    }

    private void returnToMainMenu() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Return to main menu? Progress will be lost.",
            "Return to Menu",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Close 
            SwingUtilities.invokeLater(() -> {
                StartScreen startScreen = new StartScreen();
                startScreen.setVisible(true); 
            });
        }   
    }

    public final void updateMenuForExploration() {
        menuPanel.removeAll();

        JButton menuBtn = new JButton("Menu");
        menuBtn.addActionListener(e -> returnToMainMenu());
        menuPanel.add(menuBtn);

        menuPanel.revalidate();
        menuPanel.repaint();
    }

    public void updateMenuForCombat(PlayerCharacter pc, List<Monster> monsters, JTextArea combatLog, CombatSystem combat) {
        menuPanel.removeAll();

        JButton attackBtn = new JButton("Attack");
        JButton spellBtn = new JButton("Cast Spell");
        JButton potionBtn = new JButton("Use Potion");

        attackBtn.addActionListener(e -> {
            Monster target = monsters.stream()
                .filter(m -> !m.isDead())
                .findFirst()
                .orElse(null);

            if (target != null) {
                ActionService.attack(pc, target, combatLog);
            }
            combat.playerFinishedTurn();   
        });

        spellBtn.addActionListener(e -> {
            combat.showSpellDialog(pc);    
            combat.playerFinishedTurn();
        });

        potionBtn.addActionListener(e -> {
            combat.showPotionDialog(pc);   
            combat.playerFinishedTurn();
        });

        menuPanel.add(attackBtn);
        menuPanel.add(spellBtn);
        menuPanel.add(potionBtn);
        menuPanel.revalidate();
        menuPanel.repaint();
    }


    public DungeonViewer getDungeonViewer() {
        return dungeonViewerPanel;
    }

    public void refreshStats() {
        statsPanel.refreshStats(party.getMembers());
    }

    public PlayerParty getParty() {
        return party;
    }

    public void refreshInventory() {
        inventoryPanel.displayInventory(party.getPartyInventory());
        inventoryPanel.setGold(party.getGold());
    }

    public static void launch(List<PlayerCharacter> party) {
        SwingUtilities.invokeLater(() -> new MainWindow(party).setVisible(true));
    }

}
