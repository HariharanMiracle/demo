package com.example.demo.model;

public class Progress {
	private int pid;
	private String sid;
	private int year;
	private double avg;
	private double tot;
	private int position;
	private int semester;
	
	public Progress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Progress(int pid, String sid, int year, double avg, double tot, int position, int semester) {
		super();
		this.pid = pid;
		this.sid = sid;
		this.year = year;
		this.avg = avg;
		this.tot = tot;
		this.position = position;
		this.semester = semester;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getTot() {
		return tot;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Progress [pid=" + pid + ", sid=" + sid + ", year=" + year + ", avg=" + avg + ", tot=" + tot
				+ ", position=" + position + ", semester=" + semester + "]";
	}
	
}
