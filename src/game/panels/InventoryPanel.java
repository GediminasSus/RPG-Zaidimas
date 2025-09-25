package game.panels;

import game.mechanics.Item;
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
        if (inventory == null || inventory.isEmpty()) {
            inventoryText.setText("(empty)");
            return;
        }

        // Group items by name
        Map<String, Integer> itemCounts = new HashMap<>();
        for (Item item : inventory) {
            String itemName = item.getName();
            itemCounts.put(itemName, itemCounts.getOrDefault(itemName, 0) + 1);
        }

        // Build display string
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            sb.append(formatItemLine(entry.getKey(), entry.getValue())).append("\n");
        }

        inventoryText.setText(sb.toString());
    }

    private String formatItemLine(String name, int count) {
        return count > 1 ? "- " + name + " x" + count : "- " + name;
    }
}
