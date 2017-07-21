package com.qac.battleships;

public enum Ship {
    PATROL_BOAT("patrol boat", 2, 2),
    BATTLESHIP("battleship", 2, 3),
    SUBMARINE("submarine", 1, 3),
    DESTROYER("destroyer", 1, 4),
    CARRIER("carrier", 1, 5);

    private String name;
    private int amount;
    private int size;

    Ship(String name, int amount, int size) {
        this.name = name;
        this.amount = amount;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getSize() {
        return size;
    }
}
