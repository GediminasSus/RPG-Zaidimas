

public class Dungeon {
    private final char[][] map;
    private final int startX, startY;
    private java.util.List<int[]> roomBounds = new java.util.ArrayList<>();
    private java.util.List<int[]> monsterPositions = new java.util.ArrayList<>();
    public java.util.List<int[]> getMonsterPositions() {
        return monsterPositions;
    }

    public Dungeon(int width, int height) {
        map = new char[height][width];
        generateMap();
        int[] start = findStartingPosition();
        startX = start[0];
        startY = start[1];
    }

    private void generateMap() {
        java.util.List<int[]> roomCenters = new java.util.ArrayList<>();
        //  walls
        for (int y = 0; y < map.length; y++)
            for (int x = 0; x < map[0].length; x++)
                map[y][x] = '#';

        // rooms
        java.util.Random rand = new java.util.Random();
        
        int attempts = 0;
        int placed = 0;
        roomLoop:
        while (placed < 13 && attempts < 100) {
            attempts++;
            int rw = 3 + rand.nextInt(2);
            int rh = 3 + rand.nextInt(2);
            int rx = 1 + rand.nextInt(map[0].length - rw - 2);
            int ry = 1 + rand.nextInt(map.length - rh - 2);

            // spacing
            for (int y = ry - 1; y < ry + rh + 1; y++) {
                for (int x = rx - 1; x < rx + rw + 1; x++) {
                    if (y < 0 || y >= map.length || x < 0 || x >= map[0].length) continue;
                    if (map[y][x] == '.') continue roomLoop;
                }
            }

            for (int y = ry; y < ry + rh; y++)
                for (int x = rx; x < rx + rw; x++)
                    map[y][x] = '.';

                    int cx = rx + rw / 2;
                    int cy = ry + rh / 2;
                    roomCenters.add(new int[]{cx, cy});
                    placed++;
                    roomBounds.add(new int[] { rx, ry, rw, rh });
                    
                    if (roomCenters.size() > 1) {
                        int[] prev = roomCenters.get(rand.nextInt(roomCenters.size() - 1));
                        int px = prev[0], py = prev[1];
                    
                        while (px != cx) { map[py][px] = '.'; px += Integer.signum(cx - px); }
                        
                        while (py != cy) { map[py][px] = '.'; py += Integer.signum(cy - py); }
                    }
                
            
        }
        // monster placement
        for (int[] bounds : roomBounds) {
            int rx = bounds[0];
            int ry = bounds[1];
            int rw = bounds[2];
            int rh = bounds[3];
        
            for (int tries = 0; tries < 20; tries++) {
                int mx = rx + rand.nextInt(rw);
                int my = ry + rand.nextInt(rh);
                if (map[my][mx] == '.') {
                    monsterPositions.add(new int[] { mx, my });
                    map[my][mx] = 'M'; 
                    break;
                }
            }
        }
        
    }

    private int[] findStartingPosition() {
        for (int y = 0; y < map.length; y++)
            for (int x = 0; x < map[0].length; x++)
                if (map[y][x] == '.') return new int[] {x, y};
        return new int[] {1, 1};
    }

    public char[][] getMap() { return map; }
    public int getPlayerX() { return startX; }
    public int getPlayerY() { return startY; }
    
}

