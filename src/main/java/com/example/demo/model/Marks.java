package com.example.demo.model;

public class Marks {
	private int mid;
	private String sid;
	private String subId;
	private double marks;
	private int year;
	private int term;
	
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marks(int mid, String sid, String subId, double marks, int year, int term) {
		super();
		this.mid = mid;
		this.sid = sid;
		this.subId = subId;
		this.marks = marks;
		this.year = year;
		this.term = term;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "Marks [mid=" + mid + ", sid=" + sid + ", subId=" + subId + ", marks=" + marks + ", year=" + year
				+ ", term=" + term + "]";
	}
}
