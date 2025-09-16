package game;
import game.mechanics.Item;
import game.mechanics.PlayerCharacter;
import java.util.ArrayList;
import java.util.List;

public class PlayerParty {
    private List<PlayerCharacter> members;
    private List<Item> partyInventory;
    private int gold;

    public PlayerParty(List<PlayerCharacter> customMembers) {
        this.members = customMembers;
        this.partyInventory = new ArrayList<>();
        this.gold = 100;

        // Optional: give starter items
       // for (PlayerCharacter pc : members) {
       //     pc.getInventory().add(PotionList.basicHealthPotion());
       // }
    }

    public List<PlayerCharacter> getMembers() { return members; }
    public List<Item> getPartyInventory() { return partyInventory; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
}

