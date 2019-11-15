package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Progress;

@Repository
public class ProgressDaoImpl implements ProgressDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	class ProgressRowMapper implements RowMapper<Progress> {
		@Override
		public Progress mapRow(ResultSet rs, int rowNum) throws SQLException {
			Progress progress = new Progress();
			progress.setPid(rs.getInt("pid"));
			progress.setSid(rs.getString("sid"));
			progress.setYear(rs.getInt("year"));
			progress.setAvg(rs.getDouble("avg"));
			progress.setTot(rs.getDouble("tot"));
			progress.setPosition(rs.getInt("position"));
			progress.setSemester(rs.getInt("semester"));
			return progress;
		}
	}
	
	@Override
	public String insert(Progress progress) {
		// TODO Auto-generated method stub
		String msg = "";
		try{
			int x = jdbcTemplate.update("insert into progress (`sid`, `year`, `avg`, `tot`, `position`, `semester`) " + "values(?, ?, ?, ?, ?, ?)",
					new Object[] { progress.getSid(), progress.getYear(), progress.getAvg(), progress.getTot(), progress.getPosition(), progress.getSemester() });
			msg = "Progress added!";
		}
		catch(Exception e) {
			msg = progress.getPid() + " already exists!";
		}
		finally{
			return msg;
		}
	}

	@Override
	public Progress findProgress(String sid, int year, int semester) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("select * from progress where sid=? AND year=? AND semester=?", new Object[] { sid, year, semester },
					new BeanPropertyRowMapper<Progress>(Progress.class));
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public int edit(Progress progress) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `progress` SET `avg`='"+progress.getAvg()+"',`tot`='"+progress.getTot()+"' WHERE `pid`='"+progress.getPid()+"'";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int deleteProgress(Progress progress) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from progress where pid=?", new Object[] { progress.getPid() });
	}

}
