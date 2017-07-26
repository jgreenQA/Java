package com.qac.battleships;

public class Grid {
    private Ship[][] grid;
    private int size;
    private int lastx = -1;
    private int lasty = -1;

    public Grid(int size) {
        this.size = size;
        grid = new Ship[size][size];
    }

    public boolean placeShip(Ship s, int x, int y, String direction) {
        if (grid[y][x] == null) {
            if (direction.toLowerCase().equals("left")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[y][x - i] = s;
                }
            } else if (direction.toLowerCase().equals("right")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[y][x + i] = s;
                }
            } else if (direction.toLowerCase().equals("up")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[y + i][x] = s;
                }
            } else if (direction.toLowerCase().equals("down")) {
                for (int i = 0; i < s.getSize(); i++) {
                    grid[y - i][x] = s;
                }
            }
            return true;
        }
        return false;
    }

    public void printGrid() {
        Ship s;
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int k = 0; k < size; k++) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }

            for (int j = 0; j < size; j++) {
                s = grid[i][j];

                if (j == 0) {
                    System.out.print(i + " ");
                }

                if (i == lasty && j == lastx) {
                    System.out.print("X ");
                } else if (s == null) {
                    System.out.print("~ ");
                } else if (s == Ship.PATROLBOAT) {
                    System.out.print("P ");
                } else if (s == Ship.BATTLESHIP) {
                    System.out.print("B ");
                } else if (s == Ship.SUBMARINE) {
                    System.out.print("S ");
                } else if (s == Ship.DESTROYER) {
                    System.out.print("D ");
                } else if (s == Ship.CARRIER) {
                    System.out.print("C ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkShot(int x, int y) {
        this.lastx = x;
        this.lasty = y;

        if (grid[y][x] != null) {
            grid[y][x] = null;
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

    public int getSize() {
        return size;
    }
}
