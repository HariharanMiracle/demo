package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.StudentDaoImpl.StudentRowMapper;
import com.example.demo.model.Marks;

@Repository
public class MarksDaoImpl implements MarksDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	class MarksRowMapper implements RowMapper<Marks> {
		@Override
		public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
			Marks marks = new Marks();
			marks.setMid(rs.getInt("mid"));
			marks.setSid(rs.getString("sid"));
			marks.setSubId(rs.getString("subId"));
			marks.setMarks(rs.getDouble("marks"));
			marks.setYear(rs.getInt("year"));
			marks.setTerm(rs.getInt("term"));
			return marks;
		}
	}
	
	@Override
	public String insert(Marks mark) {
		// TODO Auto-generated method stub
		String msg = "";
		try{
			int x = jdbcTemplate.update("insert into marks (`sid`, `subId`, `marks`, `year`, `term`) " + "values(?, ?, ?, ?, ?)",
					new Object[] { mark.getSid(), mark.getSubId(), mark.getMarks(), mark.getYear(), mark.getTerm() });
			msg = "Mark added!";
		}
		catch(Exception e) {
			msg = mark.getMid() + " already exists!";
		}
		finally{
			return msg;
		}
	}

	@Override
	public List<Marks> findMark(String sid, int year, int term) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.query("SELECT * FROM marks WHERE sid = '"+ sid +"' AND year = '"+ year +"' AND term = '"+ term +"'", new MarksRowMapper());
			
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public int edit(Marks marks) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `marks` SET `subId`='"+marks.getSubId()+"',`marks`='"+marks.getMarks()+"' WHERE `mid`='"+marks.getMid()+"'";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int deleteMarks(Marks marks) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from marks where mid=?", new Object[] { marks.getMid() });
	}

}
