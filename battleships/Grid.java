package com.qac.battleships;

public class Grid {
    private Ship[][] grid;

    public Grid(int size) {
        grid = new Ship[size][size];
    }

    public boolean placeShip(Ship s, int x, int y, String direction) {
        if (grid[x][y] == null) {
            if (direction.toLowerCase().equals("left")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[x - i][y] = s;
                }
            } else if (direction.toLowerCase().equals("right")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[x + i][y] = s;
                }
            } else if (direction.toLowerCase().equals("up")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[x][y + i] = s;
                }
            } else if (direction.toLowerCase().equals("down")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[x][y - i] = s;
                }
            }
            return true;
        }
        return false;
    }

    public boolean checkShot(int x, int y) {
        if (grid[x][y] != null) {
            grid[x][y] = null;
            return true;
        }
        return false;
    }

    public boolean hasLost() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
