package com.qac.library;

public class Dissertation extends Item {

	private String subject;
	private String university;
	private String supervisor;

	public Dissertation(int id, String author, String title, double price, int yearWrote, int loanDuration, boolean fiction) {
		super(id, author, title, price, yearWrote, loanDuration, fiction);
		// TODO Auto-generated constructor stub
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}
