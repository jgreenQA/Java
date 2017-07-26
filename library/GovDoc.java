package com.qac.library;

public class GovDoc extends Item {

	private boolean classified;

	private String country;

	public GovDoc(int id, String author, String title, double price, int yearWrote, int loanDuration, boolean fiction) {
		super(id, author, title, price, yearWrote, loanDuration, fiction);
		// TODO Auto-generated constructor stub
	}

	public boolean isClassified() {
		return classified;
	}

	public void setClassified(boolean classified) {
		this.classified = classified;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
