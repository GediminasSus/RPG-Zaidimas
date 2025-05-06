import java.awt.*;
import java.util.List;
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

    public void displayInventory(List<Item> items) {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append("- ").append(item.getName());
            if (item instanceof Weapon weapon) {
                sb.append(" [Weapon, +").append(weapon.getHitBonus()).append(" hit]");
            } else if (item instanceof Armor armor) {
                sb.append(" [Armor, +").append(armor.getAcBonus()).append(" AC]");
            } else if (item instanceof Potion potion) {
                sb.append(" [Potion]");
            }
            sb.append("\n");
        }
        inventoryText.setText(sb.toString());
    }
}
