package game.panels;

import game.mechanics.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;


public class InventoryPanel extends JPanel {
    private final JTextArea inventoryText;
    private final JLabel goldLabel = new JLabel("Gold: 0");

    public InventoryPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Inventory"));

        goldLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(goldLabel, BorderLayout.NORTH);

        inventoryText = new JTextArea();
        inventoryText.setEditable(false);
        add(new JScrollPane(inventoryText), BorderLayout.CENTER);
    }

    public void setGold(int gold) {
        goldLabel.setText("Gold: " + gold);
    }

    public void displayInventory(List<Item> inventory) {
        StringBuilder sb = new StringBuilder();
        // Group items by name
        Map<String, Integer> itemCounts = new HashMap<>();
        for (Item item : inventory) {
            String itemName = item.getName();
            itemCounts.put(itemName, itemCounts.getOrDefault(itemName, 0) + 1);
        }
        
      /*  for (Item item : inventory) {
            sb.append("- ").append(item.getName());
            if (item instanceof Weapon weapon) {
                sb.append(" [Weapon, +").append(weapon.getHitBonus()).append(" hit]");
            } else if (item instanceof Armor armor) {
                sb.append(" [Armor, +").append(armor.getAcBonus()).append(" AC]");
            } else if (item instanceof Potion ) {
                sb.append(" [Potion]");
            }
            sb.append("\n");
        }*/

        // Build display string
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String line = "- " + entry.getKey();
            if (entry.getValue() > 1) {
                line += " x" + entry.getValue();
            }
            sb.append(line).append("\n");
        }
        inventoryText.setText(sb.toString());
    }
}
