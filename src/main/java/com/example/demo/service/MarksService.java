package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Marks;

public interface MarksService {
	public String insert(Marks mark);
	public List<Marks> findMark(String sid, int year, int term);
	public int edit(Marks marks);
	public int deleteMarks(Marks marks);
}
