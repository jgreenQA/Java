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

        this.patrolBoatsRemaining = Ship.PATROLBOAT.getAmount();
        this.battleshipsRemaining = Ship.BATTLESHIP.getAmount();
        this.submarinesRemaining = Ship.SUBMARINE.getAmount();
        this.destroyersRemaining = Ship.DESTROYER.getAmount();
        this.carriersRemaining = Ship.CARRIER.getAmount();
    }

    public void printGrid() {
        g.printGrid();
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
        if (s.toUpperCase().equals("P")) {
            s = "patrol boat";
        } else if (s.toUpperCase().equals("B")) {
            s = "battleship";
        } else if (s.toUpperCase().equals("S")) {
            s = "submarine";
        } else if (s.toUpperCase().equals("D")) {
            s = "destroyer";
        } else if (s.toUpperCase().equals("C")) {
            s = "carrier";
        }

        Ship ship = Ship.valueOf(s.replace(" ", "").toUpperCase());

        if (ship == Ship.PATROLBOAT) {
            if (patrolBoatsRemaining == 0 || x + Ship.PATROLBOAT.getSize() > g.getSize() || y + Ship.PATROLBOAT.getSize() > g.getSize() || x - Ship.PATROLBOAT.getSize() < 0 || y - Ship.PATROLBOAT.getSize() < 0) {
                return false;
            }
            patrolBoatsRemaining--;
        } else if (ship == Ship.BATTLESHIP) {
            if (battleshipsRemaining == 0 || x + Ship.BATTLESHIP.getSize() > g.getSize() || y + Ship.BATTLESHIP.getSize() > g.getSize() || x - Ship.BATTLESHIP.getSize() < 0 || y - Ship.BATTLESHIP.getSize() < 0) {
                return false;
            }
            battleshipsRemaining--;
        } else if (ship == Ship.SUBMARINE) {
            if (submarinesRemaining == 0 || x + Ship.SUBMARINE.getSize() > g.getSize() || y + Ship.SUBMARINE.getSize() > g.getSize() || x - Ship.SUBMARINE.getSize() < 0 || y - Ship.SUBMARINE.getSize() < 0) {
                return false;
            }
            submarinesRemaining--;
        } else if (ship == Ship.DESTROYER) {
            if (destroyersRemaining == 0 || x + Ship.DESTROYER.getSize() > g.getSize() || y + Ship.DESTROYER.getSize() > g.getSize() || x - Ship.DESTROYER.getSize() < 0 || y - Ship.DESTROYER.getSize() < 0) {
                return false;
            }
            destroyersRemaining--;
        } else if (ship == Ship.CARRIER) {
            if (carriersRemaining == 0 || x + Ship.CARRIER.getSize() > g.getSize() || y + Ship.CARRIER.getSize() > g.getSize() || x - Ship.CARRIER.getSize() < 0 || y - Ship.CARRIER.getSize() < 0) {
                return false;
            }
            carriersRemaining--;
        } else {
            return false;
        }
        return g.placeShip(ship, x, y, direction);
    }

    public int getTotalShipsRemaining() {
        return patrolBoatsRemaining + battleshipsRemaining + submarinesRemaining + destroyersRemaining + carriersRemaining;
    }

    public int getPatrolBoatsRemaining() {
        return patrolBoatsRemaining;
    }

    public int getBattleshipsRemaining() {
        return battleshipsRemaining;
    }

    public int getSubmarinesRemaining() {
        return submarinesRemaining;
    }

    public int getDestroyersRemaining() {
        return destroyersRemaining;
    }

    public int getCarriersRemaining() {
        return carriersRemaining;
    }
}
