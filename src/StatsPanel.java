import java.awt.*;
import javax.swing.*;

public class StatsPanel extends JPanel {
    private final JLabel nameLabel = new JLabel();
    private final JLabel classLabel = new JLabel();
    private final JLabel hpLabel = new JLabel();
    private final JLabel mpLabel = new JLabel();
    private final JLabel acLabel = new JLabel();
    private final JLabel strLabel = new JLabel();
    private final JLabel dexLabel = new JLabel();
    private final JLabel conLabel = new JLabel();
    private final JLabel intLabel = new JLabel();
    private final JLabel wisLabel = new JLabel();
    private final JLabel chaLabel = new JLabel();
    private final JLabel weaponLabel = new JLabel();
    private final JLabel armorLabel = new JLabel();

    public StatsPanel() {
        setLayout(new GridLayout(0, 1));
        setBorder(BorderFactory.createTitledBorder("Character Stats"));

        add(nameLabel);
        add(classLabel);
        add(hpLabel);
        add(mpLabel);
        add(acLabel);
        add(new JSeparator());
        add(strLabel);
        add(dexLabel);
        add(conLabel);
        add(intLabel);
        add(wisLabel);
        add(chaLabel);
        add(new JSeparator());
        add(weaponLabel);
        add(armorLabel);
    }

    public void displayCharacter(PlayerCharacter pc) {
        nameLabel.setText("Name: " + pc.getName());
        classLabel.setText("Class: " + pc.getCharacterClass());
        hpLabel.setText("HP: " + pc.getCurrentHP() + "/" + pc.getMaxHP());
        mpLabel.setText("MP: " + pc.getCurrentMana() + "/" + pc.getMaxMana());
        acLabel.setText("AC: " + pc.getTotalArmorClass());

        strLabel.setText("STR: " + pc.getStrength());
        dexLabel.setText("DEX: " + pc.getDexterity());
        conLabel.setText("CON: " + pc.getConstitution());
        intLabel.setText("INT: " + pc.getIntelligence());
        wisLabel.setText("WIS: " + pc.getWisdom());
        chaLabel.setText("CHA: " + pc.getCharisma());

        weaponLabel.setText("Weapon: " +
            (pc.getEquippedWeapon() != null ? pc.getEquippedWeapon().getName() : "None"));
        armorLabel.setText("Armor: " +
            (pc.getEquippedArmor() != null ? pc.getEquippedArmor().getName() : "None"));
    }
}
