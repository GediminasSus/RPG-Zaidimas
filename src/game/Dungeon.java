package game;

import java.util.*;

public class Dungeon {
    private final char[][] map;
    private final int startX, startY;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Position> monsters = new ArrayList<>();

    // Config constants
    private static final int MAX_ROOMS = 13;
    private static final int MAX_ATTEMPTS = 100;
    private static final int ROOM_MIN_SIZE = 3;
    private static final int ROOM_SIZE_VARIATION = 2; // results in 3–4
    private static final int MONSTER_SPAWN_TRIES = 20;

    private static final Random rand = new Random();

    public Dungeon(int width, int height) {
        map = new char[height][width];
        generateMap();
        Position start = findStartingPosition();
        startX = start.x();
        startY = start.y();
    }

    private void generateMap() {
        List<Position> roomCenters = new ArrayList<>();

        // Fill with walls
        for (int y = 0; y < map.length; y++)
            Arrays.fill(map[y], '#');

        int attempts = 0;
        int placed = 0;

        roomLoop:
        while (placed < MAX_ROOMS && attempts < MAX_ATTEMPTS) {
            attempts++;
            int rw = ROOM_MIN_SIZE + rand.nextInt(ROOM_SIZE_VARIATION);
            int rh = ROOM_MIN_SIZE + rand.nextInt(ROOM_SIZE_VARIATION);
            int rx = 1 + rand.nextInt(map[0].length - rw - 2);
            int ry = 1 + rand.nextInt(map.length - rh - 2);

            // spacing check
            for (int y = ry - 1; y < ry + rh + 1; y++) {
                for (int x = rx - 1; x < rx + rw + 1; x++) {
                    if (y < 0 || y >= map.length || x < 0 || x >= map[0].length) continue;
                    if (map[y][x] == '.') continue roomLoop;
                }
            }

            // carve room
            for (int y = ry; y < ry + rh; y++)
                for (int x = rx; x < rx + rw; x++)
                    map[y][x] = '.';

            int cx = rx + rw / 2;
            int cy = ry + rh / 2;
            roomCenters.add(new Position(cx, cy));
            rooms.add(new Room(rx, ry, rw, rh));
            placed++;

            // connect corridor
            if (roomCenters.size() > 1) {
                Position prev = roomCenters.get(rand.nextInt(roomCenters.size() - 1));
                int px = prev.x(), py = prev.y();

                while (px != cx) { map[py][px] = '.'; px += Integer.signum(cx - px); }
                while (py != cy) { map[py][px] = '.'; py += Integer.signum(cy - py); }
            }
        }

        // monster placement
        for (Room room : rooms) {
            for (int tries = 0; tries < MONSTER_SPAWN_TRIES; tries++) {
                int mx = room.x() + rand.nextInt(room.w());
                int my = room.y() + rand.nextInt(room.h());
                if (map[my][mx] == '.') {
                    monsters.add(new Position(mx, my));
                    break;
                }
            }
        }
    }

    private Position findStartingPosition() {
        // pick center of the first room
        if (!rooms.isEmpty()) {
            Room first = rooms.get(0);
            return new Position(first.x() + first.w() / 2, first.y() + first.h() / 2);
        }
        return new Position(1, 1);
    }

    // Getters
    public char[][] getMap() { return map; }
    public int getPlayerX() { return startX; }
    public int getPlayerY() { return startY; }
    public List<Position> getMonsterPositions() { return monsters; }

    // Helper types
    public record Room(int x, int y, int w, int h) {}
    public record Position(int x, int y) {}
}
