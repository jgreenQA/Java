package com.qac.library;

import java.util.ArrayList;
import java.util.Map;

public interface Library {
	static void main(String[] args) {
		UserBase ub = new UserBase();
		ub.addUser(new User(123, "Jack", "113 Manchester ", 1612354652));
		ub.addUser(new User(321, "Bob", "113 North London ", 2042845126));

		Inventory inv = new Inventory();
		inv.addItem(new Book(1, "Barnaby D", "The Adventures of Curly Wurly", 12.45, 1963, 14, true, 250, true));
		inv.addItem(new Book(2, "James B", "Photographer of Life", 9.99, 2014, 7, false, 200, false));
		inv.addItem(new Dissertation(3, "Jeff Nob", "How Far?", 12.25, 1999, 20, false));
		inv.addItem(new Dissertation(4, "Stavros G", "Greek Food", 11, 2014, 18, false));
		inv.addItem(new GovDoc(5, "Ned E", "A Tale of Dwarfs", 13.99, 1983, 16, true));
		inv.addItem(new GovDoc(6, "Jacob N", "Was it Now, or Then?", 19.99, 1997, 28, false));

		inv.checkOut(inv.getItemByID(1), ub.getUserByID(123));
		inv.checkOut(inv.getItemByID(2), ub.getUserByID(123));
		inv.checkOut(inv.getItemByID(3), ub.getUserByID(321));
		inv.checkOut(inv.getItemByID(4), ub.getUserByID(321));

		System.out.println("Inventory: ");
		for (Item i : inv.getInventory()) {
			System.out.println(i.getTitle() + " - £" + i.getPrice());
		}

		for (Map.Entry<User, ArrayList<Item>> entry : inv.getCheckedOut().entrySet()) {
			System.out.println("\nUser: " + entry.getKey().getUserName());
			for (Item i : entry.getValue()) {
				System.out.println("\tItem: " + i.getTitle());
			}
		}
	}
}
