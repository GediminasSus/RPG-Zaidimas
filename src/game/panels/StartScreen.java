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
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start New Game");
        JButton quitButton = new JButton("Quit");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(240));
        panel.add(title);
        panel.add(Box.createVerticalStrut(60));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(quitButton);

        add(panel);

        // Actions
        startButton.addActionListener(e -> {
            setContentPane(new PartyCreationPanel(this)); // now a JPanel
            revalidate();
            repaint();
        });

        quitButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StartScreen().setVisible(true);
        });
    }
}
