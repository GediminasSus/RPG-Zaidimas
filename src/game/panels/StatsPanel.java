package game.panels;

import game.entities.PlayerCharacter;
import java.awt.*;
import javax.swing.*;

public class StatsPanel extends JPanel {
    private final JLabel nameLabel = new JLabel();
    private final JLabel classLabel = new JLabel();
    private final JLabel hpLabel = new JLabel();
    private final JLabel mpLabel = new JLabel();
    private final JLabel acLabel = new JLabel();
    private final JLabel apLabel = new JLabel();
    private final JLabel spLabel = new JLabel();
    private final JLabel weaponLabel = new JLabel();
    private final JLabel armorLabel = new JLabel();

    public StatsPanel() {
        setLayout(new GridLayout(0, 1));
        setBorder(BorderFactory.createTitledBorder("Character Stats"));

        Font smallFont = new Font("SansSerif", Font.PLAIN, 11);
        Font boldFont = new Font("SansSerif", Font.BOLD, 11);

        nameLabel.setFont(boldFont);
        classLabel.setFont(boldFont);

        nameLabel.setText("Name: -");
        classLabel.setText("Class: -");
        hpLabel.setText("HP: -");
        mpLabel.setText("MP: -");
        acLabel.setText("AC: -");
        apLabel.setText("AP: -");
        spLabel.setText("SP: -");
        weaponLabel.setText("Weapon: -");
        armorLabel.setText("Armor: -");

        
        for (JLabel lbl : new JLabel[]{hpLabel, mpLabel, acLabel, apLabel, spLabel, weaponLabel, armorLabel}) {
            lbl.setFont(smallFont);
        }

        add(nameLabel);
        add(classLabel);
        add(hpLabel);
        add(mpLabel);
        add(acLabel);
        add(new JSeparator());
        add(apLabel);
        add(spLabel);
        add(new JSeparator());
        add(weaponLabel);
        add(armorLabel);
    }

    public void update(PlayerCharacter pc) {
        nameLabel.setText("Name: " + pc.getName());
        classLabel.setText("Class: " + pc.getClassName());
        hpLabel.setText("HP: " + pc.getCurrentHP() + "/" + pc.getMaxHP());
        mpLabel.setText("MP: " + pc.getCurrentMana() + "/" + pc.getMaxMana());
        acLabel.setText("AC: " + pc.getTotalArmorClass());
        apLabel.setText("AP: " + pc.getAttackPower());
        spLabel.setText("SP: " + pc.getSpellPower());

        weaponLabel.setText("Weapon: " +
                (pc.getEquippedWeapon() != null ? pc.getEquippedWeapon().getName() : "None"));
        armorLabel.setText("Armor: " +
                (pc.getEquippedArmor() != null ? pc.getEquippedArmor().getName() : "None"));
    }

    public void clear() {
        nameLabel.setText("Name: -");
        classLabel.setText("Class: -");
        hpLabel.setText("HP: -");
        mpLabel.setText("MP: -");
        acLabel.setText("AC: -");
        apLabel.setText("AP: -");
        spLabel.setText("SP: -");
        weaponLabel.setText("Weapon: -");
        armorLabel.setText("Armor: -");
    }
}
