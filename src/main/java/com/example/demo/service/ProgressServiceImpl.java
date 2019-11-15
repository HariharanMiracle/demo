package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProgressDao;
import com.example.demo.model.Progress;

@Service
public class ProgressServiceImpl implements ProgressService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProgressDao progressDao;
	
	@Override
	public String insert(Progress progress) {
		// TODO Auto-generated method stub
		return progressDao.insert(progress);
	}

	@Override
	public Progress findProgress(String sid, int year, int semester) {
		// TODO Auto-generated method stub
		return progressDao.findProgress(sid, year, semester);
	}

	@Override
	public int edit(Progress progress) {
		// TODO Auto-generated method stub
		return progressDao.edit(progress);
	}

	@Override
	public int deleteProgress(Progress progress) {
		// TODO Auto-generated method stub
		return progressDao.deleteProgress(progress);
	}

}
