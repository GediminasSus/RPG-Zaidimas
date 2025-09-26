package game.main;
import game.entities.PlayerCharacter;
import game.entities.itmes.Item;
import game.entities.itmes.lists.StartingEquipment;
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

    public void assignStartingEquipment() {
        for (PlayerCharacter pc : members) {
            StartingEquipment.assign(pc, this);
        }
    }
    public List<PlayerCharacter> getMembers() { return members; }
    public List<Item> getPartyInventory() { return partyInventory; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
}

