package game.panels;

import java.awt.*;
import javax.swing.*;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("Random Dungeon RPG");
        setSize(1280, 1024);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Dungeon Party RPG", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start New Game");
        
        JButton continueButton = new JButton("Continue");
        JButton saveButton = new JButton("Save Game");
        JButton loadButton = new JButton("Load Game");
        JButton quitButton = new JButton("Quit");



        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*Dimension buttonSize = new Dimension(200, 40)
        continueButton.setPreferredSize(buttonSize)
        startButton.setPreferredSize(buttonSize)
        saveButton.setPreferredSize(buttonSize)
        loadButton.setPreferredSize(buttonSize)
        quitButton.setPreferredSize(buttonSize)

        continueButton.setMaximumSize(new Dimension(200, 40))
        continueButton.setMinimumSize(new Dimension(200, 40))
        continueButton.setPreferredSize(new Dimension(200, 40))*/

        

        panel.add(Box.createVerticalStrut(240));
        panel.add(title);
        panel.add(Box.createVerticalStrut(30));
        panel.add(continueButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(saveButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(loadButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(quitButton);

        add(panel);

        // Button actions


        startButton.addActionListener(e -> {
            setContentPane(new PartyCreationPanel());
            revalidate();
            repaint();
        });

        loadButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Load functionality not yet implemented.");
        });

        continueButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Continue functionality not yet implemented.");
        });

        saveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Save functionality not yet implemented.");
        });

        quitButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StartScreen().setVisible(true);
        });
    }
}
