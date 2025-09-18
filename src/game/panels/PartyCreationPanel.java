package game.panels;

import game.MainWindow;
import game.mechanics.PlayerCharacter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class PartyCreationPanel extends JFrame {
    private final List<JTextField> nameFields = new ArrayList<>();
    private final List<JComboBox<String>> classSelectors = new ArrayList<>();

    public PartyCreationPanel() {
        setTitle("Create Your Party");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // 4 rows + header
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Name"));
        formPanel.add(new JLabel("Class"));

        String[] classOptions = { "Fighter", "Paladin", "Ranger", "Thief", "Sorcerer", "Priest" };

        for (int i = 0; i < 4; i++) {
            JTextField nameField = new JTextField("Hero " + (i + 1));
            JComboBox<String> classBox = new JComboBox<>(classOptions);
            nameFields.add(nameField);
            classSelectors.add(classBox);
            formPanel.add(nameField);
            formPanel.add(classBox);
        }

        

       

        JButton startBtn = new JButton("Start Game");
        startBtn.addActionListener(e -> {
            List<PlayerCharacter> party = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                String name = nameFields.get(i).getText().trim();
                String cls = (String) classSelectors.get(i).getSelectedItem();
                PlayerCharacter pc = PlayerCharacter.create(name, cls);
                party.add(pc);
            }
            new MainWindow(party); 
            dispose(); 
        });

        add(formPanel, BorderLayout.CENTER);
        add(startBtn, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
