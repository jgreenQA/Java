package com.qac.library;

import java.util.*;

public class Inventory {
	private HashMap<User, ArrayList<Item>> checkedOut;
	private ArrayList<Item> items;

	public Inventory() {
		checkedOut = new HashMap<>();
		items = new ArrayList<>();
	}

	public void checkOut(Item i, User u) {
		if (items.contains(i)) {
			items.remove(i);
			if (checkedOut.containsKey(u)) {
				checkedOut.get(u).add(i);
			} else {
				checkedOut.put(u, new ArrayList<>(Collections.singletonList(i))); //checkedOut.put(u, new ArrayList<>(Arrays.asList(i)));
			}
		}
	}

	public void checkIn(Item i, User u) {
		if (checkedOut.containsKey(u) && checkedOut.get(u).contains(i)) {
			checkedOut.get(u).remove(i);
			items.add(i);

			if (checkedOut.get(u).isEmpty()) {
				checkedOut.remove(u, new ArrayList<>());
			}
		} else if (checkedOut.isEmpty()) {
			addItem(i);
		}
	}

	public void addItem(Item i) {
		items.add(i);
	}

	public void removeItem(Item i) {
		items.remove(i);
	}

	public ArrayList<Item> getInventory() {
		return items;
	}

	public HashMap<User, ArrayList<Item>> getCheckedOut() {
		return checkedOut;
	}

	public void updatePrice(Item i, double price) {
		if (items.contains(i)) {
			i.setPrice(price);
		}
	}

	public void updateDuration(Item i, int duration) {
		if (items.contains(i)) {
			i.setLoanDuration(duration);
		}
	}

	public Item getItemByID(int id) {
		for (Item i : items) {
			if (i.getID() == id) {
				return i;
			}
		}
		return null;
	}

	public Item getUserByTitle(String title) {
		for (Item i : items) {
			if (i.getTitle().equals(title)) {
				return i;
			}
		}
		return null;
	}
}
