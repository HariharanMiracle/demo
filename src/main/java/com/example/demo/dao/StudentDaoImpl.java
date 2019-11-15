package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student obj = new Student();
			obj.setSid(rs.getString("sid"));
			obj.setSname(rs.getString("sname"));
			obj.setYear(rs.getInt("year"));
			obj.setSemester(rs.getInt("semester"));
			return obj;
		}
	}
	
	@Override
	public List<Student> findAllStudentsToManageMarkForThisTerm() {
		// TODO Auto-generated method stub
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String cdate = df.format(date);
		
		int year = Integer.parseInt(cdate.substring(0, 4));
		int month = Integer.parseInt(cdate.substring(5,7));
		int term = 0;
		
		if((month >= 0) && (month < 7)) {
			term = 1;
		}
		else {
			term = 2;
		}
		
		return jdbcTemplate.query("SELECT * FROM student WHERE sid NOT IN (SELECT sid FROM marks WHERE YEAR = '"+ year +"' AND term = '"+ term +"')", new StudentRowMapper());
	}

	@Override
	public List<Student> findAllStudentsToEditOrDeleteMarkForThisTerm() {
		// TODO Auto-generated method stub
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String cdate = df.format(date);
		
		int year = Integer.parseInt(cdate.substring(0, 4));
		int month = Integer.parseInt(cdate.substring(5,7));
		int term = 0;
		
		if((month >= 0) && (month < 7)) {
			term = 1;
		}
		else {
			term = 2;
		}
		
		return jdbcTemplate.query("SELECT * FROM student WHERE sid IN (SELECT sid FROM marks WHERE YEAR = '"+ year +"' AND term = '"+ term +"')", new StudentRowMapper());
	}

	@Override
	public List<Student> findAllStudents() {
		
		return jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());

	}

}
