package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MarksDao;
import com.example.demo.model.Marks;

@Service
public class MarksServiceImpl implements MarksService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MarksDao marksDao;
	
	@Override
	public String insert(Marks mark) {
		// TODO Auto-generated method stub
		try {
			return marksDao.insert(mark);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Marks> findMark(String sid, int year, int term) {
		// TODO Auto-generated method stub
		try {
			return marksDao.findMark(sid, year, term);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public int edit(Marks marks) {
		// TODO Auto-generated method stub
		try {
			return marksDao.edit(marks);
		}
		catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteMarks(Marks marks) {
		// TODO Auto-generated method stub
		try {
			return marksDao.deleteMarks(marks);
		}
		catch(Exception e) {
			return 0;
		}
	}

}
