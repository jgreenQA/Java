package com.qac.battleships;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        boolean playerHasLost = false;
        boolean playerHasAnotherShot;
        String ship, direction;
        int x, y;
        String winner = "";

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("-- SETUP --\n");

        System.out.print("Enter your name: ");
        Player p1 = new Player(in.nextLine());
        Player p2 = new Player("Computer");

        p1.getNewGrid(SIZE);
        p2.getNewGrid(SIZE);

        while (p1.getTotalShipsRemaining() != 0) {
            p1.placeShip("patrol boat", rand.nextInt(SIZE), rand.nextInt(SIZE), "right");
            p1.placeShip("patrol boat", rand.nextInt(SIZE), rand.nextInt(SIZE), "up");
            p1.placeShip("battleship", rand.nextInt(SIZE), rand.nextInt(SIZE), "left");
            p1.placeShip("battleship", rand.nextInt(SIZE), rand.nextInt(SIZE), "down");
            p1.placeShip("submarine", rand.nextInt(SIZE), rand.nextInt(SIZE), "left");
            p1.placeShip("destroyer", rand.nextInt(SIZE), rand.nextInt(SIZE), "down");
            p1.placeShip("carrier", rand.nextInt(SIZE), rand.nextInt(SIZE), "right");

            /*
            p1.printGrid();
            System.out.println("\nPatrol Boats: " + p1.getPatrolBoatsRemaining() + "\nBattleships: " + p1.getBattleshipsRemaining() + "\nSubmarines: " +
                                p1.getSubmarinesRemaining() + "\nDestroyers: " + p1.getDestroyersRemaining() + "\nCarriers: " + p1.getCarriersRemaining());

            System.out.print("Enter the ship you want to place: "); ship = in.nextLine();
            System.out.print("x: "); x = Integer.parseInt(in.nextLine());
            System.out.print("y: "); y = Integer.parseInt(in.nextLine());
            System.out.print("direction: "); direction = in.nextLine();

            if (!p1.placeShip(ship, x, y, direction)) {
                System.out.println("Cannot place ship");
            }*/
        }

        while (p2.getTotalShipsRemaining() != 0) {
            p2.placeShip("patrol boat", rand.nextInt(SIZE), rand.nextInt(SIZE), "right");
            p2.placeShip("patrol boat", rand.nextInt(SIZE), rand.nextInt(SIZE), "up");
            p2.placeShip("battleship", rand.nextInt(SIZE), rand.nextInt(SIZE), "left");
            p2.placeShip("battleship", rand.nextInt(SIZE), rand.nextInt(SIZE), "down");
            p2.placeShip("submarine", rand.nextInt(SIZE), rand.nextInt(SIZE), "left");
            p2.placeShip("destroyer", rand.nextInt(SIZE), rand.nextInt(SIZE), "down");
            p2.placeShip("carrier", rand.nextInt(SIZE), rand.nextInt(SIZE), "right");
        }

        while (!playerHasLost) {
            p1.printGrid();

            playerHasAnotherShot = true;
            System.out.println(p1.getName() + "'s turn!");
            while (playerHasAnotherShot) {
                System.out.println("Enter your coordinates: ");
                System.out.print("x: ");
                x = in.nextInt();
                System.out.print("y: ");
                y = in.nextInt();

                if (p1.makeShotAt(p2, x, y)) {
                    System.out.println("\nHit!");
                } else {
                    System.out.println("\nMiss!");
                    playerHasAnotherShot = false;
                }
                playerHasLost = p2.hasLost();
            }

            playerHasAnotherShot = true;
            System.out.println(p2.getName() + "'s turn!");
            while (playerHasAnotherShot) {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);

                System.out.println(p2.getName() + " chose:\nx: " + x + "\ny: " + y);
                if (p2.makeShotAt(p1, x, y)) {
                    System.out.println("\nHit!");
                } else {
                    System.out.println("\nMiss!");
                    playerHasAnotherShot = false;
                }
            }

            if (p1.hasLost()) {
                winner = p2.getName();
                playerHasLost = true;
            } else if (p2.hasLost()) {
                winner = p2.getName();
                playerHasLost = true;
            }
        }
        System.out.println("\nGame Over!\n" + winner + " wins!");
    }
}
