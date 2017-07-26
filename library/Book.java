package com.qac.library;

public class Book extends Item {

	private int numberOfPages;

	private boolean hardBack;

	public Book(int id, String author, String title, double price, int yearWrote, int loanDuration, boolean fiction,
			int numberOfPages, boolean hardBack) {
		super(id, author, title, price, yearWrote, loanDuration, fiction);
		this.numberOfPages = numberOfPages;
		this.hardBack = hardBack;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public boolean isHardBack() {
		return hardBack;
	}

	public void setHardBack(boolean hardBack) {
		this.hardBack = hardBack;
	}
}
