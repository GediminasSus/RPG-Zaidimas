package game.mechanics;

import game.enums.ItemType;

public abstract class Item {
    protected String name;
    protected String description;
    protected int goldValue; // base value

    protected Item(String name, String description, int goldValue) {
        if (goldValue < 0) throw new IllegalArgumentException("Gold value must be >= 0");
        this.name = name;
        this.description = description;
        this.goldValue = goldValue;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getGoldValue() { return goldValue; }

    // Selling price is always half
    public int getSellValue() {
        return goldValue / 2;
    }

    public abstract ItemType getType();
}
