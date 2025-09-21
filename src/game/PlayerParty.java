package game;
import game.lists.StartingEquipment;
import game.mechanics.Item;
import game.mechanics.PlayerCharacter;
import java.util.ArrayList;
import java.util.List;

public class PlayerParty {
    private final List<PlayerCharacter> members;
    private final List<Item> partyInventory;
    private int gold;
    

    public PlayerParty(List<PlayerCharacter> customMembers) {
        this.members = customMembers;
        this.partyInventory = new ArrayList<>();
        this.gold = 100;

        for (PlayerCharacter pc : customMembers) {
            StartingEquipment.assign(pc, this);
        }
    }

    public List<PlayerCharacter> getMembers() { return members; }
    public List<Item> getPartyInventory() { return partyInventory; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
}

