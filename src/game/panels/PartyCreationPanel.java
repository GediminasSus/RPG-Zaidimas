package game.panels;

import game.MainWindow;
import game.mechanics.PlayerCharacter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class PartyCreationPanel extends JPanel {
    private static final int PARTY_SIZE = 4;
    private final List<JTextField> nameFields = new ArrayList<>();
    private final List<JComboBox<String>> classSelectors = new ArrayList<>();

    private static final String[] CLASS_OPTIONS = { "Fighter", "Mage" };

    public PartyCreationPanel(JFrame parentFrame) {
        setLayout(new GridBagLayout()); // centers everything

        // --- Inner form box ---
        JPanel formBox = new JPanel(new BorderLayout());
        formBox.setPreferredSize(new Dimension(400, 300)); // fixed size box
        formBox.setBorder(BorderFactory.createTitledBorder("Create Your Party"));

        // --- Form panel ---
        JPanel formPanel = new JPanel(new GridLayout(PARTY_SIZE + 1, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Headers
        formPanel.add(new JLabel("Name"));
        formPanel.add(new JLabel("Class"));

        // Inputs
        for (int i = 0; i < PARTY_SIZE; i++) {
            JTextField nameField = new JTextField("Hero " + (i + 1));
            JComboBox<String> classBox = new JComboBox<>(CLASS_OPTIONS);
            nameFields.add(nameField);
            classSelectors.add(classBox);
            formPanel.add(nameField);
            formPanel.add(classBox);
        }

        // --- Button panel ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startBtn = new JButton("Start Game");
        JButton backBtn = new JButton("Back");

        buttonPanel.add(startBtn);
        buttonPanel.add(backBtn);

        // Add form and buttons into box
        formBox.add(formPanel, BorderLayout.CENTER);
        formBox.add(buttonPanel, BorderLayout.SOUTH);

        // Add to center of main panel
        add(formBox);

        // --- Actions ---
        startBtn.addActionListener(e -> startGame(parentFrame));
        backBtn.addActionListener(e -> {
            parentFrame.setContentPane(new StartScreen().getContentPane());
            parentFrame.revalidate();
            parentFrame.repaint();
        });
    }

    private void startGame(JFrame parentFrame) {
        List<PlayerCharacter> party = new ArrayList<>();
        for (int i = 0; i < PARTY_SIZE; i++) {
            String name = nameFields.get(i).getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All characters must have a name!");
                return;
            }

            String cls = (String) classSelectors.get(i).getSelectedItem();
            int clsId = mapClassNameToId(cls);

            PlayerCharacter pc = PlayerCharacter.create(name, clsId);
            party.add(pc);
        }

        new MainWindow(party);
        parentFrame.dispose();
    }

    private int mapClassNameToId(String className) {
        return switch (className.toLowerCase()) {
            case "fighter" -> 1;
            case "mage" -> 2;
            default -> throw new IllegalArgumentException("Unknown class: " + className);
        };
    }
}
