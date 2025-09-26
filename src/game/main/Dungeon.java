package game.main;

import java.util.*;

public class Dungeon {
    private final char[][] map;
    private final int startX;
    private final int startY;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Position> monsters = new ArrayList<>();

    private static final int MAX_ROOMS = 13;
    private static final int MAX_ATTEMPTS = 100;
    private static final int ROOM_MIN_SIZE = 3;
    private static final int ROOM_SIZE_VARIATION = 2; 
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
        fillWithWalls();
        placeRoomsAndCorridors();
        placeMonsters();
    }

    private void fillWithWalls() {
        for (char[] row : map) {
            Arrays.fill(row, '#');
        }
    }

    private void placeRoomsAndCorridors() {
    List<Position> roomCenters = new ArrayList<>();
    int attempts = 0;
    int placed = 0;

    
        while (placed < MAX_ROOMS && attempts < MAX_ATTEMPTS) {
        attempts++;

        Room room = generateRandomRoom();
        if (!canPlaceRoom(room)) continue;

        carveRoom(room);
        rooms.add(room);

        Position center = room.center();
        roomCenters.add(center);
        placed++;

            if (roomCenters.size() > 1) {
            connectRooms(center, roomCenters.get(rand.nextInt(roomCenters.size() - 1)));
            }
        }
    }

    private Room generateRandomRoom() {
        int rw = ROOM_MIN_SIZE + rand.nextInt(ROOM_SIZE_VARIATION);
        int rh = ROOM_MIN_SIZE + rand.nextInt(ROOM_SIZE_VARIATION);
        int rx = 1 + rand.nextInt(map[0].length - rw - 2);
        int ry = 1 + rand.nextInt(map.length - rh - 2);
        return new Room(rx, ry, rw, rh);
    }

    private boolean canPlaceRoom(Room room) {
        for (int y = room.y() - 1; y < room.y() + room.h() + 1; y++) {
            for (int x = room.x() - 1; x < room.x() + room.w() + 1; x++) {
                if (y < 0 || y >= map.length || x < 0 || x >= map[0].length) continue;
                if (map[y][x] == '.') return false;
            }
        }
        return true;
    }

    private void carveRoom(Room room) {
        for (int y = room.y(); y < room.y() + room.h(); y++) {
            for (int x = room.x(); x < room.x() + room.w(); x++) {
                map[y][x] = '.';
            }
        }
    }

    private void connectRooms(Position a, Position b) {
        int x = a.x(); 
        int y = a.y();
            while (x != b.x()) { map[y][x] = '.'; x += Integer.signum(b.x() - x); }
            while (y != b.y()) { map[y][x] = '.'; y += Integer.signum(b.y() - y); }
        }

    private void placeMonsters() {
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
    
}
