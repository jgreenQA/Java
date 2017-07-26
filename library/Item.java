package com.qac.library;

public abstract class Item {
	private String author;
	private String title;

	private int id;
	private double price;
	private int yearWrote;
	private int loanDuration;
	private boolean fiction;

	public Item(int id, String author, String title, double price, int yearWrote, int loanDuration, boolean fiction) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.price = price;
		this.yearWrote = yearWrote;
		this.loanDuration = loanDuration;
		this.fiction = fiction;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearWrote() {
		return yearWrote;
	}

	public void setYearWrote(int yearWrote) {
		this.yearWrote = yearWrote;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public boolean isFiction() {
		return fiction;
	}

	public void setFiction(boolean fiction) {
		this.fiction = fiction;
	}

}
