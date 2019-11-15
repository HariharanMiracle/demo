package com.example.demo.model;

public class Student {
	private String sid;
	private String sname;
	private int year;
	private int semester;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sid, String sname, int year, int semester) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.year = year;
		this.semester = semester;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", year=" + year + ", semester=" + semester + "]";
	}
	
}
