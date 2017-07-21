package com.qac.battleships;

public class Player {
    private String name;
    private Grid g;

    private int patrolBoatsRemaining;
    private int battleshipsRemaining;
    private int submarinesRemaining;
    private int destroyersRemaining;
    private int carriersRemaining;

    public Player(String name) {
        this.name = name;

        this.patrolBoatsRemaining = Ship.PATROL_BOAT.getAmount();
        this.battleshipsRemaining = Ship.BATTLESHIP.getAmount();
        this.submarinesRemaining = Ship.SUBMARINE.getAmount();
        this.destroyersRemaining = Ship.DESTROYER.getAmount();
        this.carriersRemaining = Ship.CARRIER.getAmount();
    }

    private Grid getGrid() {
        return g;
    }

    public void getNewGrid(int size) {
        g = new Grid(size);
    }

    public String getName() {
        return name;
    }

    public boolean makeShotAt(Player p, int x, int y) {
        return p.getGrid().checkShot(x, y);
    }

    public boolean hasLost() {
        return g.hasLost();
    }

    public boolean placeShip(String s, int x, int y, String direction) {
        Ship ship = Ship.valueOf(s.toLowerCase());

        if (ship == Ship.PATROL_BOAT) {
            if (patrolBoatsRemaining == 0) {
                return false;
            }
            patrolBoatsRemaining--;
        } else if (ship == Ship.BATTLESHIP) {
            if (battleshipsRemaining == 0) {
                return false;
            }
            battleshipsRemaining--;
        } else if (ship == Ship.SUBMARINE) {
            if (submarinesRemaining == 0) {
                return false;
            }
            submarinesRemaining--;
        } else if (ship == Ship.DESTROYER) {
            if (destroyersRemaining == 0) {
                return false;
            }
            destroyersRemaining--;
        } else if (ship == Ship.CARRIER) {
            if (carriersRemaining == 0) {
                return false;
            }
            carriersRemaining--;
        } else {
            return false;
        }

        return g.placeShip(ship, x, y, direction);
    }
}
