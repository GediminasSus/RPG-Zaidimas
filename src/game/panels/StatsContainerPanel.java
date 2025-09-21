package game.panels;

import game.mechanics.PlayerCharacter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StatsContainerPanel extends JPanel {
    private final List<StatsPanel> panelList = new ArrayList<>();

    public StatsContainerPanel(List<PlayerCharacter> party) {
        setLayout(new GridLayout(2, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Party Stats"));

        for (PlayerCharacter pc : party) {
            StatsPanel panel = new StatsPanel();
            panel.displayCharacter(pc);
            panel.setPreferredSize(new Dimension(250, 150));
            panel.setFont(new Font("SansSerif", Font.PLAIN, 10));
            panelList.add(panel);
            add(panel);
        }
    }

    public void refreshStats(List<PlayerCharacter> party) {
        for (int i = 0; i < panelList.size(); i++) {
            StatsPanel panel = panelList.get(i);
            if (i < party.size()) {
                panel.update(party.get(i));
            }
        }
    }
}
