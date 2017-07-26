package com.qac.library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

	@Test
	public void checkOutTest() {
		Inventory inv = new Inventory();
		Book b = new Book(1, "Barnaby Dickens", "The adventures of the curly wurly", 12.45, 1963, 14, true, 250, true);
		inv.addItem(b);

		User u = new User(123, "Barney1993", "113 Manchester ", 1612355652);

		Assert.assertTrue("Inventory not checked out ", inv.getInventory().size() == 1);

		inv.checkOut(b, u);

		Assert.assertTrue("Inventory checked out ", inv.getInventory().size() == 0);//check user has checked the book out
	}

	@Test
	public void checkInTest() {
		
		Inventory inv = new Inventory();
		Book b = new Book(1, "Barnaby Dickens", "The adventures of the curly wurly", 12.45, 1963, 14, true, 250, true);

		User u = new User(123, "Barney1993", "113 Manchester ", 1612355652);
		
		Assert.assertTrue("Inventory checked out ", inv.getInventory().size() == 0);
		
		inv.checkIn(b, u);
		
		Assert.assertTrue("Book is in inventory ", inv.getInventory().size() == 1);

	}
	
	@Test
	public void getInventoryTest() {
		Inventory inv = new Inventory();

		Assert.assertTrue("Inventory not returned correctly", inv.getInventory() != null);
	}

	@Test
	public void updatePriceCheck() {
		Inventory inv = new Inventory();
		Book b = new Book(1, "Barnaby Dickens", "The adventures of the curly wurly", 12.45, 1963, 14, true, 250, true);
		inv.addItem(b);
		Assert.assertTrue("Price is not correct ", b.getPrice() == 12.45);

		inv.updatePrice(b, 999.99);
		Assert.assertTrue("Price is not correct ", b.getPrice() == 999.99);

	}

	@Test
	public void addItemToInventoryTest() {

		Inventory inv = new Inventory();

		Book b = new Book(1, "Barnaby Dickens", "The adventures of the curly wurly", 12.45, 1963, 14, true, 250, true);
		inv.addItem(b);

		ArrayList<Item> i = inv.getInventory();
		Assert.assertTrue("Inventory size is not one", i.size() == 1);

	}

	@Test
	public void removeItemFromInventoryTest() {

		Inventory inv = new Inventory();
		Book b = new Book(1, "Barnaby Dickens", "The adventures of the curly wurly", 12.45, 1963, 14, true, 250, true);
		inv.addItem(b);

		ArrayList<Item> i = inv.getInventory();
		Assert.assertTrue("Inventory size is not one", i.size() == 1);

		inv.removeItem(b);

		inv.getInventory();
		Assert.assertTrue("Inventory size is not one", i.size() == 0);

	}

}
