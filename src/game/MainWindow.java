package game;

import game.mechanics.*;
import game.panels.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;


public class MainWindow extends JFrame {
    private JPanel menuPanel;
    private DungeonViewer dungeonViewerPanel;
    
    public MainWindow(List<PlayerCharacter> partyMembers) {
        setTitle("Dungeon Game");
        setLayout(new BorderLayout());
    
        //public void startGameWithParty(PlayerParty party) {
        //getContentPane().removeAll();

       /*  PlayerParty party = new PlayerParty();
        party.createCharacters(); */
    
        PlayerParty party = new PlayerParty(partyMembers); 

        Dungeon dungeon = new Dungeon(50, 30);
        JTextArea combatLog = new JTextArea();
        dungeonViewerPanel = new DungeonViewer(dungeon, combatLog, party, this); 
    
        //  Map Panel
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBorder(BorderFactory.createTitledBorder("Map"));
        mapPanel.add(dungeonViewerPanel, BorderLayout.CENTER);
    
        //  Stats Panel 
        StatsContainerPanel statsPanel = new StatsContainerPanel(party.getMembers());
    
        //  Inventory Panel 
        InventoryPanel inventoryPanel = new InventoryPanel();
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

    public void updateMenuForExploration() {
        menuPanel.removeAll();
        menuPanel.add(new JButton("Menu"));
        menuPanel.add(new JButton("Options"));
        menuPanel.add(new JButton("Save"));
        menuPanel.add(new JButton("Load"));
        menuPanel.add(new JButton("Quit"));
        menuPanel.revalidate();
        menuPanel.repaint();
    }

    public void updateMenuForCombat(PlayerCharacter pc, List<Monster> monsters, JTextArea combatLog) {
        menuPanel.removeAll();
    
        JButton attackBtn = new JButton("Attack");
        JButton spellBtn = new JButton("Cast Spell");
        JButton potionBtn = new JButton("Use Potion");
    
        attackBtn.addActionListener(e -> {
            CombatSystem.performAttack(pc, monsters, combatLog);
            CombatSystem.playerFinishedTurn();
        });
    
        spellBtn.addActionListener(e -> {
            CombatSystem.showSpellDialog(pc, monsters, combatLog);
            CombatSystem.playerFinishedTurn();
        });
    
        potionBtn.addActionListener(e -> {
            CombatSystem.showPotionDialog(pc, combatLog);
            CombatSystem.playerFinishedTurn();
        });
    
        menuPanel.add(attackBtn);
        menuPanel.add(spellBtn);
        menuPanel.add(potionBtn);
        menuPanel.revalidate();
        menuPanel.repaint();
    }

    public void enableDungeonControls(boolean enable) {
        dungeonViewerPanel.setKeyListenerEnabled(enable);
    }


    
   // public static void main(String[] args) {
   //     SwingUtilities.invokeLater(MainWindow::new);
   //}
}
