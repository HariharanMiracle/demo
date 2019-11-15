package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	public List<Student> findAllStudentsToManageMarkForThisTerm();
	public List<Student> findAllStudentsToEditOrDeleteMarkForThisTerm();
	public List<Student> findAllStudents();
}
