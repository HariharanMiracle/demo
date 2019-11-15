package com.example.demo.dao;

import com.example.demo.model.Progress;

public interface ProgressDao {
	public String insert(Progress progress);
	public Progress findProgress(String sid, int year, int semester);
	public int edit(Progress progress);
	public int deleteProgress(Progress progress);
}
