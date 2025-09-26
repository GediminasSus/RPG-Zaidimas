package game.main;

public class Room {
    private final int x;
    private final int y;
    private final int w;
    private final int h;

    public Room(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int x() { return x; }
    public int y() { return y; }
    public int w() { return w; }
    public int h() { return h; }

    public Position center() {
        return new Position(x + w / 2, y + h / 2);
    }

    public boolean contains(Position p) {
        return p.x() >= x && p.x() < x + w && p.y() >= y && p.y() < y + h;
    }

    
}
