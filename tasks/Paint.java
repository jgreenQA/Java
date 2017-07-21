package com.qac.tasks;

public enum Paint {
    CHEAPOMAX("CheapoMax", 20, 19.99, 10),
    AVERAGEJOES("AverageJoes", 15, 17.99, 11),
    DULUXOUROUSPAINTS("DuluxourousPaints", 10, 25, 20);

    private String name;
    private int liters;
    private double price;
    private int coverage;

    Paint(String name, int liters, double price, int coverage) {
        this.name = name;
        this.liters = liters;
        this.price = price;
        this.coverage = coverage;
    }

    public int getTotalCoverage() {
        return liters * coverage;
    }

    public double getTotalPrice() {
        return getTotalCoverage() * price;
    }

    public String getName() {
        return name;
    }

    public int getLiters() {
        return liters;
    }

    public double getPrice() {
        return price;
    }

    public int getCoverage() {
        return coverage;
    }
}
