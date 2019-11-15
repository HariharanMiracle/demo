package com.example.demo.service;

import com.example.demo.model.Progress;

public interface ProgressService {
	public String insert(Progress progress);
	public Progress findProgress(String sid, int year, int semester);
	public int edit(Progress progress);
	public int deleteProgress(Progress progress);
}
