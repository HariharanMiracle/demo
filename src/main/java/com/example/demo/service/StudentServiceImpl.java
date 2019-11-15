package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<Student> findAllStudentsToManageMarkForThisTerm() {
		// TODO Auto-generated method stub
		return studentDao.findAllStudentsToManageMarkForThisTerm();
	}

	@Override
	public List<Student> findAllStudentsToEditOrDeleteMarkForThisTerm() {
		// TODO Auto-generated method stub
		return studentDao.findAllStudentsToEditOrDeleteMarkForThisTerm();
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAllStudents();
	}

}
