package game.panels;
import java.awt.*;
import java.util.List;
import javax.swing.*;

import game.mechanics.PlayerCharacter;

public class StatsContainerPanel extends JPanel {
    public StatsContainerPanel(List<PlayerCharacter> party) {
        setLayout(new GridLayout(2, 2, 5, 5)); 
        setBorder(BorderFactory.createTitledBorder("Party Stats"));

        for (PlayerCharacter pc : party) {
            StatsPanel panel = new StatsPanel();
            panel.displayCharacter(pc);
            panel.setPreferredSize(new Dimension(250, 150));
            panel.setFont(new Font("SansSerif", Font.PLAIN, 10)); 
            add(panel);
        }
    }
}
