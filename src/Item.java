
public abstract class Item {
    protected String name;
    protected String description;
    protected int goldValueBuy = 0;
    protected int goldValueSell = 0;

    public int getGoldValueBuy() { return goldValueBuy; }

    public int getGoldValueSell() { return goldValueSell; }

    public void setGoldValues(int buy, int sell) {
        this.goldValueBuy = buy;
        this.goldValueSell = sell;
    }


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public abstract String getType();
}