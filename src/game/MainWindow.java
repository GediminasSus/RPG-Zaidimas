package game;

import game.mechanics.*;
import game.panels.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;


public class MainWindow extends JFrame {
    private JPanel menuPanel;
    private DungeonViewer dungeonViewerPanel;
    private StatsContainerPanel statsPanel;
    private PlayerParty party;
    private InventoryPanel inventoryPanel;
    private JTextArea combatLog;
    
    public MainWindow(List<PlayerCharacter> partyMembers) {
        setTitle("Dungeon Game");
        setLayout(new BorderLayout());
        
        
    
        party = new PlayerParty(partyMembers); 

        Dungeon dungeon = new Dungeon(50, 30);
        combatLog = new JTextArea();
        dungeonViewerPanel = new DungeonViewer(dungeon, combatLog, party, this); 
    
        //  Map Panel
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBorder(BorderFactory.createTitledBorder("Map"));
        mapPanel.add(dungeonViewerPanel, BorderLayout.CENTER);
    
        //  Stats Panel 
        statsPanel = new StatsContainerPanel(party.getMembers());
    
        //  Inventory Panel 
        inventoryPanel = new InventoryPanel();
        inventoryPanel.displayInventory(party.getPartyInventory());
        inventoryPanel.setGold(party.getGold());
    
        //  Combat Panel 
        combatLog.setEditable(false);
        combatLog.setLineWrap(true);
        combatLog.setWrapStyleWord(true);
        JScrollPane combatScroll = new JScrollPane(combatLog);
        combatScroll.setBorder(BorderFactory.createTitledBorder("Combat / Dialog"));
    
        //  Split Panes 
        JSplitPane topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mapPanel, statsPanel);
        topSplit.setResizeWeight(0.7); // 75%  map, 25%  stats
    
        JSplitPane bottomSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, combatScroll, inventoryPanel);
        bottomSplit.setResizeWeight(0.7); // 70% combat, 30% inventory
    
        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topSplit, bottomSplit);
        verticalSplit.setResizeWeight(0.5); // 60% top, 40% bottom
    
        add(verticalSplit, BorderLayout.CENTER);
    
        //  Menu Panel 
        menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        updateMenuForExploration(); 
        add(menuPanel, BorderLayout.PAGE_END);
        

        // ratio map to stats
        dungeonViewerPanel.setPreferredSize(new Dimension(800, 400)); // bigger than stats
        statsPanel.setPreferredSize(new Dimension(400, 400));        
    
        //  Final window setup 
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
            "Return to main menu? Unsaved progress will be lost.",
            "Return to Menu",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Close game window
             SwingUtilities.invokeLater(() -> {
            StartScreen startScreen = new StartScreen();
            startScreen.setVisible(true); // ← make it visible!
        });
        }   
    }

    public void updateMenuForExploration() {
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
        combat.playerFinishedTurn();   // ✅ now works
    });

    spellBtn.addActionListener(e -> {
        combat.showSpellDialog(pc);    // ✅ instance method
        combat.playerFinishedTurn();
    });

    potionBtn.addActionListener(e -> {
        combat.showPotionDialog(pc);   // ✅ instance method
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

}
