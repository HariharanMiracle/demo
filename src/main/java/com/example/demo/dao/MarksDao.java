package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Marks;

public interface MarksDao {
	public String insert(Marks mark);
	public List<Marks> findMark(String sid, int year, int term);
	public int edit(Marks marks);
	public int deleteMarks(Marks marks);
}
