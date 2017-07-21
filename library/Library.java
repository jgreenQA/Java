package com.qac.library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private int memberID;
    private HashMap<Item, Person> borrowedItems;
    private ArrayList<Person> people;
    private ArrayList<Item> inventory;

    public Library() {
        this.borrowedItems = new HashMap<>();
        this.people = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item i) {
        inventory.add(i);
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public void checkOut(Item i) {
        inventory.remove(i);
    }
}
