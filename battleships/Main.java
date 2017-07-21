package com.qac.battleships;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        boolean playerHasLost = false;
        boolean playerHasAnotherShot = true;
        String winner = "";

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter your name: ");
        Player p1 = new Player(in.nextLine());
        Player p2 = new Player("Computer");

        p1.getNewGrid(SIZE);
        p2.getNewGrid(SIZE);

        p1.placeShip("battleship", 0, 0, "up");

        int x, y;
        while (!playerHasLost) {
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
            while (playerHasAnotherShot) {
                x = rand.nextInt(SIZE + 1);
                y = rand.nextInt(SIZE + 1);

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
